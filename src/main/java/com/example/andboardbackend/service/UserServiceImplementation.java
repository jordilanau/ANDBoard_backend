package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.User;
import com.example.andboardbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImplementation(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> findAllUsers() {
    System.out.println("inside user service");
    return userRepository.findAll();
  }

  @Override
  public User findUserById(int userid) {
    Optional<User> result = userRepository.findById(userid);
    if (result.isPresent()) {
      return result.get();
    }
    return null;
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUserById(int userId) {
    userRepository.deleteById(userId);
  }

}
