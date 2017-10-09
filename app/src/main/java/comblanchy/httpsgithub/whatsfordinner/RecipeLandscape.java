package comblanchy.httpsgithub.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class RecipeLandscape extends Fragment {
    private TextView detailname;
    private TextView detailingredients;
    private TextView detaildirections;
    private ImageView detailimg;

    public RecipeLandscape() {
        // Required empty public constructor
    }

    public static RecipeLandscape newInstance(int index) {
        RecipeLandscape fragment = new RecipeLandscape();

        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);

        return fragment;
    }

    public int getIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recipe_landscape, container, false);

        detaildirections = (TextView) v.findViewById(R.id.detaildirect);
        detailingredients = (TextView) v.findViewById(R.id.addIngred);
        detailname = (TextView) v.findViewById(R.id.detailname);

        /**
        //change to recipe indices
        Recipe curRec = (RecipeHolder.getInstance().getRecipeList()).get(getIndex());
        detailname.setText(curRec.getName());
        detaildirections.setText(curRec.getDirections());
        detailimg.setImageDrawable(curRec.getImage());*/
        return v;

    }

}
