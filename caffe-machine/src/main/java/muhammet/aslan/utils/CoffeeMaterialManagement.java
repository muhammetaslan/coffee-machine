package muhammet.aslan.utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CoffeeMaterialManagement {

    /*
    * Application that connects to an Mysql database,
    * creates a CoffeeMaterialStock table,
    * and inserts data into it using the singleton pattern for the database connection
    * */
    private static CoffeeMaterialManagement instance;
    private Connection connection;

    private CoffeeMaterialManagement() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CoffeeShopDB", "aslan", "aslan123");
        createCoffeeStockTable();
    }

    public static CoffeeMaterialManagement getInstance() throws SQLException {
        if (instance == null) {
            instance = new CoffeeMaterialManagement();
        }
        return instance;
    }

    // Drop and create new database, when application started
    private void createCoffeeStockTable() throws SQLException {
        String dropSql = "DROP TABLE IF EXISTS CoffeeMaterialStock";
        String createSql  = "CREATE TABLE IF NOT EXISTS CoffeeMaterialStock (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "material VARCHAR(255) NOT NULL," +
                "quantity INT NOT NULL" +
                ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(dropSql);
        }

        try (PreparedStatement pstmt = connection.prepareStatement(createSql )) {
            pstmt.executeUpdate();
        }
    }

    // insert initial data into CoffeeMaterialStock table, when application is starting
    public void insertDataIntoCoffeeMaterialStock() throws SQLException {
        String[] materials = {"hotwater", "espresso", "milkfoam", "steamedmilk", "hotchocolate"};
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

    // get the values of the each meterials in the database
    public Map<String, Integer> getDataFromCoffeeMaterialStock() throws SQLException {
        String sql = "SELECT material, quantity FROM CoffeeMaterialStock";
        Map<String, Integer> stockMap = new HashMap<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                stockMap.put(resultSet.getString("material"), resultSet.getInt("quantity"));
            }
        }
        return stockMap;
    }

    // update the stock of the meterial
    public void updateQuantityInCoffeeMaterialStock(String material, int newQuantity) throws SQLException {
        String sql = "UPDATE CoffeeMaterialStock SET quantity = ? WHERE material = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setString(2, material);
            pstmt.executeUpdate();
        }
    }

}
