package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.Keyword;

import java.util.Optional;

public interface KeywordService {

  Optional<Keyword> findKeywordByValue(String value);

}
