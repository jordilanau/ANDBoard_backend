package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.Card;
import com.example.andboardbackend.entity.Keyword;

import java.util.List;

public interface CardService {

  List<Card> findAllCards();
  Card findCardById(int cardId);
  void saveCard(Card card);
  void deleteCardById(int cardId);
  List<Card> searchCards(String search);
  List<Card> searchCards(String search, Keyword keyword);
  List<Card> findAllByKeywords(Keyword keyword);

}
