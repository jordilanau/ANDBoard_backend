package com.example.andboardbackend.repository;

import com.example.andboardbackend.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {

  Optional<Keyword> findKeywordByValue(String value);

}
