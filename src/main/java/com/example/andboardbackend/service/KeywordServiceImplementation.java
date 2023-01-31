package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.Keyword;
import com.example.andboardbackend.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KeywordServiceImplementation implements KeywordService {

  private final KeywordRepository keywordRepository;

  @Autowired
  public KeywordServiceImplementation(KeywordRepository keywordRepository) {
    this.keywordRepository = keywordRepository;
  }

  @Override
  public Optional<Keyword> findKeywordByValue(String value) {
    return keywordRepository.findKeywordByValue(value);
  }

}
