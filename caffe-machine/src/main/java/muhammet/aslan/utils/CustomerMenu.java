package muhammet.aslan.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import muhammet.aslan.enums.DrinkType;
import muhammet.aslan.model.Recipe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomerMenu {
    public static int productCounter = 0;

    public static InputStream getPropertiesFileData() throws FileNotFoundException {
        String coffeePropertiesPath = System.getProperty("user.dir") + "/src/main/resources/coffee.properties";
        return new FileInputStream(coffeePropertiesPath);
    }

    // Load properties file, match the DrinkType enum value. Then create customer menu dynamically.
    public static void displayMenu(){
        Properties props = new Properties();
        InputStream input = null;
        try {
            input = getPropertiesFileData();
            props.load(input);
            productCounter = 0;
            for (DrinkType type : DrinkType.values()) {
                System.out.println(props.getProperty(type.name()));
                productCounter++;
            }
            System.out.print("Lütfen içmek istediğiniz kahvenin numarasını giriniz (Çıkmak için '0' tuşlayınız): ");

        } catch (FileNotFoundException e) {
            System.out.println("coffee.properties file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // return the recipe of the specified Drink type
    public static Recipe getDrinkRecipe(DrinkType drinkType) throws IOException {
        Properties props = new Properties();
        ObjectMapper mapper = new ObjectMapper();
        InputStream input;
        input = getPropertiesFileData();
        props.load(input);

        Recipe recipe = mapper.readValue(props.getProperty(drinkType.name() + ".recipe"), Recipe.class);

        return recipe;
    }
}
