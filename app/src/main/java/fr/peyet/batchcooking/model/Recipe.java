package fr.peyet.batchcooking.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private long id;
    private String title;
    private List<Ingredient> ingredients;
    private List<String> steps;

    public Recipe() {
        this.id = 0;
        this.title = "";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }

        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public List<String> getSteps() {
        return this.steps;
    }

    public void setSteps(List<String> steps) {
        if (steps == null) {
            steps = new ArrayList<>();
        }

        this.steps = steps;
    }

    public void addStep(String step) {
        this.steps.add(step);
    }

}
