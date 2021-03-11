package fr.peyet.mesrecettes.activity.recipe.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import fr.peyet.mesrecettes.activity.recipe.fragment.IngredientsFragment;
import fr.peyet.mesrecettes.activity.recipe.fragment.StepsFragment;
import fr.peyet.mesrecettes.model.Recipe;

public class RecipePagerAdapter extends FragmentPagerAdapter {
    private final Recipe recipe;

    public RecipePagerAdapter(FragmentManager fragmentManager, Recipe recipe) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.recipe = recipe;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return 2;
    }

    // Returns the fragment to display for that page
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new IngredientsFragment(this.recipe.getIngredients());
            case 1:
            default:
                return new StepsFragment(this.recipe.getSteps());
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Ingrédient";
            case 1:
            default:
                return "Étapes";
        }
    }
}
