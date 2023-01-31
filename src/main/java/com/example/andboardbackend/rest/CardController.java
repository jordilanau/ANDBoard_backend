package com.example.andboardbackend.rest;

import com.example.andboardbackend.entity.Card;
import com.example.andboardbackend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {

  private final CardService cardService;

  @Autowired
  public CardController(CardService cardService) {
    this.cardService = cardService;
  }

  @GetMapping("/cards")
  public List<Card> findAllCards() {
    return cardService.findAllCards();
  }

  @GetMapping("/cards/{cardId}")
  public Card findCardById(@PathVariable int cardId) {
    Card card = cardService.findCardById(cardId);

    if (card == null) {
      throw new RuntimeException("Card id not found: " + cardId);
    }

    return card;
  }

  @PostMapping("/cards")
  public Card addCard(@RequestBody Card card) {
    // in case an id is passed in the body of the request, set id to 0
    // this if to force a save of a new item instead of update
    card.setId(0);

    cardService.saveCard(card);
    return card;
  }

  @DeleteMapping("/cards/{cardId}")
  public void deleteCardById(@PathVariable int cardId) {
    Card card = cardService.findCardById(cardId);

    if (card == null) {
      throw new RuntimeException("Card id not found: " + cardId);
    }

    cardService.deleteCardById(cardId);
  }

}
