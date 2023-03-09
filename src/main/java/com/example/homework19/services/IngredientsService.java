package com.example.homework19.services;

import com.example.homework19.model.Ingredients;

import java.util.List;

public interface IngredientsService {

    Ingredients addIngredients(Ingredients newIngredients);

    Ingredients getIngredients(int number);

    List<Ingredients> addAllIngredients();

    Ingredients editIngredients(int id, Ingredients ingredients);

    boolean deleteIngredients(int id);
}
