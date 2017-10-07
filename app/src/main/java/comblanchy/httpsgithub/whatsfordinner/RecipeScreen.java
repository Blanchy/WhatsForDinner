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
            RecipeLandscape rl = new RecipeLandscape();
            fragmentTransaction.replace(android.R.id.content, rl);
        }
        else {
            orient = 0;
            // display one fragment
            RecipePortraitFragment rpf = new RecipePortraitFragment();
            fragmentTransaction.replace(android.R.id.content, rpf);
        }

        fragmentTransaction.commit();
    }


}
