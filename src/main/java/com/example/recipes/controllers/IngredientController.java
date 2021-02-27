package com.example.recipes.controllers;

import com.example.recipes.service.IngredientService;
import com.example.recipes.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class IngredientController {

  private final RecipeService recipeService;
  private final IngredientService ingredientService;


  public IngredientController(RecipeService recipeService,
      IngredientService ingredientService) {
    this.recipeService = recipeService;
    this.ingredientService = ingredientService;
  }

  @GetMapping("/recipe/{recipeId}/ingredients")
  public String listIngredients(@PathVariable("recipeId")String recipeId, Model model){
    log.debug("getting ingredients for recipe "+recipeId);
    model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(recipeId)));
    return "/recipe/ingredient/list";

  }

  @GetMapping("recipe/{recipeId}/ingredient/{id}/show")
  public String showRecipeIngredient(@PathVariable("recipeId")String recipeId,
      @PathVariable("id")String id, Model model){
      model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId), Long.valueOf(id)));
      return "recipe/ingredient/show";
  }
}
