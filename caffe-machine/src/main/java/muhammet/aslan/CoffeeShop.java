package muhammet.aslan;

import muhammet.aslan.enums.DrinkType;
import muhammet.aslan.model.Drink;
import muhammet.aslan.model.DrinkFactory;
import muhammet.aslan.utils.CustomerMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop {

    public static void main(String[] args) {

        DrinkFactory drinkFactory = new DrinkFactory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            CustomerMenu.displayMenu();
            System.out.print("Lütfen içmek istediğiniz kahvenin numarasını giriniz (Çıkmak için '0' tuşlayınız): ");
            try{
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Çıkış yapılıyor...");
                    break;
                }

                if (choice < 1 || choice > CustomerMenu.productCounter) {
                    System.out.println("Geçersiz bir seçim yaptınız!");
                    continue;
                }

                Drink orderedDrink = drinkFactory.createDrink( DrinkType.values()[choice - 1]);

                orderedDrink.prepare();

                System.out.println("Teşekkürler kahveniz hazırlanıyor.");

                System.out.print("Tüketilen hammadde bilgisi ve miktar: ");

            } catch (InputMismatchException e) {
                System.out.println("Geçersiz bir değer girdiniz. Lütfen sadece sayı giriniz.");
                scanner.nextLine(); // Clear the input buffer
            }

            System.out.println("Afiyet Olsun.\n\n");
        }

        System.out.println("Tekrar görüşmek üzere!");
    }

}