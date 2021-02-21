package com.example.recipes.repositories;

import com.example.recipes.domain.Category;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

  Optional<Category> findByDescription(String description);

}
