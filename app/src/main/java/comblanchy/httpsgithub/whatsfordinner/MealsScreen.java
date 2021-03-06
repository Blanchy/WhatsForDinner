package comblanchy.httpsgithub.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MealsScreen extends AppCompatActivity {

    ArrayList<Spinner> mealpickers;
    ArrayList<String>  meals = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_meals_screen);

        ArrayList<Spinner> mealpickers = new ArrayList<Spinner>();

        Spinner s1 = (Spinner) findViewById(R.id.sbreakfast);
        Spinner s2 = (Spinner) findViewById(R.id.slunch);
        Spinner s3 = (Spinner) findViewById(R.id.sdinner);
        Spinner s4 = (Spinner) findViewById(R.id.mbreakfast);
        Spinner s5 = (Spinner) findViewById(R.id.mlunch);
        Spinner s6 = (Spinner) findViewById(R.id.mdinner);
        Spinner s7 = (Spinner) findViewById(R.id.tbreakfast);
        Spinner s8 = (Spinner) findViewById(R.id.tlunch);
        Spinner s9 = (Spinner) findViewById(R.id.tdinner);
        Spinner s10 = (Spinner) findViewById(R.id.wbreakfast);
        Spinner s11 = (Spinner) findViewById(R.id.wlunch);
        Spinner s12 = (Spinner) findViewById(R.id.wdinner);
        Spinner s13 = (Spinner) findViewById(R.id.thbreakfast);
        Spinner s14 = (Spinner) findViewById(R.id.thlunch);
        Spinner s15 = (Spinner) findViewById(R.id.thdinner);
        Spinner s16 = (Spinner) findViewById(R.id.fbreakfast);
        Spinner s17 = (Spinner) findViewById(R.id.flunch);
        Spinner s18 = (Spinner) findViewById(R.id.fdinner);
        Spinner s19 = (Spinner) findViewById(R.id.sabreakfast);
        Spinner s20 = (Spinner) findViewById(R.id.salunch);
        Spinner s21 = (Spinner) findViewById(R.id.sadinner);

        mealpickers.add(s1);
        mealpickers.add(s2);
        mealpickers.add(s3);
        mealpickers.add(s4);
        mealpickers.add(s5);
        mealpickers.add(s6);
        mealpickers.add(s7);
        mealpickers.add(s8);
        mealpickers.add(s9);
        mealpickers.add(s10);
        mealpickers.add(s11);
        mealpickers.add(s12);
        mealpickers.add(s13);
        mealpickers.add(s14);
        mealpickers.add(s15);
        mealpickers.add(s16);
        mealpickers.add(s17);
        mealpickers.add(s18);
        mealpickers.add(s19);
        mealpickers.add(s20);
        mealpickers.add(s21);

        meals.addAll(RecipeHolder.getInstance().getMeals());


        if (savedInstanceState!= null){
            // restore spinner values
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, meals);

        for (final Spinner s : mealpickers) {
            s.setSelection(0);
            s.setAdapter(arrayAdapter);
            s.setFocusable(true);
            s.setFocusableInTouchMode(true);
            s.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (!b) {

                        String meal = (String) s.getSelectedItem();
                        if (!meal.equalsIgnoreCase("Eating outside")) {
                            meals.remove(meal);
                        }
                    }

                }
            });
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        // save spinner values
    }


}
