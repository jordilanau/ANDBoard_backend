package com.example.andboardbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
public class Card {

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
    this.category = category;
    this.title = title;
    this.description = description;
    this.link = link;
    this.icon = icon;
  }

  public void addKeyword(Keyword keyword) {
    if (keywords == null) {
      keywords = new ArrayList<>();
    }
    keywords.add(keyword);
  }

}
