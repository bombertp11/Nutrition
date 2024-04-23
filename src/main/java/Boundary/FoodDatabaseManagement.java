package Boundary;

import java.sql.*;

/**
 * This class allows the admin to make changes to the food database and contains a method that connects the program to
 * the database
 *
 * @author Isaac Hotop
 */
public class FoodDatabaseManagement {
    Connection connection;
    public FoodDatabaseManagement() throws ClassNotFoundException {
         /*
        Load JDBC driver
        You can download this driver from this link: https://dev.mysql.com/downloads/connector/j/
        Then add the jar file to the project's dependencies
        the java.sql.* import will not work until you do this
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            //host:port/Database name  root username, root password
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Changeme1!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * signInUser
     * Retrives the user's data from the database and creates a User object to store the data in.
     * @param username
     * @param password
     * @return
     * @throws ClassNotFoundException
     */
    public boolean signInUser(String username, String password) throws ClassNotFoundException {

        return false;
    }

    /**
     * addUser
     * Creates a query using the given username and password to add a user and their associated table to the database
     *
     * @param username The user's username
     * @param password The user's password
     * @return true if the user and table was successfully added return false if not
     */
    public boolean addUser(String username, String password) {
        try {
            PreparedStatement addUser = connection.prepareStatement("CREATE USER ?@'localhost' IDENTIFIED BY ?");
            addUser.setString(1,username);
            addUser.setString(2, password);
            addUser.executeUpdate();

            PreparedStatement addUserTable = connection.prepareStatement("CREATE TABLE "+username+"_table (id INT AUTO_INCREMENT PRIMARY KEY, food_date DATE, food VARCHAR(255))");
            addUserTable.executeUpdate();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
}
