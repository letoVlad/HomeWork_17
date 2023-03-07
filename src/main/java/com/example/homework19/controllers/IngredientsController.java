package com.example.homework19.controllers;

import com.example.homework19.model.Ingredients;
import com.example.homework19.model.Recipe;
import com.example.homework19.services.impl.IngredientsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    public IngredientsController(IngredientsServiceImpl ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    private final IngredientsServiceImpl ingredientsService;

    @PostMapping()
    public Ingredients addNewIngredients(@RequestBody Ingredients ingredients) {
        ingredientsService.addIngredients(ingredients);
        return ingredients;
    }

    @GetMapping("{number}")
    public Ingredients getIngredients(@PathVariable int number) {
        Ingredients ingredient = ingredientsService.getIngredients(number);
        if (ingredient == null){
            return null;
        }
        return ingredientsService.getIngredients(number);
    }
}
