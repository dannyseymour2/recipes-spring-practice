package com.example.recipes.service;

import com.example.recipes.domain.Recipe;
import com.example.recipes.repositories.RecipeRepository;
import java.util.List;
import java.util.Optional;
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

  @Override
  public Recipe findById(Long id) {

    Optional<Recipe> recipe = recipeRepository.findById(id);
    if(!recipe.isPresent()){
      throw new RuntimeException("Recipe does not exist");
    } else{
      return recipe.get();
    }
  }
}
