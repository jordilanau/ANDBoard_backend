package com.example.andboardbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at")
  @CreatedDate
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  @LastModifiedDate
  private Date updatedAt;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Role role = Role.user;

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public User(String email, String password, Role role) {
    this.email = email;
    this.password = password;
    this.role = role;
  }

}
