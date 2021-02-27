package com.example.recipes.service;

import com.example.recipes.command.IngredientCommand;

public interface IngredientService {


  IngredientCommand findByRecipeIdAndId(Long recipeId, Long id);
}
