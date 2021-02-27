package com.example.recipes.service;

import com.example.recipes.command.IngredientCommand;
import com.example.recipes.converters.IngredientToIngredientCommand;
import com.example.recipes.domain.Recipe;
import com.example.recipes.repositories.IngredientRepository;
import com.example.recipes.repositories.RecipeRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IngredientServiceImpl implements IngredientService{

  private final RecipeRepository recipeRepository;
  private final IngredientToIngredientCommand ingredientToIngredientCommand;

  public IngredientServiceImpl(
      RecipeRepository recipeRepository,
      IngredientToIngredientCommand ingredientToIngredientCommand) {
    this.recipeRepository = recipeRepository;
    this.ingredientToIngredientCommand = ingredientToIngredientCommand;
  }

  @Override
  public IngredientCommand findByRecipeIdAndId(Long recipeId, Long id) {
    Optional<Recipe> recipeOpt = recipeRepository.findById(recipeId);
    if(!recipeOpt.isPresent()){
      throw new RuntimeException("Recipe not found id "+recipeId);
    }
    Recipe recipe = recipeOpt.get();
    Optional<IngredientCommand> ingredientCommand = recipe.getIngredients().stream()
        .filter(ingredient -> ingredient.getId().equals(id))
        .map(ingredientToIngredientCommand::convert).findFirst();
    if(!ingredientCommand.isPresent()){
      log.error("xingredient does not exist");
    }
    return ingredientCommand.orElse(null);
  }
}
