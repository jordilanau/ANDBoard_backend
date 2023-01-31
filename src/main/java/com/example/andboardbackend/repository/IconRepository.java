package com.example.andboardbackend.repository;

import com.example.andboardbackend.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IconRepository extends JpaRepository<Icon, Integer> {

  Optional<Icon> findIconByCategory(String category);

}
