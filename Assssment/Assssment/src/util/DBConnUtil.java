//package util;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnUtil {
//    // Database credentials
//    private static final String URL = "jdbc:mysql://localhost:3306/CareerHub"; // Use your database URL
//    private static final String USER = "root";  // Use your database username
//    private static final String PASSWORD = "aditi";  // Use your database password
//
//    public static Connection getConnection() throws SQLException {
//        Connection connection = null;
//        try {
//            // Register JDBC driver (Optional in newer versions)
//            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensures the MySQL driver is loaded
//
//            // Open a connection
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Database connection established successfully.");
//        } catch (ClassNotFoundException e) {
//            System.out.println("MySQL JDBC Driver not found.");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Error while connecting to the database: " + e.getMessage());
//            throw e; // Propagate the exception for further handling
//        }
//        return connection; // Return the connection object
//    }
//}

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/CareerHub";
    private static final String USER = "root";
    private static final String PASSWORD = "J@y24480";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
