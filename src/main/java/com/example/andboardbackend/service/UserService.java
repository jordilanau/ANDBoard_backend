package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.User;

import java.util.List;

public interface UserService {

  List<User> findAllUsers();
  User findUserById(int userId);
  void saveUser(User user);
  void deleteUserById(int userId);

}
