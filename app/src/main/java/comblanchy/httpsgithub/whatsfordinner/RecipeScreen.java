/*
  @author blanchypolangcos
 * Used references:
 * "Dynamic Layouts using the Fragment Manager" Andrew T. Campbell
 * http://www.cs.dartmouth.edu/~campbell/cs65/lecture09/lecture09.html
 */

package comblanchy.httpsgithub.whatsfordinner;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecipeScreen extends AppCompatActivity implements RecipePortraitFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe_screen);

    }

    public void onRecipeSelected(String recipe) {
        RecipeHolder.getInstance().addMeals(recipe);

        RecipeLandscape rl = (RecipeLandscape) getFragmentManager().findFragmentById(R.id.flrecipes);

        if (rl != null && rl.isInLayout()) {
            Recipe info = RecipeHolder.getInstance().getRecipe(recipe);
            rl.setRecipe(info);
        }
    }
}
