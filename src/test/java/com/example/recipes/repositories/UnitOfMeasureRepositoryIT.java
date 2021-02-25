package com.example.recipes.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.example.recipes.domain.UnitOfMeasure;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

@DataJpaTest
class UnitOfMeasureRepositoryIT {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;


  @BeforeEach
  void setUp() {
  }

  @Test
  void findByDescription() {
    Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
    assertEquals("Teaspoon",teaspoon.get().getDescription());
  }

  @Test
  void findByDescriptionCup() {
    Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Cup");
    assertEquals("Cup",teaspoon.get().getDescription());
  }
}
