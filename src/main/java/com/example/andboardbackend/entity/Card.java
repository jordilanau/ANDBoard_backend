package com.example.andboardbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "card")
@Data
@NoArgsConstructor
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "createdAt")
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "updatedAt")
  private LocalDateTime updatedAt;

  @Column(name = "category")
  private String category;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "link")
  private String link;

  @Column(name = "keywords")
  private List<String> keywords;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "iconId")
  private Icon icon;

  public Card(String category, String title, String description, String link, List<String> keywords, Icon icon) {
    this.updatedAt = LocalDateTime.now();
    this.category = category;
    this.title = title;
    this.description = description;
    this.link = link;
    this.keywords = keywords;
    this.icon = icon;
  }

}
