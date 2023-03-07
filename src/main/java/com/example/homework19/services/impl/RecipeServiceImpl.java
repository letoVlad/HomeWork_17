package com.example.homework19.services.impl;

import com.example.homework19.model.Recipe;
import com.example.homework19.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static long number = 0;
    private static final Map<Long, Recipe> recipe = new HashMap<Long, Recipe>();

    @Override
    public Recipe addRecipe(Recipe newRecipe) {
        recipe.put(number++, newRecipe);
        return newRecipe;
    }

    @Override
    public Recipe getRecipe(long number) {
        return recipe.get(number);
    }


}
