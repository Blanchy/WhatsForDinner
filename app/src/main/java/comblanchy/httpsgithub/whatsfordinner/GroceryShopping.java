package comblanchy.httpsgithub.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GroceryShopping extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grocery_shopping);
        lv = (ListView) findViewById(R.id.grocerylist);

        /* https://stackoverflow.com/questions/13281197/android-how-to-create-clickable-listview */

        List<String> sample = new ArrayList<String>();
        sample.add("foo");
        sample.add("bar");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sample);

        lv.setAdapter(arrayAdapter);
    }

    //add swipe detector for left/right
}
