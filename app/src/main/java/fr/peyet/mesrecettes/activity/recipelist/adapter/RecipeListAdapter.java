package fr.peyet.mesrecettes.activity.recipelist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import fr.peyet.mesrecettes.R;
import fr.peyet.mesrecettes.model.Recipe;

import java.util.List;

public class RecipeListAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<Recipe> recipes;

    public RecipeListAdapter(LayoutInflater inflater, List<Recipe> recipes) {
        this.inflater = inflater;
        this.recipes = recipes;
    }

    @Override
    public int getCount() {
        return this.recipes.size();
    }

    @Override
    public Recipe getItem(int position) {
        return this.recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vue;

        // Si la vue est recyclée, elle contient déjà le bon layout
        if (convertView != null) {
            // On n'a plus qu'à la récupérer
            vue = convertView;
        } else {
            // Sinon, il faut en effet utiliser le LayoutInflater
            vue = this.inflater.inflate(R.layout.recipe_list_item, null);
        }

        TextView name = vue.findViewById(R.id.recipe_list_item_name);
        name.setText(this.getItem(position).getTitle());

        return vue;
    }
}
