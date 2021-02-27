package com.example.recipes.service;

import com.example.recipes.command.RecipeCommand;
import com.example.recipes.domain.Recipe;
import java.util.List;
import java.util.Optional;

public interface RecipeService {

  List<Recipe> getAllRecipes();

  Recipe findById(Long id);

  RecipeCommand saveRecipeCommand(RecipeCommand command);

}
