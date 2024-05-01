package muhammet.aslan.utils;

import muhammet.aslan.enums.DrinkType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomerMenu {
    public static int productCounter = 0;
    public static void displayMenu(){
        Properties props = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("C:\\Users\\ABALA\\Desktop\\coffee-machine\\caffe-machine\\src\\main\\resources\\coffee.properties");
            props.load(input);

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

}
