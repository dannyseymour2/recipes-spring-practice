package com.example.recipes.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.recipes.command.RecipeCommand;
import com.example.recipes.converters.RecipeCommandToRecipe;
import com.example.recipes.converters.RecipeToRecipeCommand;

import com.example.recipes.domain.Recipe;
import com.example.recipes.repositories.RecipeRepository;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RecipeServiceImplTest {

  RecipeServiceImpl recipeService;

  @Mock
  RecipeRepository recipeRepository;

  RecipeCommandToRecipe recipeCommandToRecipe;
  RecipeToRecipeCommand recipeToRecipeCommand;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe,
        recipeToRecipeCommand);
  }

  @Test
  void getAllRecipes() {
    Recipe recipe = new Recipe();
    List<Recipe> recipes = new LinkedList<>();
    recipes.add(recipe);
    when(recipeRepository.findAll()).thenReturn(recipes);
    List<Recipe> recipeList = recipeService.getAllRecipes();
    assertEquals(1, recipeList.size());
    verify(recipeRepository, times(1)).findAll();
  }

}
