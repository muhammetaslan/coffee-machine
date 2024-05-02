package muhammet.aslan;

import muhammet.aslan.coffee.DoubleEspresso;
import muhammet.aslan.coffee.Espresso;
import muhammet.aslan.enums.DrinkType;
import muhammet.aslan.model.Drink;
import muhammet.aslan.model.DrinkFactory;
import muhammet.aslan.model.Recipe;
import muhammet.aslan.softdrink.HotWater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DrinkFactoryIntegrationTest {

    @Test
    public void testCreateDrink_Espresso() {
        DrinkFactory factory = new DrinkFactory();
        Recipe recipe = new Recipe(); // create a valid recipe instance
        Drink drink = factory.createDrink(recipe, DrinkType.espresso);
        assertNotNull(drink);
        assertEquals(Espresso.class, drink.getClass());
    }

    @Test
    public void testCreateDrink_DoubleEspresso() {
        DrinkFactory factory = new DrinkFactory();
        Recipe recipe = new Recipe(); // create a valid recipe instance
        Drink drink = factory.createDrink(recipe, DrinkType.doubleespresso);
        assertNotNull(drink);
        assertEquals(DoubleEspresso.class, drink.getClass());
    }

    @Test
    public void testCreateDrink_HotWater() {
        DrinkFactory factory = new DrinkFactory();
        Recipe recipe = new Recipe(); // create a valid recipe instance
        Drink drink = factory.createDrink(recipe, DrinkType.hotwater);
        assertNotNull(drink);
        assertEquals(HotWater.class, drink.getClass());
    }
}