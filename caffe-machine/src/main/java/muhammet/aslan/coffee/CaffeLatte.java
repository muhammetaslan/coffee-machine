package muhammet.aslan.coffee;

import muhammet.aslan.model.Drink;

public class CaffeLatte implements Drink {

    public CaffeLatte(){
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
        System.out.println("CaffeLatte");
    }

    @Override
    public void giveOrderInfo() {

    }
}
