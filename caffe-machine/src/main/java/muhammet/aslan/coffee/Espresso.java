package muhammet.aslan.coffee;

import muhammet.aslan.model.Drink;
import muhammet.aslan.model.Ingredient;
import muhammet.aslan.model.Recipe;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Espresso extends Drink {

    private Recipe recipe;

    public Espresso(Recipe recipe){
        super();
        this.recipe = recipe;
    }

    @Override
    public int getPrice() {
        return 42;
    }


    @Override
    public void prepare(Map<String, Integer> stockMeterialMap) throws SQLException {
        System.out.println("Teşekkürler kahveniz hazırlanıyor.");
        List<Ingredient> ingredients = getRecipe().getIngredients();
        fillEspresso(ingredients.get(0).getName(), (stockMeterialMap.get(ingredients.get(0).getName()) - ingredients.get(0).getQuantity()));
    }

    @Override
    public void giveOrderInfo() {
        System.out.println("********************************************************");
        System.out.println("Espresso seçtiniz. Bu içeceğimizin içeriği şu şekildedir\n");
        List<Ingredient> ingredients = getRecipe().getIngredients();
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getQuantity() + " doz " + ingredient.getName());
        }
        System.out.println("*********************************************************");
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
