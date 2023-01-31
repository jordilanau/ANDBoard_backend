package com.example.andboardbackend.rest;

import com.example.andboardbackend.entity.Icon;
import com.example.andboardbackend.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IconController {

  private final IconService iconService;

  @Autowired
  public IconController(IconService iconService) {
    this.iconService = iconService;
  }

  @GetMapping("/icons")
  public List<Icon> findAllIcons() {
    return iconService.findAllIcons();
  }

  @GetMapping("/icons/{iconId}")
  public Icon findIconById(@PathVariable int iconId) {
    Icon icon = iconService.findIconById(iconId);

    if (icon == null) {
      throw new RuntimeException("Icon id not found: " + iconId);
    }

    return icon;
  }

  @PostMapping("/icons")
  public Icon addCard(@RequestBody Icon icon) {
    // in case an id is passed in the body of the request, set id to 0
    // this if to force a save of a new item instead of update
    icon.setId(0);

    iconService.saveIcon(icon);
    return icon;
  }

  @DeleteMapping("/icons/{iconId}")
  public void deleteIconById(@PathVariable int iconId) {
    Icon icon = iconService.findIconById(iconId);

    if (icon == null) {
      throw new RuntimeException("Icon id not found: " + iconId);
    }

    iconService.deleteIconById(iconId);
  }

}
