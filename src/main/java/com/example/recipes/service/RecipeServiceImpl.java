package com.example.recipes.service;

import com.example.recipes.domain.Recipe;
import com.example.recipes.repositories.RecipeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{

  private final RecipeRepository recipeRepository;


  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public List<Recipe> getAllRecipes() {
    return recipeRepository.findAll();
  }
}
