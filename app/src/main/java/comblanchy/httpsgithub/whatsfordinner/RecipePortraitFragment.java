package comblanchy.httpsgithub.whatsfordinner;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
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
    private TextView detIng;
    private TextView detNam;
    private TextView detDir;
    private ImageView iv;
    private int index;

    public RecipePortraitFragment() {
        // Required empty public constructor
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
                                          index = i;

                                          if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

                                              if (getActivity() instanceof RecipeScreen) {
                                                  ((RecipeScreen) getActivity()).showRecipe(index);
                                              }
                                          }
                                      }
                                  }
        );
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                //TODO: send intents to recipe screen. send string of recipe and remove from arraylist

                Intent intent = new Intent(getActivity(), NewDishScreen.class);
                startActivity(intent);
                return true;
            }
        });

        lv.setAdapter(a);
        // Inflate the layout for this fragment
        return v;

    }



}
