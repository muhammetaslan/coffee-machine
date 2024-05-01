package muhammet.aslan.coffee;

import muhammet.aslan.model.Drink;

public class Americano implements Drink {

    public Americano(){
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
        System.out.println("Americano");
    }

    @Override
    public void giveOrderInfo() {

    }
}
