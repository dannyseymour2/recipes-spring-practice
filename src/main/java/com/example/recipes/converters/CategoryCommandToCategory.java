package com.example.recipes.converters;

import com.example.recipes.command.CategoryCommand;
import com.example.recipes.command.UnitOfMeasureCommand;
import com.example.recipes.domain.Category;
import com.example.recipes.domain.UnitOfMeasure;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

  @Override
  @Nullable
  @Synchronized
  public Category convert(CategoryCommand source) {
    if (source == null) {
      return null;
    }
    final Category category = new Category();
    category.setId(source.getId());
    category.setDescription(source.getDescription());
    return category;
  }
}
