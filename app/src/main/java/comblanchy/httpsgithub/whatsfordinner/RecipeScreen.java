package comblanchy.httpsgithub.whatsfordinner;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecipeScreen extends AppCompatActivity {

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
        }
        else {
            // display one fragment
        }
        fragmentTransaction.commit();
    }

}
