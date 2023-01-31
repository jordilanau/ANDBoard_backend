package com.example.andboardbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "icon")
@Getter
@Setter
@NoArgsConstructor
public class Icon extends BaseEntity {

  @Column(name = "category", unique = true)
  private String category;

  @Column(name = "icon_link")
  private String iconLink;

  public Icon(String category, String iconLink) {
    super();
    this.category = category;
    this.iconLink = iconLink;
  }

}
