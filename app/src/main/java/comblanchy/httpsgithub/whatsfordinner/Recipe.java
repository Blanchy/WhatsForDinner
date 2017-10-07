package comblanchy.httpsgithub.whatsfordinner;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.ArrayList;

/**
 * Created by blanchypolangcos on 9/16/17.
 * Emulates a recipe with a name, picture, and ingredients.
 */

public class Recipe {

    private String name;
    private ArrayList<String> ingredients;
    private Drawable img;
    private String directions;

    public Recipe(String name, ArrayList<String> ingredients, String directions, Drawable img) {
        this.name = name;
        this.ingredients = ingredients;
        this.img = img;
        this.directions = directions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getIngred() {
        return ingredients;
    }

    public Drawable getImage() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngred(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
