package muhammet.aslan.model;

import muhammet.aslan.coffee.*;
import muhammet.aslan.enums.DrinkType;
import muhammet.aslan.softdrink.HotWater;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DrinkFactory {
    private static final Map<DrinkType, Class<? extends Drink>> drinkClasses = new HashMap<>();

    static {
        drinkClasses.put(DrinkType.espresso, Espresso.class);
        drinkClasses.put(DrinkType.doubleespresso, DoubleEspresso.class);
        drinkClasses.put(DrinkType.americano, Americano.class);
        drinkClasses.put(DrinkType.cappuccino, Cappuccino.class);
        drinkClasses.put(DrinkType.caffelatte, CaffeLatte.class);
        drinkClasses.put(DrinkType.mocha, Mocha.class);
        drinkClasses.put(DrinkType.hotwater, HotWater.class);
    }

    public Drink createDrink(DrinkType drinkType) {
        Class<? extends Drink> drinkClass = drinkClasses.get(drinkType);
        if (drinkClass == null) {
            throw new IllegalArgumentException("Invalid drink type: " + drinkType.name());
        }
        try {
            return drinkClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error creating drink instance", e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}