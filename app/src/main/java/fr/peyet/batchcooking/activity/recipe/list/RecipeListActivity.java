package fr.peyet.batchcooking.activity.recipe.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import fr.peyet.batchcooking.R;
import fr.peyet.batchcooking.activity.recipe.edit.RecipeEditActivity;
import fr.peyet.batchcooking.activity.recipe.list.adapter.RecipeListAdapter;
import fr.peyet.batchcooking.service.RecipeService;

public class RecipeListActivity extends AppCompatActivity {

    private final RecipeService recipeService;
    private RecyclerView recyclerView;

    public RecipeListActivity() {
        this.recipeService = RecipeService.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_recipe_list);

        // Configuration de la liste des recettes
        this.recyclerView = this.findViewById(R.id.recipe_list_grid);
        this.recyclerView.setAdapter(new RecipeListAdapter(this, this.recipeService.getList()));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(RecipeListActivity.this, 2);
        this.recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Objects.requireNonNull(this.recyclerView.getAdapter()).notifyDataSetChanged();
    }

}
