package com.example.andboardbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "icon")
@Getter
@Setter
@NoArgsConstructor
public class Icon {

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

  @Column(name = "category", unique = true)
  private String category;

  @Column(name = "icon_link")
  private String iconLink;

  public Icon(String category, String iconLink) {
    this.category = category;
    this.iconLink = iconLink;
  }

}
