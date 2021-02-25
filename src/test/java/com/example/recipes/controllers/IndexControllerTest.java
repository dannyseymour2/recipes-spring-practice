package com.example.recipes.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.recipes.domain.Recipe;
import com.example.recipes.repositories.RecipeRepository;
import com.example.recipes.service.RecipeService;
import com.example.recipes.service.RecipeServiceImpl;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

class IndexControllerTest {

  @Mock
  Model model;

  @Mock
  private RecipeService recipeService;

  private IndexController indexController;

  @BeforeEach
  public void setup(){
    MockitoAnnotations.initMocks(this);
    indexController = new IndexController(recipeService);
  }


  @Test
  void getPage() {
    //given
    Recipe recipe = new Recipe();
    Recipe recipe2 = new Recipe();
    List<Recipe> recipeList = new LinkedList<>();
    recipeList.add(recipe);
    recipeList.add(recipe2);

    //when
    when(recipeService.getAllRecipes()).thenReturn(recipeList);
    String viewName = indexController.getPage(model);
    ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);

    //then
    assertEquals("index",viewName);
    verify(recipeService, times(1)).getAllRecipes();
    verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
    List<Recipe> listInController = argumentCaptor.getValue();
    assertEquals(2, listInController.size());
  }
}
