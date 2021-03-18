package fr.peyet.batchcooking.activity.recipe.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import fr.peyet.batchcooking.R;
import fr.peyet.batchcooking.activity.recipe.view.adapter.RecipePagerAdapter;
import fr.peyet.batchcooking.model.Recipe;
import fr.peyet.batchcooking.service.RecipeService;

public class RecipeViewActivity extends AppCompatActivity {

    public static final String RECIPE_ID_PARAM = "fr.peyet.batchcooking.activity.recipe.view.recipeId";

    private final RecipeService recipeService;

    private long recipeId;
    private TextView title;
    private RecipePagerAdapter recipePagerAdapter;

    public RecipeViewActivity() {
        this.recipeService = RecipeService.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_recipe_view);

        // Récupération de l'id de la recette
        Intent intent = this.getIntent();
        this.recipeId = intent.getLongExtra(RECIPE_ID_PARAM, -1);

        if (this.recipeId < 0) {
            Toast.makeText(
                    this.getApplicationContext(),
                    "Impossible de récupérer l'id de la recette à afficher",
                    Toast.LENGTH_LONG
            ).show();

            this.finish();
        }

        // Récupération et configuration des éléments d'UI
        this.title = this.findViewById(R.id.recipe_view_title);

        this.recipePagerAdapter = new RecipePagerAdapter(this.getSupportFragmentManager());

        ViewPager viewPager = this.findViewById(R.id.recipe_pager);
        viewPager.setAdapter(this.recipePagerAdapter);

        TabLayout tabLayout = this.findViewById(R.id.recipe_tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Chargement de la recette
        this.loadRecipe();
    }

    private void loadRecipe() {
        // Récupération de la recette à partir du service
        Recipe recipe = this.recipeService.getRecipeById(this.recipeId);

        if (recipe == null) {
            Toast.makeText(
                    this.getApplicationContext(),
                    "La recette " + this.recipeId + " n'existe pas",
                    Toast.LENGTH_LONG
            ).show();

            this.finish();
        } else {
            // Injection des données dans la vue
            this.title.setText(recipe.getTitle());
            this.recipePagerAdapter.setRecipe(recipe);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.loadRecipe();
    }

}
