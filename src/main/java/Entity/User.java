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
    private List<FoodEntry> dailyIntake;
    private List<FoodEntry> weeklyIntake;
    private List<FoodEntry> monthlyIntake;

    public User(String userID) {
        this.userID = userID;
        this.dailyIntake = new ArrayList<>();
        this.weeklyIntake = new ArrayList<>();
        this.monthlyIntake = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public void addFoodEntry(List<FoodEntry> list, String period, List<String> foods) {
        list.add(new FoodEntry(period, foods));
    }

    public List<String> getFoodsByPeriod(List<FoodEntry> list, String period) {
        for (FoodEntry entry : list) {
            if (entry.getPeriod().equals(period)) {
                return entry.getFoods();
            }
        }
        return null; // or throw an exception if the period is not found
    }

    public void addDailyIntake(String date, List<String> foods) {
        addFoodEntry(dailyIntake, date, foods);
    }

    public void addWeeklyIntake(String week, List<String> foods) {
        addFoodEntry(weeklyIntake, week, foods);
    }

    public void addMonthlyIntake(String month, List<String> foods) {
        addFoodEntry(monthlyIntake, month, foods);
    }

    public List<String> getDailyIntake(String date) {
        return getFoodsByPeriod(dailyIntake, date);
    }

    public List<String> getWeeklyIntake(String week) {
        return getFoodsByPeriod(weeklyIntake, week);
    }

    public List<String> getMonthlyIntake(String month) {
        return getFoodsByPeriod(monthlyIntake, month);
    }
}


