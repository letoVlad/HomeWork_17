package com.example.homework19.controllers;

import com.example.homework19.model.Ingredients;
import com.example.homework19.model.Recipe;
import com.example.homework19.services.impl.RecipeServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping()
    public Recipe addNewIngredients(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return recipe;
    }

    @GetMapping("{number}")
    public Recipe getIngredients(@PathVariable int number) {
        Recipe recipe = recipeService.getRecipe(number);
        if (recipe == null){
            return null;
        }
        return recipeService.getRecipe(number);
    }
}
