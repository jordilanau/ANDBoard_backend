package com.example.andboardbackend.rest;

import com.example.andboardbackend.entity.User;
import com.example.andboardbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public List<User> findAllUsers() {
    return userService.findAllUsers();
  }

  @GetMapping("/users/{userId}")
  public User findUserById(@PathVariable int userId) {
    User user = userService.findUserById(userId);

    if (user == null) {
      throw new RuntimeException("User id not found: " + userId);
    }

    return user;
  }

  @DeleteMapping("/users/{userId}")
  public void deleteUserById(@PathVariable int userId) {
    User user = userService.findUserById(userId);

    if (user == null) {
      throw new RuntimeException("User id not found: " + userId);
    }

    userService.deleteUserById(userId);
  }

}
