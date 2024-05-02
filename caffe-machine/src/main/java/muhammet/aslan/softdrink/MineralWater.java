package muhammet.aslan.softdrink;

import muhammet.aslan.model.Drink;
import muhammet.aslan.model.Ingredient;
import muhammet.aslan.model.Recipe;

import java.util.List;
import java.util.Map;

/*
 * This class developed for testing purposes.
 * To show that the project can be easily expanded with the abstraction layer.
 * */

public class MineralWater extends Drink {

    private Recipe recipe;

    public MineralWater(Recipe recipe){
        super();
        this.recipe = recipe;
    }

    @Override
    public int getPrice() {
        return 18;
    }

    @Override
    public void prepare(Map<String, Integer> stockMeterialMap) {
        System.out.println("Teşekkürler MineralWater hazırlanıyor.");
    }

    @Override
    public void giveOrderInfo() {
        System.out.println("************************************************************");
        System.out.println("MineralWater seçtiniz. Bu içeceğimizin içeriği şu şekildedir\n");
        List<Ingredient> ingredients = getRecipe().getIngredients();
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getQuantity() + " doz " + ingredient.getName());
        }
        System.out.println("************************************************************");
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
