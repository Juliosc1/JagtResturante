package com.jagt.jagtresturante.repository;

import com.jagt.jagtresturante.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}