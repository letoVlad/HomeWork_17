package com.example.homework19.services;

import com.example.homework19.model.Recipe;

public interface RecipeService {

    Recipe addRecipe(Recipe newRecipe);

    Recipe getRecipe(long number);
}
