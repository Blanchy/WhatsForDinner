package comblanchy.httpsgithub.whatsfordinner;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by blanchypolangcos on 9/16/17.
 * Stores and edits recipes.
 */

public class RecipeList {

    private ArrayList<Recipe> foods;

    public RecipeList() {
        foods = new ArrayList<Recipe>();
    }

    public void addFood(Recipe food) {
        foods.add(food);
    }

    public void addFood(String name, ArrayList<String> ingredients, Image img) {
        foods.add(new Recipe(name, ingredients, img));
    }

    public Recipe getFood(String name) {
        return null;
    }

    public ArrayList<Recipe> getList() {
        return foods;
    }

}
