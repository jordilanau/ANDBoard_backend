package com.example.andboardbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "createdAt")
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "updatedAt")
  private LocalDateTime updatedAt;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "role")
  private Role role = Role.user;

  public User(LocalDateTime updatedAt, String email, String password) {
    this.updatedAt = LocalDateTime.now();
    this.email = email;
    this.password = password;
  }

}
