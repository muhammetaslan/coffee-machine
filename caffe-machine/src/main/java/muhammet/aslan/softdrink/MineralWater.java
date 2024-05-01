package muhammet.aslan.softdrink;

import muhammet.aslan.model.Drink;

/*
 * This class developed for testing purposes.
 * To show that the project can be easily expanded with the abstraction layer.
 * */

public class MineralWater implements Drink {

    public MineralWater(){
        super();
    }

    @Override
    public int getPrice() {
        return 18;
    }

    @Override
    public String getDescription() {
        return "Mineral water is required for healthy life...";
    }

    @Override
    public boolean checkRawMaterial() {
        return false;
    }

    @Override
    public void prepare() {
        System.out.println("MineralWater is preparing...");
    }

    @Override
    public void giveOrderInfo() {

    }
}
