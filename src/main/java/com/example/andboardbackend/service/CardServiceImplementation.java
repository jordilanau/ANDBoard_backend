package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.Card;
import com.example.andboardbackend.entity.Keyword;
import com.example.andboardbackend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImplementation implements CardService {

  private final CardRepository cardRepository;

  @Autowired
  public CardServiceImplementation(CardRepository cardRepository) {
    this.cardRepository = cardRepository;
  }

  @Override
  public List<Card> findAllCards() {
    return cardRepository.findAll();
  }

  @Override
  public Card findCardById(int cardId) {
    Optional<Card> result = cardRepository.findById(cardId);
    if (result.isPresent()) {
      return result.get();
    }
    return null;
  }

  @Override
  public void saveCard(Card card) {
    cardRepository.save(card);
  }

  @Override
  public void deleteCardById(int cardId) {
    cardRepository.deleteById(cardId);
  }

  @Override
  public List<Card> searchCards(String search) {
    return cardRepository.findAllByCategoryContainsIgnoreCaseOrTitleContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrLinkContainsIgnoreCase(
            search, search, search, search);
  }

  @Override
  public List<Card> findAllByKeywords(Keyword keyword) {
    return cardRepository.findAllByKeywords(keyword);
  }

}
