/**
 * @author blanchypolangcos
 * references:
 *
 *     https://stackoverflow.com/a/45077688
 */

package comblanchy.httpsgithub.whatsfordinner;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    // recipes and ingredients
    static final ArrayList<Recipe> cookbook = new ArrayList<Recipe>();
    private ArrayList<String> fridge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


    }

    public void toNewDish(View view) {
        Intent intent = new Intent(this, NewDishScreen.class);
        startActivity(intent);
    }

    public void toRecipes(View view) {
        Intent intent = new Intent(this, RecipeScreen.class);
        startActivity(intent);
    }

    public void toGroceries(View view) {
        Intent intent = new Intent(this, GroceryShopping.class);
        startActivity(intent);
    }

    public void toMeals(View view) {
        Intent intent = new Intent(this, MealsScreen.class);
        startActivity(intent);
    }

    /** Reference:
     * https://stackoverflow.com/a/45077688
     */
    public void showCredits(View view) {
        // pop up screen for title
        ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.mainmenu);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        final PopupWindow popup = new PopupWindow
                (popupView, ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT, true);

        popup.showAtLocation(cl, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popup.dismiss();
                return true;
            }
        });
    }
}