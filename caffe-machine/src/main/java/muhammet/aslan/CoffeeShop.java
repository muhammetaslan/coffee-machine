package muhammet.aslan;

import muhammet.aslan.enums.DrinkType;
import muhammet.aslan.model.Drink;
import muhammet.aslan.model.DrinkFactory;
import muhammet.aslan.model.Recipe;
import muhammet.aslan.utils.CoffeeMaterialManagement;
import muhammet.aslan.utils.CustomerMenu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop {

    public static void main(String[] args) throws SQLException {
        // DrinkFactory instance creates Drink object dynamically, ıt provides abstraction for Drink creation
        DrinkFactory drinkFactory = new DrinkFactory();
        Scanner scanner = new Scanner(System.in);
        // Prepare the database and coffee meterials, when the starting the project.
        CoffeeMaterialManagement.getInstance().insertDataIntoCoffeeMaterialStock();

        while (true) {
            CustomerMenu.displayMenu();
            try{
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Çıkış yapılıyor...");
                    break;
                }

                if (choice < 1 || choice > CustomerMenu.productCounter) {
                    System.out.println("Geçersiz bir seçim yaptınız!\n\n");
                    continue;
                }

                // get the customer order's recipe
                Recipe orderedDrinkRecipe = CustomerMenu.getDrinkRecipe(DrinkType.values()[choice - 1]);
                // create the Drink object via factory pattern
                Drink orderedDrink = drinkFactory.createDrink(orderedDrinkRecipe ,DrinkType.values()[choice - 1]);

                // control the stock , before the prepare the order
                boolean isMeterialsExist = orderedDrink.checkRawMaterial(orderedDrinkRecipe,
                        CoffeeMaterialManagement.getInstance().getDataFromCoffeeMaterialStock());

                if(isMeterialsExist){
                    continue;
                }
                orderedDrink.prepare(CoffeeMaterialManagement.getInstance().getDataFromCoffeeMaterialStock());
                orderedDrink.giveOrderInfo();
            } catch (InputMismatchException | IOException e) {
                System.out.println("Geçersiz bir değer girdiniz. Lütfen sadece sayı giriniz.\n\n");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        System.out.println("Tekrar görüşmek üzere!\n\n");
    }
}