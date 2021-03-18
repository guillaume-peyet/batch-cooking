package fr.peyet.batchcooking.activity.recipe.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

import fr.peyet.batchcooking.R;
import fr.peyet.batchcooking.activity.recipe.view.adapter.IngredientAdapter;
import fr.peyet.batchcooking.model.Ingredient;

public class IngredientsFragment extends Fragment {

    private final List<Ingredient> ingredients;

    public IngredientsFragment(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ingredient_fragment, container, false);

        ListView ingredients = view.findViewById(R.id.receipe_ingredients);
        ingredients.setAdapter(new IngredientAdapter(inflater, this.ingredients));

        return view;
    }

}
