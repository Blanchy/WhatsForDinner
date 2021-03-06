/**
 * @author blanchypolangcos
 * Used code from:
 * https://stackoverflow.com/a/17047638
 * for the purpose of reading/writing to internal storage.
 */

package comblanchy.httpsgithub.whatsfordinner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewDishScreen extends AppCompatActivity {

    EditText recName;
    private ArrayList<Spinner> spinnerIngreds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_screen);

        Intent intent = getIntent();

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

        recName = (EditText) findViewById(R.id.recipename);
        recName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (isDuplicate((String) recName.getText().toString())) {
                        deny();
                    }
                }
            }
        });

        // make the first item null
        ArrayList<String> ingredientList = new ArrayList<String>();
        ingredientList.add("");
        ingredientList.addAll(RecipeHolder.getInstance().getAvailIngreds());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ingredientList);
        for (Spinner s : spinnerIngreds) {
            s.setAdapter(arrayAdapter);
        }

             /*if coming from recipes screen, set text/drawables for all elements*/
        if (intent.hasExtra("edit")) {

            String recipeNameString = intent.getStringExtra("edit");
            Recipe r = RecipeHolder.getInstance().getRecipe(recipeNameString);
            if (r != null) { //get recipe name to read file and populate areas
                recName.setText(r.getName());
                EditText recDirect = (EditText) findViewById(R.id.directions);
                recDirect.setText(r.getDirections());
                ImageView iv = (ImageView) findViewById(R.id.recipeimg);
                iv.setImageDrawable(r.getImage());
                //setSpinners(r.getIngred());
            }

        }


    }
/*
    private void setSpinners(ArrayList<String> ingreds) {

        int i = 0; //ingredient of ingred
        for (Spinner s : spinnerIngreds) {
            Log.d("NDS", "finding " + ingreds.get(i));
            s.setSelection(RecipeHolder.getInstance().getIngIndex(ingreds.get(i)));
        }
    }
*/
    public void addRecipe(View view) {
        Log.d("nd", "addRecipe");
        String recipeStr = recName.getText().toString();

        if (!isDuplicate(recipeStr)||getIntent().hasExtra("edit")) {
            //add recipe
            EditText et = (EditText) findViewById(R.id.directions);
            String directions = et.getText().toString();
            ImageView iv = (ImageView) findViewById(R.id.recipeimg);
            Drawable img = iv.getDrawable(); // ????
            ArrayList<String> ingredientsfinal = new ArrayList<String>();

            //get spinner content
            for (Spinner s : spinnerIngreds) {
                String thing = s.getSelectedItem().toString();
                if (thing.length() > 0) {
                    ingredientsfinal.add(thing);
                }
            }
            success(new Recipe(recipeStr, ingredientsfinal, directions, img));
        }
        else {
            deny();
        }

    }

    public void deny() {
        Toast deny = Toast.makeText(this, "Recipe name already exists.", Toast.LENGTH_LONG);
        deny.show();
    }

    /**
     *
     * @return if name already exists
     */
    public boolean isDuplicate(String name) {
        Log.d("nd", "isDuplicate");
        boolean b = false;
        for (Recipe r : RecipeHolder.getInstance().getRecipeList()) {
            if (r.getName().equalsIgnoreCase(name)) {
                b = true;
            }
        }
        if (getIntent().hasExtra("edit")) {
           return false;
        }
        return b;
    }

    /**
     * Add new recipe
     * @param r Recipe to add
     */
    public void success(Recipe r) {
        Log.d("nd", "success");
        Toast confirm = Toast.makeText(this, "Recipe saved!", Toast.LENGTH_LONG);
        confirm.show();
        Intent intent = new Intent(this, MainMenu.class);
        RecipeHolder.getInstance().removeRecipe(r); //if editing a recipe, this removes the pre-existing version
        RecipeHolder.getInstance().addRecipe(r);
        startActivity(intent);
    }

}
