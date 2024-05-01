package muhammet.aslan.softdrink;

import muhammet.aslan.model.Drink;

/*
 * This class developed for testing purposes.
 * To show that the project can be easily expanded with the abstraction layer.
 * */

public class Coke implements Drink {

    public Coke(){
        super();
    }

    @Override
    public int getPrice() {
        return 30;
    }

    @Override
    public String getDescription() {
        return "Coke is not good for healthy life...";
    }

    @Override
    public boolean checkRawMaterial() {
        return false;
    }

    @Override
    public void prepare() {
        System.out.println("Coke is preparing...");
    }

    @Override
    public void giveOrderInfo() {

    }
}
