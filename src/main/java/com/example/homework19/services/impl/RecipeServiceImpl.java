package com.example.homework19.services.impl;

import com.example.homework19.model.Recipe;
import com.example.homework19.services.IngredientsService;
import com.example.homework19.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static long number = 0;
    private static final Map<Long, Recipe> recipe = new HashMap<Long, Recipe>();
    private final IngredientsService ingredientsService;

    public RecipeServiceImpl(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }


    @Override
    public Recipe addRecipe(Recipe newRecipe) {
        recipe.put(number++, newRecipe);
        return newRecipe;
    }

    @Override
    public Recipe getRecipe(long number) {
        return recipe.get(number);
    }

    @Override
    public List<Recipe> addAllRecipe() {
        List<Recipe> allRecipe = new ArrayList<>();
        allRecipe.addAll(recipe.values());
        return allRecipe;
    }

    @Override
    public List<Recipe> searchRecipesByIngredients(int id) {
        List<Recipe> allRecipe = new ArrayList<>();
        for (Recipe value : recipe.values()) {
            if (ingredientsService.getIngredients(id).equals(value.getIngredients().get(id))) {
                allRecipe.add(value);
                return allRecipe;
            }
        }
        return null;
    }

    @Override
    public Recipe editRecipe(long id, Recipe editRecipe) {
        if (recipe.containsKey(id)) {
            recipe.put(id, editRecipe);
            return editRecipe;
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(long id) {
        if (recipe.containsKey(id)) {
            recipe.remove(id);
            return true;
        }
        return false;
    }
}
