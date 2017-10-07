package comblanchy.httpsgithub.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    static ArrayList<Recipe> cookbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        if (cookbook.size() <= 0) {
            cookbook = new ArrayList<Recipe> ();
        }
    }

    public void toNewDish(View view) {

        Intent intent = new Intent(this, NewDishScreen.class);
        startActivity(intent);
    }

    public void toRecipes(View view) {
        Intent intent = new Intent(this, RecipeScreen.class);
        startActivity(intent);
    }

    public void toGroceries(View view) {
        Intent intent = new Intent(this, GroceryShopping.class);
        startActivity(intent);
    }

    public void toMeals(View view) {
        Intent intent = new Intent(this, MealsScreen.class);
        startActivity(intent);
    }

    /* https://stackoverflow.com/questions/38987442/how-to-make-a-simple-android-popup-window */
    public void showCredits(View view) {
        // pop up screen for title
    }
}
