package comblanchy.httpsgithub.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
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

    }

    public void toMeals(View view) {
        Intent intent = new Intent(this, MealsScreen.class);
        startActivity(intent);
    }
}
