package comblanchy.httpsgithub.whatsfordinner;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class NewDishScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_screen);

        Intent intent = getIntent();
    }

    public void addRecipe(View view) {
        EditText et = (EditText) findViewById(R.id.recipename);
        String recipeStr = et.getText().toString();

        //check against all recipes
        boolean duplicate = false;
        for (Recipe r : MainMenu.cookbook) {
            if (r.getName().equals(recipeStr)) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            //add recipe
            et = (EditText) findViewById(R.id.directions);
            ImageView iv = (ImageView) findViewById(R.id.recipeimg);
            Image img = (Image) iv.getDrawable(); // ????
            //get spinner content
        }
    }
}
