package com.example.homework19.services.impl;

import com.example.homework19.model.Ingredients;
import com.example.homework19.services.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private static int number = 0;
    private static final Map<Integer, Ingredients> ingredients = new HashMap<Integer, Ingredients>();

    @Override
    public Ingredients addIngredients(Ingredients newIngredients) {
        ingredients.put(number++, newIngredients);
        return newIngredients;
    }

    @Override
    public Ingredients getIngredients(int number) {
        return ingredients.get(number);
    }

    @Override
    public List<Ingredients> addAllIngredients() {
        List<Ingredients> allIngredients = new ArrayList<>();
        allIngredients.addAll(ingredients.values());
        return allIngredients;
    }


    @Override
    public Ingredients editIngredients(int id, Ingredients editIngredients) {
        if (ingredients.containsKey(id)) {
            ingredients.put(id, editIngredients);
            return editIngredients;
        }
        return null;
    }

    @Override
    public boolean deleteIngredients(int id) {
        if (ingredients.containsKey(id)) {
            ingredients.remove(id);
            return true;
        }
        return false;
    }

}
