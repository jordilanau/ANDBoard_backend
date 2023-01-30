package com.example.andboardbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "icon")
@Data
@NoArgsConstructor
public class Icon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "createdAt")
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "updatedAt")
  private LocalDateTime updatedAt;

  @Column(name = "category", unique = true)
  private String category;

  @Column(name = "iconLink")
  private String iconLink;

  @OneToMany(mappedBy = "icon", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Card> cards;

  public Icon(String category, String iconLink, List<Card> cards) {
    this.updatedAt = LocalDateTime.now();
    this.category = category;
    this.iconLink = iconLink;
    this.cards = cards;
  }

}
