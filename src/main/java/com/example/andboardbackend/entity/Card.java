package com.example.andboardbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
public class Card extends BaseEntity {

  @Column(name = "category")
  private String category;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "link")
  private String link;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "card_keyword", joinColumns = @JoinColumn(name = "card_id"), inverseJoinColumns = @JoinColumn(name = "keyword_id"))
  private List<Keyword> keywords;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "icon_id")
  private Icon icon;

  public Card(String category, String title, String description, String link, Icon icon) {
    super();
    this.category = category;
    this.title = title;
    this.description = description;
    this.link = link;
    this.icon = icon;
  }

  public Card(String category, String title, String description, String link) {
    this.category = category;
    this.title = title;
    this.description = description;
    this.link = link;
    this.keywords = new ArrayList<>();
  }

  public void addKeyword(Keyword keyword) {
    if (keywords == null) {
      keywords = new ArrayList<>();
    }
    keywords.add(keyword);
  }

}
