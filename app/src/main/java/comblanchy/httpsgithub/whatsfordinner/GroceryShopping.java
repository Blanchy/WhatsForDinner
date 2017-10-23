/**
 * @author blanchypolangcos
 * References used:
 *  https://stackoverflow.com/questions/13281197/android-how-to-create-clickable-listview/
 *
 *  jonndavis1993 Android-Tutorials source code
 *  for the purpose of creating listview items with buttons
 *  https://github.com/jonndavis1993/Android-Tutorials/tree/master/app
 *
 *  Code for strikethrough text from hovanessyan:
 *  https://stackoverflow.com/a/9786629
 */

package comblanchy.httpsgithub.whatsfordinner;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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


        //arrayAdapter = new ArrayAdapter<String>
        //        (this, android.R.layout.simple_list_item_1,
        //                getList(getNonDuplicates(RecipeHolder.getInstance().getIngredients())));

        List<String> list = new ArrayList<String>();
        list.addAll(RecipeHolder.getInstance().getIngredients().keySet());

        arrayAdapter = new GroceryAdapter(
                this,
                R.layout.grocery_list_item,
                list);

        lv.setAdapter(arrayAdapter);
    }


    public void addNew(View view) {
        EditText et = (EditText) findViewById(R.id.addIngred);
        String ingr = et.getText().toString();
        RecipeHolder.getInstance().addIngredients(ingr);
        updateList();
        et.setText("");
    }

    public void updateList() {

        List<String> list = new ArrayList<String>();
        list.addAll(RecipeHolder.getInstance().getIngredients().keySet());

        arrayAdapter = new GroceryAdapter(
                this,
                R.layout.grocery_list_item,
                list);

        lv.setAdapter(arrayAdapter);
    }

    /*
    jonndavis1993 Android-Tutorials source code
 *  for the purpose of creating listview items with buttons
 *  https://github.com/jonndavis1993/Android-Tutorials/tree/master/app
     */
    private class GroceryAdapter extends ArrayAdapter<String> {
        private int layout;
        private List<String> objects;
        private Context context;

        public GroceryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            this.objects = objects;
            layout = resource;
            this.context = context;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);

                ViewHolder vh = new ViewHolder();

                vh.add = (ImageButton) convertView.findViewById(R.id.adding);
                vh.subtract = (ImageButton) convertView.findViewById(R.id.reming);
                vh.name = (TextView) convertView.findViewById(R.id.ingname);
                vh.quantity = (TextView) convertView.findViewById(R.id.quantity);
                convertView.setTag(vh);
            }

            HashMap<String, Integer> ingredients = RecipeHolder.getInstance().getIngredients();

            mainViewholder = (ViewHolder) convertView.getTag();
            // add fling listener

            mainViewholder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("groceries", "subtracting");
                    RecipeHolder.getInstance().addIngredients(getItem(position));
                    updateList();
                }
            });
            mainViewholder.subtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("groceries", "subtracting");
                    RecipeHolder.getInstance().removeIngredients(getItem(position));
                    updateList();
                }
            });

            mainViewholder.name.setText(getItem(position));

            Log.d("groceries", "got name...");

            int numOfThings = ingredients.get(mainViewholder.name.getText().toString());

            mainViewholder.quantity.setText(numOfThings + "");

            /*
            Code for strikethrough text from hovanessyan:
            https://stackoverflow.com/a/9786629
             */
            if (numOfThings < 1) {
                mainViewholder.name.setPaintFlags(mainViewholder.name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
            return convertView;

        }

        public class ViewHolder {
            TextView name;
            TextView quantity;
            ImageButton add;
            ImageButton subtract;
        }
    }
}
