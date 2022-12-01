package com.jagt.jagtresturante.controller;

import com.jagt.jagtresturante.exception.ApiRequestException;
import com.jagt.jagtresturante.model.Recipe;
import com.jagt.jagtresturante.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")

public class RecipeController {
    private final RecipeRepository recipeRepository;
    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @GetMapping("{id}")
    public ResponseEntity<Recipe> getMenuById(@PathVariable long id)
            throws ApiRequestException {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("There is no recipe with id " + id + ". Please, try again"));
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable long id,@RequestBody Recipe recipeDetails) {
        Recipe updateRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Could not update because there is no recipe with id " + id + ". Please, try again"));
        updateRecipe.setIngredients(recipeDetails.getIngredients());
        updateRecipe.setMeasurement(recipeDetails.getMeasurement());
        updateRecipe.setKitchenEquipment(recipeDetails.getKitchenEquipment());
        updateRecipe.setDurationInMM(recipeDetails.getDurationInMM());
        recipeRepository.save(updateRecipe);
        return new ResponseEntity<>(updateRecipe, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Could not delete because there is no recipe with id " + id + ". Please, try again"));
        recipeRepository.delete(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.NO_CONTENT);
    }
}
