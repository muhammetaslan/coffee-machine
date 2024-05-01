package muhammet.aslan.model;

public interface Drink {

    int getPrice();

    String getDescription();

    boolean checkRawMaterial();

    void prepare();

    void giveOrderInfo();
}
