package comblanchy.httpsgithub.whatsfordinner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class NewDishScreen extends AppCompatActivity {

    Spinner spin1;
    Spinner spin2;
    Spinner spin3;
    Spinner spin4;
    Spinner spin5;
    Spinner spin6;
    Spinner spin7;
    Spinner spin8;
    Spinner spin9;
    Spinner spin10;
    private ArrayList<Spinner> spinnerIngreds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_screen);

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
        spinnerIngreds = new ArrayList<Spinner>();
        spinnerIngreds.add(spin1);
        spinnerIngreds.add(spin2);
        spinnerIngreds.add(spin3);
        spinnerIngreds.add(spin4);
        spinnerIngreds.add(spin5);
        spinnerIngreds.add(spin6);
        spinnerIngreds.add(spin7);
        spinnerIngreds.add(spin8);
        spinnerIngreds.add(spin9);
        spinnerIngreds.add(spin10);

        ArrayList<String> sample = new ArrayList<String>();
        sample.add("tums");
        sample.add("xyzzy");
        sample.add("stuff");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sample);
        for (Spinner s : spinnerIngreds) {
            s.setAdapter(arrayAdapter);
        }

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
        }*/
        if (!duplicate) {
            //add recipe
            et = (EditText) findViewById(R.id.directions);
            ImageView iv = (ImageView) findViewById(R.id.recipeimg);
            Drawable img = iv.getDrawable(); // ????
            //get spinner content

        }

    }
}
