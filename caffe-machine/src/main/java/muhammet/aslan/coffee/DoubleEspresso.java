package muhammet.aslan.coffee;

import muhammet.aslan.model.Drink;

public class DoubleEspresso implements Drink {

    public DoubleEspresso(){
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
        System.out.println("DoubleEspresso");
    }

    @Override
    public void giveOrderInfo() {

    }
}
