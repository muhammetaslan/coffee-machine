package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Espresso (42 ₺)\n" +
                    "2. Double Espresso (56 ₺)\n" +
                    "3. Cappuccino (77 ₺)\n" +
                    "4. Caffe Latte (77 ₺)\n" +
                    "5. Mocha (81 ₺)\n" +
                    "6. Americano (66 ₺)\n" +
                    "7. Hot Water (10 ₺)");
            System.out.print("Lütfen içmek istediğiniz kahvenin numarasını giriniz (Çıkmak için '0' tuşlayınız): ");
            try{
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Çıkış yapılıyor...");
                    break;
                }

                if (choice < 1 || choice > 7) {
                    System.out.println("Geçersiz bir seçim yaptınız.");
                    continue;
                }


                System.out.println("Teşekkürler kahveniz hazırlanıyor.");

                System.out.print("Tüketilen hammadde bilgisi ve miktar: ");

                switch (choice) {
                    case 1:
                        System.out.println("Espresso (1 adet)");
                        break;
                    case 2:
                        System.out.println("Espresso (2 adet)");
                        break;
                    case 3:
                        System.out.println("Espresso (1 adet), Milk (1 adet)");
                        break;
                    case 4:
                        System.out.println("Espresso (1 adet), Milk (2 adet)");
                        break;
                    case 5:
                        System.out.println("Espresso (1 adet), Milk (1 adet), Cocoa (1 adet)");
                        break;
                    case 6:
                        System.out.println("Espresso (1 adet), Water (4 adet)");
                        break;
                    case 7:
                        System.out.println("Water (1 adet)");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz bir değer girdiniz. Lütfen sadece sayı giriniz.");
                scanner.nextLine(); // Clear the input buffer
            }

            System.out.println("Afiyet Olsun.");
            System.out.println();
        }

        System.out.println("Tekrar görüşmek üzere!");
    }

}