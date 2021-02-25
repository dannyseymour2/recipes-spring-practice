package com.example.recipes.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class CategoryTest {

  Category category;

  @BeforeAll
  public void setUp(){
    category = new Category();
  }

  @Test
  void getId() {
    Long idValue = 4l;
    category.setId(idValue);
    assertEquals(idValue, category.getId());
  }

  @Test
  void getDescription() {
  }

  @Test
  void getRecipes() {
  }
}
