package muhammet.aslan;

import muhammet.aslan.utils.CoffeeMaterialManagement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMaterialManagementIntegrationTest {

    @Test
    public void testInsertDataIntoCoffeeMaterialStock() throws SQLException {
        CoffeeMaterialManagement instance = CoffeeMaterialManagement.getInstance();
        instance.insertDataIntoCoffeeMaterialStock();
        assertNotNull(instance);
    }

    @Test
    public void testGetDataFromCoffeeMaterialStock() throws SQLException {
        CoffeeMaterialManagement instance = CoffeeMaterialManagement.getInstance();
        instance.insertDataIntoCoffeeMaterialStock();
        Map<String, Integer> stockMap = instance.getDataFromCoffeeMaterialStock();
        assertNotNull(stockMap);
        assertEquals(5, stockMap.size());
        assertEquals(10, (int) stockMap.get("hotwater"));
        assertEquals(10, (int) stockMap.get("espresso"));
        assertEquals(10, (int) stockMap.get("steamedmilk"));
        assertEquals(10, (int) stockMap.get("milkfoam"));
        assertEquals(10, (int) stockMap.get("hotchocolate"));
    }

    @Test
    public void testUpdateQuantityInCoffeeMaterialStock() throws SQLException {
        CoffeeMaterialManagement instance = CoffeeMaterialManagement.getInstance();
        instance.updateQuantityInCoffeeMaterialStock("hotwater", 20);
        Map<String, Integer> stockMap = instance.getDataFromCoffeeMaterialStock();
        assertEquals(20, (int) stockMap.get("hotwater"));
    }
}
