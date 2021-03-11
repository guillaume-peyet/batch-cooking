package fr.peyet.mesrecettes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import fr.peyet.mesrecettes.activity.recipe.RecipeActivity;
import fr.peyet.mesrecettes.activity.recipelist.adapter.RecipeListAdapter;
import fr.peyet.mesrecettes.model.Recipe;
import fr.peyet.mesrecettes.service.RecipeService;

public class MainActivity extends AppCompatActivity {

    RecipeService recipeService;
    GridView recipeGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        // Récupération du service de gestion des recettes
        this.recipeService = RecipeService.getInstance();

        // Configuration de la liste des recettes
        this.recipeGrid = this.findViewById(R.id.recipe_list_grid);
        this.recipeGrid.setAdapter(new RecipeListAdapter(this.getLayoutInflater(), this.recipeService.getList()));

        this.recipeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(parent.getContext(), RecipeActivity.class);
                intent.putExtra(RecipeActivity.RECIPE_ID_PARAM, id);

                MainActivity.this.startActivity(intent);
            }
        });


        // Implémentation de l'ajout d'une nouvelle recette
        FloatingActionButton addButton = this.findViewById(R.id.recipe_list_add_recipe);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe newRecipe = MainActivity.this.recipeService.createRecipe();

                Intent intent = new Intent(v.getContext(), RecipeActivity.class);
                intent.putExtra(RecipeActivity.RECIPE_ID_PARAM, newRecipe.getId());

                MainActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.recipeGrid.invalidateViews();
    }
}