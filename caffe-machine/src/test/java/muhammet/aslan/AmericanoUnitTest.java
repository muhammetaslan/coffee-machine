package muhammet.aslan;

import muhammet.aslan.coffee.Americano;
import muhammet.aslan.model.Ingredient;
import muhammet.aslan.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AmericanoUnitTest {

    @Test
    public void testGetPrice() {
        Recipe recipe = mock(Recipe.class);
        Americano americano = new Americano(recipe);
        assertEquals(66, americano.getPrice());
    }

    @Test
    public void testPrepare() throws SQLException {
        Recipe recipe = mock(Recipe.class);
        List<Ingredient> ingredients = mock(List.class);

        when(recipe.getIngredients()).thenReturn(ingredients);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredients.get(0)).thenReturn(ingredient1);
        when(ingredient1.getName()).thenReturn("Espresso");
        when(ingredient1.getQuantity()).thenReturn(2);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredients.get(1)).thenReturn(ingredient2);
        when(ingredient2.getName()).thenReturn("Hot Water");
        when(ingredient2.getQuantity()).thenReturn(3);

        Map<String, Integer> stockMeterialMap = new HashMap<>();

        stockMeterialMap.put("Espresso", 10);
        stockMeterialMap.put("Hot Water", 15);

        Americano americano = new Americano(recipe);
        americano.prepare(stockMeterialMap);
        // verify that the prepare method was called correctly
    }

}
