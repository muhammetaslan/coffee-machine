package muhammet.aslan.softdrink;

import muhammet.aslan.model.Drink;

public class HotWater implements Drink {

    public HotWater(){
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
        System.out.println("Hot Water");
    }

    @Override
    public void giveOrderInfo() {

    }
}
