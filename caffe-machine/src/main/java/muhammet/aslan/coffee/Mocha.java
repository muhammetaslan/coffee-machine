package muhammet.aslan.coffee;

import muhammet.aslan.model.Drink;

public class Mocha implements Drink {

    public Mocha(){
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
        System.out.println("Mocha");
    }

    @Override
    public void giveOrderInfo() {

    }
}
