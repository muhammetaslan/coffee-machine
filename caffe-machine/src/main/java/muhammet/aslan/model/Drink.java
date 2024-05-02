package muhammet.aslan.model;

import muhammet.aslan.utils.CoffeeMaterialManagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class Drink {

    private Recipe recipe;

    public abstract int getPrice();

    public abstract void prepare(Map<String, Integer> stockMeterialMap) throws SQLException;

    public abstract void giveOrderInfo();

    // this method control the product recipe requirenments and current stock
    public boolean checkRawMaterial(Recipe recipe, Map<String, Integer> stockMeterialMap) {
        List<Ingredient> ingredients = recipe.getIngredients();
        for (Ingredient ingredient : ingredients) {
            String meterialName = ingredient.getName();
            int quantity = ingredient.getQuantity();
            if (stockMeterialMap.containsKey(meterialName)) {
                int stockQuantity = stockMeterialMap.get(meterialName);
                if (stockQuantity < quantity) {
                    System.out.println("yeterli " + meterialName +  " malzeme yok. Gerekli olan: " + quantity + ", Mevcut: " + stockQuantity);
                    return true;
                }
            } else {
                System.out.println(meterialName + " stok yok.");
                return true;
            }
        }

        return false;
    }

    public void fillHotWater(String meterial, int quantity) throws SQLException {
        CoffeeMaterialManagement.getInstance().updateQuantityInCoffeeMaterialStock(meterial,quantity);
    }

    public void fillEspresso(String meterial, int quantity) throws SQLException {
        CoffeeMaterialManagement.getInstance().updateQuantityInCoffeeMaterialStock(meterial,quantity);
    }

    public void fillSteamedMilk(String meterial, int quantity) throws SQLException {
        CoffeeMaterialManagement.getInstance().updateQuantityInCoffeeMaterialStock(meterial,quantity);
    }

    public void fillMilkFoam(String meterial, int quantity) throws SQLException {
        CoffeeMaterialManagement.getInstance().updateQuantityInCoffeeMaterialStock(meterial,quantity);
    }

    public void fillHotChocolate(String meterial, int quantity) throws SQLException {
        CoffeeMaterialManagement.getInstance().updateQuantityInCoffeeMaterialStock(meterial,quantity);
    }
}
