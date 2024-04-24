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
    private final String userID;
    private final String username;
    private List<Food> dailyIntake;
    private List<Food> weeklyIntake;


    public User(String userID, String username) {
        this.userID = userID;
        this.username = username;
        this.dailyIntake = new ArrayList<>();
        this.weeklyIntake = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    /**
     * Adds food to dailyIntake and weeklyIntake
     * @param food
     */
    public void addFood(Food food) {
        dailyIntake.add(food);
        weeklyIntake.add(food);
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
}


