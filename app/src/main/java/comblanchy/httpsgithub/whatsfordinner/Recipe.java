package comblanchy.httpsgithub.whatsfordinner;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by blanchypolangcos on 9/16/17.
 * Emulates a recipe with a name, picture, and ingredients.
 */

public class Recipe {

    private String name;
    private ArrayList<String> ingredients;
    private Image img;

    public Recipe(String name, ArrayList<String> ingredients, Image img) {
        this.name = name;
        this.ingredients = ingredients;
        this.img = img;
    }
}
