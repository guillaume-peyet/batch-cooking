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

    private int indexOfRecipe(Recipe recipe) {
        int index = -1;

        for (int i = 0; i < this.recipes.size(); i++) {
            if (this.recipes.get(i).getId() == recipe.getId()) {
                index = i;
                break;
            }
        }

        return index;
    }

    public void save(Recipe recipe) {
        int position = this.indexOfRecipe(recipe);

        if (position < 0) {
            // La recette spécifiée n'existe pas, on l'ajoute en fin de liste
            recipe.setId(this.recipes.size() + 1);
            this.recipes.add(recipe);
        } else {
            // La recette spécifiée existe déjà, on la remplace
            this.recipes.set(position, recipe);
        }
    }

}
