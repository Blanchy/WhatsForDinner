package comblanchy.httpsgithub.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;


public class RecipeLandscape extends Fragment {


    public RecipeLandscape() {
        // Required empty public constructor
    }

    public static RecipeLandscape newInstance(String param1, String param2) {
        RecipeLandscape fragment = new RecipeLandscape();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_landscape, container, false);
    }



}
