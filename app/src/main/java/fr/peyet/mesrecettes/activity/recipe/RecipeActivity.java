package fr.peyet.mesrecettes.activity.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import fr.peyet.mesrecettes.R;
import fr.peyet.mesrecettes.activity.recipe.adapter.RecipePagerAdapter;
import fr.peyet.mesrecettes.model.Recipe;
import fr.peyet.mesrecettes.service.RecipeService;

public class RecipeActivity extends AppCompatActivity {
    public static final String RECIPE_ID_PARAM = "fr.peyet.mesrecettes.recipeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_recipe);

        // Récupération de la recette
        Intent intent = this.getIntent();
        long recipeId = intent.getLongExtra(RECIPE_ID_PARAM, -1);

        if (recipeId < 0) {
            Toast.makeText(
                    this.getApplicationContext(),
                    "Impossible de récupérer l'id de la recette à afficher",
                    Toast.LENGTH_LONG
            ).show();

            this.finish();
        } else {
            Recipe recipe = RecipeService.getInstance().getRecipeById(recipeId);

            if (recipe == null) {
                Toast.makeText(
                        this.getApplicationContext(),
                        "La recette " + recipeId + " n'existe pas",
                        Toast.LENGTH_LONG
                ).show();

                this.finish();
            } else {
                // Inject title
                TextView title = this.findViewById(R.id.receipe_title);
                title.setText(recipe.getTitle());

                // Configure pager
                ViewPager viewPager = this.findViewById(R.id.recipe_pager);
                RecipePagerAdapter adapterViewPager = new RecipePagerAdapter(this.getSupportFragmentManager(), recipe);
                viewPager.setAdapter(adapterViewPager);

                // Configure tabs
                TabLayout tabLayout = this.findViewById(R.id.recipe_tabs);
                tabLayout.setupWithViewPager(viewPager);
            }
        }
    }
}