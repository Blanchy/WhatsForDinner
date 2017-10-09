/**
 * @author blanchypolangcos
 * References used:
 *  https://stackoverflow.com/questions/13281197/android-how-to-create-clickable-listview/
 */

package comblanchy.httpsgithub.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GroceryShopping extends AppCompatActivity {

    private ListView lv;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grocery_shopping);
        lv = (ListView) findViewById(R.id.grocerylist);

        /* https://stackoverflow.com/questions/13281197/android-how-to-create-clickable-listview */


        arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,
                        getList(getNonDuplicates(RecipeHolder.getInstance().getIngredients())));

        lv.setAdapter(arrayAdapter);
    }


    public void addNew(View view) {
        EditText et = (EditText) findViewById(R.id.addIngred);
        String ingr = et.getText().toString();
        RecipeHolder.getInstance().addIngredients(ingr);
        updateList(view);
        et.setText("");
    }

    public void updateList(View view) {

        arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,
                        getList(getNonDuplicates(RecipeHolder.getInstance().getIngredients())));

        lv.setAdapter(arrayAdapter);
    }


    //add swipe detector for left/right

    private HashMap<String, Integer> getNonDuplicates(ArrayList<String> al) {
        Log.d("GS", "nonDuplicates");
        HashMap<String, Integer> inventory = new HashMap<String, Integer>();
        for (String s : al) {

            if (!s.equalsIgnoreCase("nothing")) {

                if (inventory.containsKey(s)) {
                    int newVal = inventory.get(s) + 1;
                    inventory.put(s, newVal);
                }
                else {
                    inventory.put(s, 1);
                }
            }
        }
        return inventory;
    }

    private ArrayList<String> getList(HashMap<String,Integer> hm) {
        Log.d("GS", "getList");
        ArrayList<String> list = new ArrayList<String>();

        Set<String> keys = hm.keySet();
        for (String s : keys) {
            list.add(s + " - " + hm.get(s));
        }
        return list;
    }
}
