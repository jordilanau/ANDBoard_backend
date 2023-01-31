package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.Icon;
import com.example.andboardbackend.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconServiceImplementation implements IconService {

  private final IconRepository iconRepository;

  @Autowired
  public IconServiceImplementation(IconRepository iconRepository) {
    this.iconRepository = iconRepository;
  }

  @Override
  public List<Icon> findAllIcons() {
    return iconRepository.findAll();
  }

  @Override
  public Icon findIconById(int iconId) {
    Optional<Icon> result = iconRepository.findById(iconId);
    if (result.isPresent()) {
      return result.get();
    }
    return null;
  }

  @Override
  public void saveIcon(Icon icon) {
    iconRepository.save(icon);
  }

  @Override
  public void deleteIconById(int iconId) {
    iconRepository.deleteById(iconId);
  }

  @Override
  public Optional<Icon> findIconByCategory(String category) {
    return iconRepository.findIconByCategory(category);
  }

}
