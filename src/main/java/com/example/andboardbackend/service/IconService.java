package com.example.andboardbackend.service;

import com.example.andboardbackend.entity.Icon;

import java.util.List;
import java.util.Optional;

public interface IconService {

  List<Icon> findAllIcons();
  Icon findIconById(int iconId);
  void saveIcon(Icon icon);
  void deleteIconById(int iconId);

  Optional<Icon> findIconByCategory(String category);

}
