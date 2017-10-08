package comblanchy.httpsgithub.whatsfordinner;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by blanchypolangcos on 9/16/17.
 * Emulates a recipe with a name, picture, and ingredients.
 */

public class Recipe implements Parcelable {

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

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getName() {
        return name;
    }

    public ArrayList<String> getIngred() {
        return ingredients;
    }

    public Drawable getImage() {
        return img;
    }

    public String getDirections() { return directions; }

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

    @Override
    public String toString() {
        return getName();
    }

    public Recipe (Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] {this.name,
                String.valueOf(this.ingredients),
                this.directions});
    }

}
