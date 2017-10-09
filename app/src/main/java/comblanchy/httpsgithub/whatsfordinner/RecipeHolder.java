package comblanchy.httpsgithub.whatsfordinner;

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
        return ourInstance;
    }

    private RecipeHolder() {
        ingredients.add("example");
        ingredients.add("sample");
        ingredients.add("ample");
    }

    public void addRecipe(Recipe r) {
        cookbook.add(r);
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
        while (!found && i <= cookbook.size()) {
            if (cookbook.get(i).equals(s)) {
                meals.add(cookbook.get(i));
                ingredients.addAll(cookbook.get(i).getIngred());
            }
            i++;
        }
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

    public ArrayList<String> getMeals() {
        ArrayList<String> al = new ArrayList<String>();
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
