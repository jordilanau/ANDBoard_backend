package com.example.andboardbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "keyword")
@Getter
@Setter
@NoArgsConstructor
public class Keyword {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at")
  @CreatedDate
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  @LastModifiedDate
  private Date updatedAt;

  @Column(name = "value")
  private String value;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "card_keyword", joinColumns = @JoinColumn(name = "keyword_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
  private List<Card> cards;

  public Keyword(String value) {
    this.value = value;
  }

  public Keyword(String keyword, Card card) {

  }

}

