package fr.peyet.mesrecettes.activity.recipe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import fr.peyet.mesrecettes.R;
import fr.peyet.mesrecettes.model.Ingredient;
import fr.peyet.mesrecettes.model.IngredientQuantifier;

import java.util.ArrayList;
import java.util.List;

public class IngredientAdapter extends BaseAdapter {

    private final List<Ingredient> ingredients;
    private final LayoutInflater inflater;

    public IngredientAdapter(LayoutInflater inflater, List<Ingredient> ingredients) {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }

        this.ingredients = ingredients;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return this.ingredients.size();
    }

    @Override
    public Ingredient getItem(int position) {
        return this.ingredients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
            vue = this.inflater.inflate(R.layout.ingredient, null);
        }

        Ingredient ingredient = this.getItem(position);

        TextView quantity = vue.findViewById(R.id.ingredient_quantity);
        quantity.setText(String.valueOf(ingredient.getQuantity()));

        TextView unity = vue.findViewById(R.id.ingredient_unity);
        unity.setText(this.getUnityTextFromQuantifier(ingredient.getQuantifier()));

        TextView link = vue.findViewById(R.id.ingredient_link);
        link.setText(this.getLinkTextFromQuantifierAndName(ingredient.getQuantifier(), ingredient.getName()));

        TextView name = vue.findViewById(R.id.ingredient_name);
        name.setText(ingredient.getName());

        return vue;
    }

    private String getLinkTextFromQuantifierAndName(IngredientQuantifier quantifier, String name) {
        String texte;

        List<Character> voyelles = new ArrayList<>();
        voyelles.add('a');
        voyelles.add('à');
        voyelles.add('â');
        voyelles.add('ä');
        voyelles.add('e');
        voyelles.add('é');
        voyelles.add('è');
        voyelles.add('ê');
        voyelles.add('ë');
        voyelles.add('i');
        voyelles.add('î');
        voyelles.add('ï');
        voyelles.add('o');
        voyelles.add('ô');
        voyelles.add('ö');
        voyelles.add('u');
        voyelles.add('ù');
        voyelles.add('û');
        voyelles.add('ü');
        voyelles.add('y');

        switch (quantifier) {
            case KILOGRAM:
            case GRAM:
            case LITER:
            case CENTILITER:
            case MILILITER:
            case TABLESPOON:
            case TEASPOON:
                char firstLetter = name.toLowerCase().charAt(0);
                if (voyelles.contains(firstLetter)) {
                    texte = " d'";
                } else {
                    texte = " de ";
                }
                break;
            case OBJECT:
            default:
                texte = " ";
        }

        return texte;
    }

    private String getUnityTextFromQuantifier(IngredientQuantifier quantifier) {
        String texte;

        switch (quantifier) {
            case KILOGRAM:
                texte = "kg";
                break;
            case GRAM:
                texte = "g";
                break;
            case LITER:
                texte = "L";
                break;
            case CENTILITER:
                texte = "cL";
                break;
            case MILILITER:
                texte = "mL";
                break;
            case TABLESPOON:
                texte = " cuillère à soupe";
                break;
            case TEASPOON:
                texte = " cuillère à café";
                break;
            case OBJECT:
            default:
                texte = "";
        }

        return texte;
    }
}
