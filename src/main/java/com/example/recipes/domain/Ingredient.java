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
import lombok.Data;

@Entity
@Data
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private BigDecimal amount;

  @OneToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
  private UnitOfMeasure unitOfMeasure;

  @ManyToOne
  private Recipe recipe;


}
