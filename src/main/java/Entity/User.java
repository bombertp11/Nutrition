package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores user data retrieved from the database after the user signs in.
 * It includes attributes such as name, goal, and dailyTotal, and tracks the user's food intake
 * over different time periods using ArrayLists.
 * 
 * @author Isaac Hotop
 */
public class User {
    private final int userID;
    private final String username;
    private List<Food> dailyIntake;
    private List<Food> weeklyIntake;


    public User(int userID, String username) {
        this.userID = userID;
        this.username = username;
        this.dailyIntake = new ArrayList<>();
        this.weeklyIntake = new ArrayList<>();
    }


    /**
     * Adds current food entered by the user (not retrieved from the user's table) to dailyIntake and weeklyIntake
     * @param food
     */
    public void addCurrentFood(Food food) {
        dailyIntake.add(food);
        weeklyIntake.add(food);
    }

    /**
     * Adds food fromm the user's table that fits into the current week to weeklyIntake
     * @param food
     */
    public void addWeeklyIntake(Food food) {
        weeklyIntake.add(food);
    }

    /**
     * Adds food from the user's table from today to dailyIntake
     * @param food
     */
    public void addDailyIntake(Food food) {
        dailyIntake.add(food);
    }

    /*public List<String> getDailyIntake(String date) {
        return getFoodsByPeriod(dailyIntake, date);
    }

    public List<String> getWeeklyIntake(String week) {
        return getFoodsByPeriod(weeklyIntake, week);
    }*/

    public String getUsername() {
        return username;
    }

    public int getUserID() {
        return userID;
    }
}


