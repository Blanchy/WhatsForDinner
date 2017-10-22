/**
 * @author blanchypolangcos
 */

package comblanchy.httpsgithub.whatsfordinner;

import android.util.Log;

import java.util.ArrayList;

/**
 * @author blanchypolangcos
 */

class RecipeHolder {
    private static final RecipeHolder ourInstance = new RecipeHolder();
    private ArrayList<Recipe> cookbook = new ArrayList<Recipe>();
    private ArrayList<String> ingredients = new ArrayList<String>();
    private ArrayList<Recipe> meals = new ArrayList<Recipe>();

    static RecipeHolder getInstance() {
        //Log.d("Test", "instance of recipe holder");
        return ourInstance;
    }

    private RecipeHolder() {
        ingredients.add("sugar");
        ingredients.add("spice");
        ingredients.add("everything nice");
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
        ingredients.add(s);
    }

    public void addIngredients(ArrayList<String> ss) {
        ingredients.addAll(ss);
    }

    public void addMeals(String s) {
        boolean found = false;
        int i = 0;
        while (!found && i <= cookbook.size() - 1) {

            if (cookbook.get(i).getName().equals(s)) {
                meals.add(cookbook.get(i));
                ingredients.addAll(cookbook.get(i).getIngred());
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

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public int getIngIndex(String s) {
        int i = -1;
        boolean b = false;
        int x = 0; //iterator
        while (!b && x <= ingredients.size()-1) {
            if (ingredients.get(x).equalsIgnoreCase(s)) {
                i = x;
                b = true;
                x++;
            }
        }
        return i;
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

    public void setIngredients(ArrayList<String> al) {
        ingredients = al;
    }

}
