package comblanchy.httpsgithub.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecipePortraitFragment extends Fragment {

    private ListView lv;

    public RecipePortraitFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recipe_portrait, container, false);
        lv = (ListView) v.findViewById(R.id.recipelist);

        ArrayList<String> sample = new ArrayList<String>();
        sample.add("foo");
        sample.add("bar");

        ArrayAdapter a = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, sample);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                          //TODO: replace with recipe type
                                          String item = (String) adapterView.getItemAtPosition(i);
                                      }
                                  }
        );

        lv.setAdapter(a);
        // Inflate the layout for this fragment
        return v;

    }

}
