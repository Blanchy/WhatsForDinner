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

    public ArrayList<Recipe> getRecipeList() {
        return cookbook;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public ArrayList<Recipe> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Recipe> meals) {
        this.meals = meals;
    }

    public void setIngredients(ArrayList<String> al) {
        ingredients = al;
    }

}
