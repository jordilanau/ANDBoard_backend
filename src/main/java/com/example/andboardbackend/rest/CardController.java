package com.example.andboardbackend.rest;

import com.example.andboardbackend.entity.Card;
import com.example.andboardbackend.entity.Icon;
import com.example.andboardbackend.entity.Keyword;
import com.example.andboardbackend.service.CardService;
import com.example.andboardbackend.service.IconService;
import com.example.andboardbackend.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CardController {

  private final CardService cardService;
  private final KeywordService keywordService;
  private final IconService iconService;

  @Autowired
  public CardController(CardService cardService, KeywordService keywordService, IconService iconService) {
    this.cardService = cardService;
    this.keywordService = keywordService;
    this.iconService = iconService;
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

  @GetMapping("/cards/search")
  public List<Card> searchCards(@RequestParam String input) {
    System.out.println("inside search: " + input);
    return cardService.searchCards(input);
  }

  @PostMapping("/cards")
  public Card addCard(@RequestBody HashMap<String, String> requestData) {
    Card card = new Card(requestData.get("category"), requestData.get("title"), requestData.get("description"),
                         requestData.get("link"));
    Optional<Icon> iconResult = iconService.findIconByCategory(requestData.get("category"));
    if (iconResult.isPresent()) {
      card.setIcon(iconResult.get());
    }
    String[] keywords = requestData.get("keywords").split(",");
    List<Keyword> keywordsList = new ArrayList<>();
    for (String input : keywords) {
      Optional<Keyword> keywordResult = keywordService.findKeywordByValue(input.trim());
      if (keywordResult.isPresent()) {
        keywordsList.add(keywordResult.get());
      } else {
        keywordsList.add(new Keyword(input.trim()));
      }
    }
    card.setKeywords(keywordsList);

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
