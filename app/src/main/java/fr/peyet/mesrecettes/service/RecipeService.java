package fr.peyet.mesrecettes.service;

import fr.peyet.mesrecettes.model.Ingredient;
import fr.peyet.mesrecettes.model.IngredientQuantifier;
import fr.peyet.mesrecettes.model.Recipe;

import java.util.ArrayList;
import java.util.List;

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

        this.createCurryRecipe();
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

    public Recipe createRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(this.recipes.size() + 1);

        this.recipes.add(recipe);

        return recipe;
    }

    private Recipe createCurryRecipe() {
        Recipe recipe = this.createRecipe();
        recipe.setTitle("Curry de crevette");

        Ingredient ail = new Ingredient();
        ail.setName("gousses d'ail");
        ail.setQuantity(2);
        ail.setQuantifier(IngredientQuantifier.OBJECT);
        recipe.addIngredient(ail);

        Ingredient echalottes = new Ingredient();
        echalottes.setName("échalottes");
        echalottes.setQuantity(2);
        echalottes.setQuantifier(IngredientQuantifier.OBJECT);
        recipe.addIngredient(echalottes);

        Ingredient citronelle = new Ingredient();
        citronelle.setName("bâton de citronelle");
        citronelle.setQuantity(1);
        citronelle.setQuantifier(IngredientQuantifier.OBJECT);
        recipe.addIngredient(citronelle);

        Ingredient curry = new Ingredient();
        curry.setName("curry");
        curry.setQuantity(1);
        curry.setQuantifier(IngredientQuantifier.TABLESPOON);
        recipe.addIngredient(curry);

        Ingredient laitCoco = new Ingredient();
        laitCoco.setName("lait de coco");
        laitCoco.setQuantity(13);
        laitCoco.setQuantifier(IngredientQuantifier.CENTILITER);
        recipe.addIngredient(laitCoco);

        Ingredient tomatesConcassees = new Ingredient();
        tomatesConcassees.setName("petite boite de tomates concassées");
        tomatesConcassees.setQuantity(1);
        tomatesConcassees.setQuantifier(IngredientQuantifier.OBJECT);
        recipe.addIngredient(tomatesConcassees);

        Ingredient blettes = new Ingredient();
        blettes.setName("blettes");
        blettes.setQuantity(400);
        blettes.setQuantifier(IngredientQuantifier.GRAM);
        recipe.addIngredient(blettes);

        Ingredient carrottes = new Ingredient();
        carrottes.setName("carrotes");
        carrottes.setQuantity(4);
        carrottes.setQuantifier(IngredientQuantifier.OBJECT);
        recipe.addIngredient(carrottes);

        Ingredient citronVert = new Ingredient();
        citronVert.setName("citron vert");
        citronVert.setQuantity(1);
        citronVert.setQuantifier(IngredientQuantifier.OBJECT);
        recipe.addIngredient(citronVert);

        Ingredient crevettes = new Ingredient();
        crevettes.setName("crevettes décortiquées");
        crevettes.setQuantity(500);
        crevettes.setQuantifier(IngredientQuantifier.GRAM);
        recipe.addIngredient(crevettes);

        recipe.addStep("Portez à ébulition une casserole d'eau salée");
        recipe.addStep("Pelez les carottes et coupez-lez en rondelles");
        recipe.addStep("Faites cuire les carottes dans l'eau pendant au moins 15 minutes");
        recipe.addStep("Préparez les blettes : hachez les feuilles et coupez les tiges en cubes");
        recipe.addStep("Pelez et coupez grossièrement les deux échalottes et les deux gousses d'ail");
        recipe.addStep("Dans un robot mixeur, mettez : les deux gousses d'ail, les deux échalottes, " +
                "la moitiée de la citronelle, une cuillère à soupe de curry indien, une cuillière à café de sel, " +
                "un peu de poivre et deux cuillières à soupe d'eau. Mixez jusqu'à l'obtention d'une pâte.");
        recipe.addStep("Dans une sauteuse, faites chauffer une cuillière à soupe d'huile puis faites cuire la pâte " +
                "à feu doux pendant 5 minutes. Au besoin, rajoutez un peu d'eau.");
        recipe.addStep("Ajoutez dans la sauteuse : le lait de coco, la moitié de la boite de tomates, les blettes et les carrotes.");
        recipe.addStep("Rajoutez dans la sauteuse du jus de cuisson des carottes jusqu'à recouvrir les légumes");
        recipe.addStep("Laisser mijotter pendant 15 minutes");
        recipe.addStep("Ajoutez les crevettes décortiquées et le jus d'un-demi citron vert avant de servir");

        return recipe;
    }
}
