package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.Card;

import java.util.List;

public interface CardService {

  List<Card> findAllCards();
  Card findCardById(int cardId);
  void saveCard(Card card);
  void deleteCardById(int cardId);

}
