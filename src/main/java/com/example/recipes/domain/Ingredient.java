package com.example.recipes.domain;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"recipe"})
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;
  private BigDecimal amount;

  @OneToOne(fetch= FetchType.EAGER)
  private UnitOfMeasure unitOfMeasure;

  @ManyToOne
  private Recipe recipe;


  public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
    this.description=description;
    this.amount=amount;
    this.unitOfMeasure=uom;
    this.recipe=recipe;
  }
  public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom){
    this.description=description;
    this.amount=amount;
    this.unitOfMeasure=uom;
  }

}
