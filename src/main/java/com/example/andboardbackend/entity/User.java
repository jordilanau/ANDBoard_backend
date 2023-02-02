package com.example.andboardbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails {

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  @JsonIgnore
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role")
  private Role role;

  public User(String email, String password) {
    super();
    this.email = email;
    this.password = password;
    this.role = Role.USER;
  }

  public User(String email, String password, Role role) {
    super();
    this.email = email;
    this.password = password;
    this.role = role;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
