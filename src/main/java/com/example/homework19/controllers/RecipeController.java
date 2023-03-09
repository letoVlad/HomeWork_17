package com.example.homework19.controllers;

import com.example.homework19.model.Ingredients;
import com.example.homework19.model.Recipe;
import com.example.homework19.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // Добавление рецепта.
    @PostMapping()
    public Recipe addNewRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return recipe;
    }

    // Получение рецепта по id.
    @GetMapping("{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe recipe = recipeService.getRecipe(id);
        return recipe != null ? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

    // Получение списка всех рецептов.
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipe() {
        List<Recipe> allRecipe = recipeService.addAllRecipe();
        return ResponseEntity.ok(allRecipe);
    }

    //  Редактирование рецепта по id.
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        Recipe recipes = recipeService.editRecipe(id, recipe);
        return recipes != null ? ResponseEntity.ok(recipes) : ResponseEntity.notFound().build();
    }

    // Удаление рецепта по id.
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecipe(@PathVariable long id) {
        return recipeService.deleteRecipe(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    //Поиск рецептов по id ингредиента(TEST)
    @GetMapping("/new/{id}")
    public ResponseEntity<List<Recipe>> searchRecipesByIngredients(@PathVariable int id){
        List<Recipe> allRecipe = recipeService.searchRecipesByIngredients(id);
        return ResponseEntity.ok(allRecipe);
    }
}
