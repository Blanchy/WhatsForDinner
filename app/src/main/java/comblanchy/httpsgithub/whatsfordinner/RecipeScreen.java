/**
 * @author blanchypolangcos
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

public class RecipeScreen extends AppCompatActivity {

    //orientation 1 = vertical, orientation 0 = horizontal
    private int orient;
    private RecipeLandscape rl;
    private RecipePortraitFragment rpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe_screen);
        Configuration config = getResources().getConfiguration();


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();

        Intent intent = getIntent();


        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //display both fragment
            orient = 1;
            rl = new RecipeLandscape();

            fragmentTransaction.replace(android.R.id.content, rl);
        }
        else {
            orient = 0;
            // display one fragment
            rpf = new RecipePortraitFragment();
            fragmentTransaction.replace(android.R.id.content, rpf);
        }

        fragmentTransaction.commit();
    }

    public void showRecipe(int index) {
        //RecipeLandscape details = (RecipeLandscape) getFragmentManager()
        //        .findFragmentById(R.id.recipedetailholder);


        //if (rl == null || rl.getIndex() != index) {
            //int x = 0;
            //details =
            rl = RecipeLandscape.newInstance(index);
            //Bundle b = new Bundle();
            //b.putInt("index", index);
            //rl.setArguments(b);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.bigparent, rl);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();

        //}

    }
}
