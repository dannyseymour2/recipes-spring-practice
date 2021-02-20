package com.example.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping({"/","","/index"})
  public String getPage(){
    System.out.println("test");
    return "index";
  }

}
