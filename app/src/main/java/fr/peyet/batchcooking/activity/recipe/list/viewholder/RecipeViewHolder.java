package fr.peyet.batchcooking.activity.recipe.list.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.peyet.batchcooking.R;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    private final TextView recipeTitleView;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        this.recipeTitleView = itemView.findViewById(R.id.recipe_list_item_name);
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitleView.setText(recipeTitle);
    }

}
