package com.example.recipes.repositories;

import com.example.recipes.domain.Recipe;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe,Long> {

  List<Recipe> findAll();
}
