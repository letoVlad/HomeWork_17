package com.example.homework19.services;

import com.example.homework19.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe addRecipe(Recipe newRecipe);

    Recipe getRecipe(long number);

    List<Recipe> addAllRecipe();

    List<Recipe> searchRecipesByIngredients(int id);

    Recipe editRecipe(long id, Recipe editRecipe);

    boolean deleteRecipe(long id);
}
