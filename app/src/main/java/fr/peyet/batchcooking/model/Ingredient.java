package fr.peyet.batchcooking.model;

public class Ingredient {

    private String name;
    private int quantity;
    private IngredientQuantifier quantifier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public IngredientQuantifier getQuantifier() {
        return quantifier;
    }

    public void setQuantifier(IngredientQuantifier quantifier) {
        this.quantifier = quantifier;
    }

}
