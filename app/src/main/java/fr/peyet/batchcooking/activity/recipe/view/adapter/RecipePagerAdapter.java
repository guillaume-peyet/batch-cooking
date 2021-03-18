package fr.peyet.batchcooking.activity.recipe.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fr.peyet.batchcooking.activity.recipe.view.fragment.IngredientsFragment;
import fr.peyet.batchcooking.activity.recipe.view.fragment.StepsFragment;
import fr.peyet.batchcooking.model.Recipe;

public class RecipePagerAdapter extends FragmentPagerAdapter {

    private Recipe recipe;

    public RecipePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public int getCount() {
        // Number of tabs
        return 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Fragment among position
        switch (position) {
            case 0:
                return new IngredientsFragment(this.recipe.getIngredients());
            case 1:
            default:
                return new StepsFragment(this.recipe.getSteps());
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Title of tab
        switch (position) {
            case 0:
                return "Ingrédients";
            case 1:
            default:
                return "Étapes";
        }
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
