package Boundary;

import java.sql.*;

/**
 * This class allows the admin to make changes to the food database and contains a method that connects the program to
 * the database
 *
 * @author Isaac Hotop
 */
public class FoodDatabaseManagement {
    public FoodDatabaseManagement() {

    }


    /**
     * connectDatabase
     * Loads the JDBC driver then uses the user's username and password to connect to the database
     *
     * @param username The user's username
     * @param password The user's password
     */
    public void connectDatabase(String username, String password) throws ClassNotFoundException {
        /*
        Load JDBC driver
        You can download this driver from thi link: https://dev.mysql.com/downloads/connector/j/
        Then add the jar file to the project's dependencies
        the java.sql.* import will not work until you do this
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
                                                                                     //host:port/Database name
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodDatabase", username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
