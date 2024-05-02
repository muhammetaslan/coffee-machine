package muhammet.aslan.model;

import java.util.List;

public class Recipe {

    private List<Ingredient> ingredients;


    public Recipe(){

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
