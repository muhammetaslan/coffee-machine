package muhammet.aslan;

import muhammet.aslan.coffee.Americano;
import muhammet.aslan.enums.DrinkType;
import muhammet.aslan.model.Drink;
import muhammet.aslan.model.DrinkFactory;
import muhammet.aslan.model.Ingredient;
import muhammet.aslan.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DrinkFactoryUnitTest {

    @Test
    public void testCreateDrink_Espresso() throws Exception {
        DrinkFactory factory = new DrinkFactory();
        Recipe recipe = mock(Recipe.class);
        Drink drink = factory.createDrink(recipe, DrinkType.espresso);
        assertNotNull(drink);
    }

    @Test
    public void testCreateDrink_InvalidDrinkType() {
        DrinkFactory factory = new DrinkFactory();
        Recipe recipe = mock(Recipe.class);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> factory.createDrink(recipe, DrinkType.unknown));
        assertEquals("Invalid drink type: unknown", exception.getMessage());
    }

}
