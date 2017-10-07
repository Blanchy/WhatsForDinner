package comblanchy.httpsgithub.whatsfordinner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

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
        /*
        for (Recipe r : MainMenu.cookbook) {
            if (r.getName().equals(recipeStr)) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            //add recipe
            et = (EditText) findViewById(R.id.directions);
            ImageView iv = (ImageView) findViewById(R.id.recipeimg);
            Drawable img = iv.getDrawable(); // ????
            //get spinner content
            Spinner spin1 = (Spinner) findViewById(R.id.ingred1);
            Spinner spin2 = (Spinner) findViewById(R.id.ingred2);
            Spinner spin3 = (Spinner) findViewById(R.id.ingred3);
            Spinner spin4 = (Spinner) findViewById(R.id.ingred4);
            Spinner spin5 = (Spinner) findViewById(R.id.ingred5);
            Spinner spin6 = (Spinner) findViewById(R.id.ingred6);
            Spinner spin7 = (Spinner) findViewById(R.id.ingred7);
            Spinner spin8 = (Spinner) findViewById(R.id.ingred8);
            Spinner spin9 = (Spinner) findViewById(R.id.ingred9);
            Spinner spin10 = (Spinner) findViewById(R.id.ingred10);
        }
        */
    }
}
