package fr.peyet.batchcooking.activity.recipe.edit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import fr.peyet.batchcooking.R;
import fr.peyet.batchcooking.activity.recipe.list.RecipeListActivity;
import fr.peyet.batchcooking.model.Recipe;
import fr.peyet.batchcooking.service.RecipeService;

public class RecipeEditActivity extends AppCompatActivity {

    public static final String RECIPE_ID_PARAM = "fr.peyet.mesrecettes.recipeId";

    private final RecipeService recipeService;
    private Recipe recipe;
    private TextInputEditText titleInput;

    public RecipeEditActivity() {
        this.recipeService = RecipeService.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_recipe_edit);
        this.setTitle("Édition");

        // Récupération de l'id de la recette éventuel
        Intent intent = this.getIntent();
        long recipeId = intent.getLongExtra(RECIPE_ID_PARAM, -1);

        if (recipeId < 0) {
            // Aucun ID de recette n'a été transmit, on crée une nouvelle recette
            this.recipe = new Recipe();
            this.recipe.setId(-1);
        } else {
            // Un ID de recette a été donné : on récupère la recette existante
            this.recipe = this.recipeService.getRecipeById(recipeId);
        }

        // Récupération des éléments de formulaire
        this.titleInput = this.findViewById(R.id.recipe_edit_input_title);

        // Injection des données de la recette dans le formulaire
        this.titleInput.setText(this.recipe.getTitle());

        Button fab = findViewById(R.id.recipe_edit_btn_save);
        fab.setOnClickListener(this::saveRecipe);
    }

    private void saveRecipe(View view) {
        // Récupération des valeurs du formulaire pour updater la recette
        String titleString = "";

        if (this.titleInput.getText() != null) {
            titleString = this.titleInput.getText().toString();
        }

        this.recipe.setTitle(titleString);

        // Persistance de la recette
        this.recipeService.save(this.recipe);

        // Redirection vers le listing
        this.finish();
    }
}