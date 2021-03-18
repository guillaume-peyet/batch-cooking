package fr.peyet.batchcooking.service;

import java.util.ArrayList;
import java.util.List;

import fr.peyet.batchcooking.model.Recipe;

public class RecipeService {

    private static RecipeService instance;
    List<Recipe> recipes;

    public static RecipeService getInstance() {
        if (instance == null) {
            instance = new RecipeService();
        }

        return instance;
    }

    private RecipeService() {
        this.recipes = new ArrayList<>();
    }

    public List<Recipe> getList() {
        return this.recipes;
    }

    public Recipe getRecipeById(long idRecipe) {
        Recipe recipe = null;

        for (Recipe current : this.recipes) {
            if (current.getId() == idRecipe) {
                recipe = current;
                break;
            }
        }

        return recipe;
    }

}
