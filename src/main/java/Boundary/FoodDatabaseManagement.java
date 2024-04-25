package Boundary;

import Entity.Food;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "Admin", "admin1");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * signInUser
     * Retrives the user's data from the database and creates a User object to store the data in.
     * @param username The user's username
     * @param password The user's password
     * @return true if successfully signed in and retrieved user data, returns false if not
     * @throws SQLException
     */
    public boolean signInUser(String username, String password) throws SQLException {
        try {
            //Connects to database using user's credentials then retrieves user info from the database
            Connection userConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", username, password);
            PreparedStatement signIn = userConnection.prepareStatement("SELECT * FROM " + username + "_table");
            ResultSet userInfo = signIn.executeQuery();

            //Creates a User class with the info retrieved from the database


            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
            }
    }

    /**
     * addUser
     * Creates a query using the given username and password to add a user and their associated table to the database
     * @param username The user's username
     * @param password The user's password
     * @return true if the user and table was successfully added return false if not
     */
    public boolean addUser(String username, String password) {
        try {
            //Creates a user
            PreparedStatement addUser = connection.prepareStatement("CREATE USER ?@'localhost' IDENTIFIED BY ?");
            addUser.setString(1,username);
            addUser.setString(2, password);
            addUser.executeUpdate();

            //Creates the user's table
            PreparedStatement addUserTable = connection.prepareStatement("CREATE TABLE "+username+"_table (id INT AUTO_INCREMENT PRIMARY KEY, food_date DATE, food VARCHAR(255))");
            addUserTable.executeUpdate();

            //Grant permissions to the new user
            PreparedStatement grantUserPerms = connection.prepareStatement("GRANT SELECT ON "+username+"_table TO ?@'localhost'");
            grantUserPerms.setString(1,username);
            grantUserPerms.executeUpdate();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    /**
     * Iterates through each line in FoodDatabase.csv until it finds the given food. Once found, it will take the food
     * name and its information and create a Food class from it
     *
     * @param foodName the name of the food that needs to be looked up in FoodDatabase.csv
     * @return Food Object that contains the food info from FoodDatabase.csv
     */
    public Food findFood (String foodName) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("FoodDatabase.csv"))) {
            while ((line = br.readLine()) != null) {
                // Split the line by commas
                String[] foodInfo = line.split(",");

                // return the Food Object
                return new Food(foodInfo[0].trim(), Integer.parseInt(foodInfo[1]), Double.parseDouble(foodInfo[2]),
                        Double.parseDouble(foodInfo[3]), Double.parseDouble(foodInfo[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Food("Error",0,0,0,0);
    }
}
