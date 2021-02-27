package com.example.recipes.service;

import com.example.recipes.command.RecipeCommand;
import com.example.recipes.converters.RecipeCommandToRecipe;
import com.example.recipes.converters.RecipeToRecipeCommand;

import com.example.recipes.domain.Recipe;
import com.example.recipes.repositories.RecipeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

  private final RecipeRepository recipeRepository;
  private final RecipeCommandToRecipe recipeCommandToRecipe;
  private final RecipeToRecipeCommand recipeToRecipeCommand;


  public RecipeServiceImpl(RecipeRepository recipeRepository,
      RecipeCommandToRecipe recipeCommandToRecipe,
      RecipeToRecipeCommand recipeToRecipeCommand) {
    this.recipeRepository = recipeRepository;
    this.recipeCommandToRecipe = recipeCommandToRecipe;
    this.recipeToRecipeCommand = recipeToRecipeCommand;
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

  @Override
  @Transactional
  public RecipeCommand saveRecipeCommand(RecipeCommand command) {
    Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
    Recipe savedRecipe = recipeRepository.save(detachedRecipe);
    log.debug("saved recipe" + savedRecipe.getId());
    return recipeToRecipeCommand.convert(savedRecipe);
  }
}
