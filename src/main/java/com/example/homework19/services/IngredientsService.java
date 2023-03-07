package com.example.homework19.services;

import com.example.homework19.model.Ingredients;

public interface IngredientsService {

    Ingredients addIngredients(Ingredients newIngredients);

    Ingredients getIngredients(int number);


}
