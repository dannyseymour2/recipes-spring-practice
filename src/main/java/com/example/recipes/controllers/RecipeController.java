package com.example.recipes.controllers;

import com.example.recipes.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping("/recipe/show/{id}")
  public String showById(@PathVariable("id")String id, Model model){
    model.addAttribute("recipe",recipeService.findById(Long.parseLong(id)));
    return "recipe/show";
  }

}
