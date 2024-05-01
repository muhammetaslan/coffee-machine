package muhammet.aslan.coffee;

import muhammet.aslan.model.Drink;

public class Cappuccino implements Drink {

    public Cappuccino(){
        super();
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean checkRawMaterial() {
        return false;
    }

    @Override
    public void prepare() {
        System.out.println("Cappuccino");
    }

    @Override
    public void giveOrderInfo() {

    }
}
