package com.example.recipes.controllers;

import com.example.recipes.domain.Recipe;
import com.example.recipes.service.RecipeService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  private final RecipeService recipeService;

  public IndexController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping({"/","","/index"})
  public String getPage(Model model){
  //circleci test 3
    List<Recipe> recipes = recipeService.getAllRecipes();
    if(recipes.size()>0){
      model.addAttribute("recipes", recipes);
    }
    return "index";
  }

}
