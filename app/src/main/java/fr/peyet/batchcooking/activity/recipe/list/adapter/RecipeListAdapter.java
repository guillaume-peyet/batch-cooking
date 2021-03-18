package fr.peyet.batchcooking.activity.recipe.list.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.peyet.batchcooking.R;
import fr.peyet.batchcooking.activity.recipe.view.RecipeViewActivity;
import fr.peyet.batchcooking.activity.recipe.list.viewholder.RecipeViewHolder;
import fr.peyet.batchcooking.model.Recipe;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final List<Recipe> recipes;
    private final LayoutInflater layoutInflater;

    public RecipeListAdapter(Context context, List<Recipe> datas) {
        this.recipes = datas;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recyclerViewItem = this.layoutInflater.inflate(R.layout.recipe_list_item, parent, false);

        recyclerViewItem.setOnClickListener(view -> this.handleRecipeClick((RecyclerView) parent, view));

        return new RecipeViewHolder(recyclerViewItem);
    }


    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Recipe recipe = this.recipes.get(position);

        holder.setRecipeTitle(recipe.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.recipes.size();
    }

    private void handleRecipeClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);

        Recipe recipe = this.recipes.get(itemPosition);

        Intent intent = new Intent(recyclerView.getContext(), RecipeViewActivity.class);
        intent.putExtra(RecipeViewActivity.RECIPE_ID_PARAM, recipe.getId());

        recyclerView.getContext().startActivity(intent);
    }

}
