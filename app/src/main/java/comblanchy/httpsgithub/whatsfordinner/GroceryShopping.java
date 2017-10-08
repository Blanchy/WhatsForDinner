package comblanchy.httpsgithub.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GroceryShopping extends AppCompatActivity {

    private List<String> sample;
    private ListView lv;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grocery_shopping);
        lv = (ListView) findViewById(R.id.grocerylist);

        /* https://stackoverflow.com/questions/13281197/android-how-to-create-clickable-listview */

        sample = new ArrayList<String>();
        sample.add("foo");
        sample.add("bar");


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sample);

        lv.setAdapter(arrayAdapter);
    }

    public void updateList(View view) {
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sample);
        lv.setAdapter(arrayAdapter);
    }

    public void addNew(View view) {
        EditText et = (EditText) findViewById(R.id.addIngred);
        String ingr = et.getText().toString();
        sample.add(ingr);
        updateList(view);
    }

    //add swipe detector for left/right
}
