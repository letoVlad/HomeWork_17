package com.example.homework19.controllers;

import com.example.homework19.model.Ingredients;
import com.example.homework19.model.Recipe;
import com.example.homework19.services.IngredientsService;
import com.example.homework19.services.impl.IngredientsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    private final IngredientsService ingredientsService;

    //Добавление ингредиента.
    @PostMapping()
    public Ingredients addNewIngredients(@RequestBody Ingredients ingredients) {
        ingredientsService.addIngredients(ingredients);
        return ingredients;
    }

    // Получение информации об ингредиенте по id.
    @GetMapping("/{id}")
    public ResponseEntity<Ingredients> getIngredients(@PathVariable int id) {
        Ingredients ingredient = ingredientsService.getIngredients(id);
        return ingredient != null ? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }

    //Получение полного списка ингредиентов.
    @GetMapping
    public ResponseEntity<List<Ingredients>> getAllIngredients() {
        List<Ingredients> allIngredients = ingredientsService.addAllIngredients();
        return ResponseEntity.ok(allIngredients);
    }

    // Редактирование ингредиента по id.
    @PutMapping("/{id}")
    public ResponseEntity<Ingredients> editIngredients(@PathVariable int id, @RequestBody Ingredients ingredients) {
        Ingredients editIngredients = ingredientsService.editIngredients(id, ingredients);
        return editIngredients != null ? ResponseEntity.ok(editIngredients) : ResponseEntity.notFound().build();
    }

    // Удаление ингредиента.
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIngredients(@PathVariable int id) {
        return ingredientsService.deleteIngredients(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
