/**
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
    EditText recName;
    private ArrayList<Spinner> spinnerIngreds;
    private ArrayList<Recipe> cookbook;

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

        cookbook = readArrayRecipe();

        recName = (EditText) findViewById(R.id.directions);
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

        /*if coming from recipes screen, set text/drawables for all elements*/
        if (intent.hasExtra("edit")) {
            //get recipe name to read file and populate areas
        }


        ArrayList<String> sample = new ArrayList<String>();
        sample.add("nothing");
        sample.add("tums");
        sample.add("xyzzy");
        sample.add("stuff");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sample);
        for (Spinner s : spinnerIngreds) {
            s.setAdapter(arrayAdapter);
            s.setSelection(0);
        }


    }

    public void addRecipe(View view) {
        String recipeStr = recName.getText().toString();

        if (!isDuplicate(recipeStr)) {
            //add recipe
            EditText et = (EditText) findViewById(R.id.directions);
            String directions = et.getText().toString();
            ImageView iv = (ImageView) findViewById(R.id.recipeimg);
            Drawable img = iv.getDrawable(); // ????
            ArrayList<String> ingredientsfinal = new ArrayList<String>();

            //TODO: get spinner content
            for (Spinner s : spinnerIngreds) {
                ingredientsfinal.add(s.getSelectedItem().toString());

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
        boolean b = false;
        for (Recipe r : cookbook) {
            if (r.getName().equals(name)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * Add new recipe
     * @param r Recipe to add
     */
    public void success(Recipe r) {
        Toast confirm = Toast.makeText(this, "Recipe saved!", Toast.LENGTH_LONG);
        confirm.show();
        Intent intent = new Intent(this, MainMenu.class);
        deleteFile("cookbook");
        cookbook.add(r);
        //store(cookbook);
        store(r);
        startActivity(intent);
    }

    /**
     * Used code from:
     * https://stackoverflow.com/a/17047638
     */
    private void store(Recipe r) {
        String filname = (String) recName.getText().toString();
        try {
            FileOutputStream fos = openFileOutput(filname, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(r);
            oos.flush();
            oos.close();
            fos.close();
        }
        catch (Exception e) {
            Log.e("InternalStorage", e.getMessage());
        }
        Toast verify = Toast.makeText(this, "file saved", Toast.LENGTH_LONG);
        verify.show();
    }

    /**
     * Used code from:
     * https://stackoverflow.com/a/17047638
     */
    private void store(ArrayList<Recipe> ar) {
        try {
            FileOutputStream fos = openFileOutput("cookbook", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ar);
            oos.flush();
            oos.close();
            fos.close();
        }
        catch (Exception e) {
            Log.e("InternalStorage", e.getMessage());
        }
        Toast verify = Toast.makeText(this, "array saved", Toast.LENGTH_LONG);
        verify.show();
    }

    /**
     * Used code from:
     * https://stackoverflow.com/a/17047638
     */
    private Recipe readRecipe(String fn) {
        Recipe r = null;
        FileInputStream fis;
        try {
            fis = openFileInput(fn);
            ObjectInputStream oi = new ObjectInputStream(fis);
            r = (Recipe) oi.readObject();
            oi.close();
        } catch (FileNotFoundException e) {
            Log.e("InternalStorage", e.getMessage());
        } catch (IOException e) {
            Log.e("InternalStorage", e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("InternalStorage", e.getMessage());
        }

        return r;
    }

    /**
     * Used code from:
     * https://stackoverflow.com/a/17047638
     */
    private ArrayList<Recipe> readArrayRecipe() {
        ArrayList<Recipe> ar = null;

        FileInputStream fis;
        try {
            fis = openFileInput("cookbook");
            ObjectInputStream oi = new ObjectInputStream(fis);
            ar = (ArrayList<Recipe>) oi.readObject();
            oi.close();
        } catch (FileNotFoundException e) {
            store(new ArrayList<Recipe>());
            //Log.e("InternalStorage", e.getMessage());
        } catch (IOException e) {
            Log.e("InternalStorage", e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("InternalStorage", e.getMessage());
        }

        return ar;
    }
}
