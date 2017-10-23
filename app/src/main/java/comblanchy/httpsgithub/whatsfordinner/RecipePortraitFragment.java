/*
  @author blanchypolangcos
 * Used references:
 * "Dynamic Layouts using the Fragment Manager" Andrew T. Campbell
 * http://www.cs.dartmouth.edu/~campbell/cs65/lecture09/lecture09.html
 *
 * "Android Programming Concepts" Trish Cornez, Richard Cornez
 */

package comblanchy.httpsgithub.whatsfordinner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecipePortraitFragment extends Fragment {

    private ListView lv;
    private int index;
    private OnItemSelectedListener oisl;


    public RecipePortraitFragment() {
        // Required empty public constructor
    }

    public interface OnItemSelectedListener {
        void onRecipeSelected(String recipe);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = null;
        if (context instanceof Activity) { a = (Activity) context; }

        if (context instanceof OnItemSelectedListener) {
            oisl = (OnItemSelectedListener) context;
        }
        else {
            throw new ClassCastException(context.toString() + " not instance of RecipePortraitFragment.OnItemSelectedListener");
        }
    }

    /**
     *  Referenced code from Yoann Hercouet on StackOverflow
     *  https://stackoverflow.com/a/34747012
     */
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (activity instanceof OnItemSelectedListener) {
                oisl = (OnItemSelectedListener) activity;
            }
            else {
                throw new ClassCastException(activity.toString() + " not instance of RecipePortraitFragment.OnItemSelectedListener");
            }
        }
    }

    public void updateView(String recipe) {
        oisl.onRecipeSelected(recipe);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            index = 0;
        }
        else {
            index = savedInstanceState.getInt("index", 0);
        }

        View v = inflater.inflate(R.layout.fragment_recipe_portrait, container, false);
        lv = (ListView) v.findViewById(R.id.recipelist);

        ArrayAdapter a = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_activated_1, RecipeHolder.getInstance().getRecipeString());

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                          String item = (String) adapterView.getItemAtPosition(i);
                                          Log.d("rpf", "item get " + item.getClass());
                                          //RecipeHolder.getInstance().addMeals(item);
                                          index = i;
                                          updateView(item);
                                      }
                                  }
        );
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                //send intents to recipe screen. send string of recipe and remove from arraylist
                String item = (String) arg0.getItemAtPosition(pos);
                Intent intent = new Intent(getActivity(), NewDishScreen.class);
                intent.putExtra("edit", item);
                startActivity(intent);
                return true;
            }
        });

        lv.setAdapter(a);
        // Inflate the layout for this fragment
        return v;

    }



}
