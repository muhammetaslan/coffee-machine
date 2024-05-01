package muhammet.aslan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoffeeMaterialStock {

    /*
    * Application that connects to an H2 database,
    * creates a CoffeeMaterialStock table,
    * and inserts data into it using the singleton pattern for the database connection
    * */
    private static CoffeeMaterialStock instance;
    private Connection connection;

    private CoffeeMaterialStock() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CoffeeShopDB", "aslan", "aslan123");
        createCoffeeStockTable();
    }

    public static CoffeeMaterialStock getInstance() throws SQLException {
        if (instance == null) {
            instance = new CoffeeMaterialStock();
        }
        return instance;
    }

    private void createCoffeeStockTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS CoffeeMaterialStock (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "material VARCHAR(255) NOT NULL," +
                "quantity INT NOT NULL" +
                ")";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public void insertDataIntoCoffeeMaterialStock() throws SQLException {
        String[] materials = {"hot water", "espresso", "milk foam", "steamed milk", "hot chocolate"};
        int[] quantities = {10, 10, 10, 10, 10};

        for (int i = 0; i < materials.length; i++) {
            String sql = "INSERT INTO CoffeeMaterialStock (material, quantity) VALUES (?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, materials[i]);
                pstmt.setInt(2, quantities[i]);
                pstmt.executeUpdate();
            }
        }
    }

}
