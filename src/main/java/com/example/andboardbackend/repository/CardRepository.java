package com.example.andboardbackend.repository;

import com.example.andboardbackend.entity.Card;
import com.example.andboardbackend.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

  List<Card> findAllByCategoryContainsIgnoreCaseOrTitleContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrLinkContainsIgnoreCase(
          String category, String title, String description,
          String link);

  List<Card> findAllByKeywords(Keyword keyword);

}
