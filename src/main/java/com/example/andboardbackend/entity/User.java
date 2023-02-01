package com.example.andboardbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  @JsonIgnore
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Role role = Role.user;

  public User(String email, String password) {
    super();
    this.email = email;
    this.password = password;
  }

  public User(String email, String password, Role role) {
    super();
    this.email = email;
    this.password = password;
    this.role = role;
  }

}
