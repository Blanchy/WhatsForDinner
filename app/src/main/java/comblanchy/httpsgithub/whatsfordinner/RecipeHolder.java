/*
  @author blanchypolangcos
 * Used references:
 * "Dynamic Layouts using the Fragment Manager" Andrew T. Campbell
 * http://www.cs.dartmouth.edu/~campbell/cs65/lecture09/lecture09.html
 *
 * "Android Programming Concepts" Trish Cornez, Richard Cornez
 */


package comblanchy.httpsgithub.whatsfordinner;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author blanchypolangcos
 */

class RecipeHolder {
    private static final RecipeHolder ourInstance = new RecipeHolder();
    private ArrayList<Recipe> cookbook = new ArrayList<Recipe>();
    private HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
    private ArrayList<Recipe> meals = new ArrayList<Recipe>();

    static RecipeHolder getInstance() {
        //Log.d("Test", "instance of recipe holder");
        return ourInstance;
    }

    private RecipeHolder() {
        ingredients.put("sugar",1);
        ingredients.put("spice",1);
        ingredients.put("everything nice",1);
    }

    public void addRecipe(Recipe r) {
        cookbook.add(r);
    }

    public void removeRecipe(Recipe r) {
        if (cookbook.contains(r)) {
            cookbook.remove(r);
        }
        String debug = "";
        for (Recipe c :cookbook) {
            debug = debug + c.getName() + "\n";
        }
        Log.d("recipe list update", "recipe " + r.getName() + " removed");
        Log.d("new recipe list", debug);
    }

    public void addIngredients(String s) {
        s = s.toLowerCase();

        if (ingredients.containsKey(s)) {
            int newVal = ingredients.get(s) + 1;
            ingredients.put(s, newVal);
        }
        else {
            ingredients.put(s, 1);
        }

    }

    public void addIngredients(ArrayList<String> ss) {
        for (String s : ss) {
            s = s.toLowerCase();
            addIngredients(s);
        }
    }

    public void removeIngredients(String s) {
        s = s.toLowerCase();

        if (ingredients.containsKey(s)) {
            if (ingredients.get(s) < 1) {
                ingredients.remove(s);
            }
            else {
                int newVal = ingredients.get(s) - 1;
                ingredients.put(s, newVal);
            }
        }
    }

    public void addMeals(String s) {
        boolean found = false;
        int i = 0;
        while (!found && i <= cookbook.size() - 1) {

            if (cookbook.get(i).getName().equals(s)) {
                meals.add(cookbook.get(i));
                addIngredients(cookbook.get(i).getIngred());
            }
            i++;
        }
        Log.d("Test", "meal method accessed");
    }

    public Recipe getRecipe(String name) {
        Recipe r = null;
        boolean found = false;
        int i = 0;
        while (!found && i <= cookbook.size() - 1) {
            if (cookbook.get(i).getName().equals(name)) {
                r = cookbook.get(i);
            }
            i++;
        }
        return r;
    }

    public ArrayList<Recipe> getRecipeList() {
        return cookbook;
    }

    public ArrayList<String> getRecipeString() {
        ArrayList<String> al = new ArrayList<String>();
        for (Recipe r : cookbook) {
            al.add(r.getName());
        }
        return al;
    }

    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getAvailIngreds() {
        ArrayList<String> ingreds = new ArrayList<String>();
        for (String s : ingredients.keySet()) {
            if (ingredients.get(s) > 0) {
                ingreds.add(s);
            }
        }
        return ingreds;
    }

    public ArrayList<String> getMeals() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Eating Outside");
        for (Recipe r : meals) {
            al.add(r.getName());
        }
        return al;
    }

    public void setMeals(ArrayList<Recipe> meals) {
        this.meals = meals;
    }

}
