package com.example.homework19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Recipe {
    private String title;
    private int cookingTime;
    private List<Ingredients> ingredients;
    private List<String> cookingSteps;
}
