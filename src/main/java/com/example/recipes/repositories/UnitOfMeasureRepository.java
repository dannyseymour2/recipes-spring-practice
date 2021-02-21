package com.example.recipes.repositories;

import com.example.recipes.domain.UnitOfMeasure;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {

  Optional<UnitOfMeasure> findByDescription(String description);
}
