package Entity;

/**
 * @author Isaac Hotop
 *
 * This class stores user data that it retirves from the database after the user signs in. This class contains
 * attribues such as name, goal, and dailyTotal
 */
public class User {
    private final String userID;
    private Map<String, List<String>> dailyIntake;
    private Map<String, List<String>> weeklyIntake;
    private Map<String, List<String>> monthlyIntake;

    /**
     * Constructor for User object.
     * @param userID The unique identifier for the user.
     */
    public User(String userID) {
        this.userID = userID;
        this.dailyIntake = new HashMap<>();
        this.weeklyIntake = new HashMap<>();
        this.monthlyIntake = new HashMap<>();
    }

    public String getUserID() {
        return userID;
  }

   /**
     * Records food intake for a specific day.
     * @param date The date in format YYYY-MM-DD.
     * @param foods A list of food items consumed on that day.
     */
    public void addDailyIntake(String date, List<String> foods) {
        dailyIntake.put(date, foods);
    }

    /**
     * Records food intake for a specific week.
     * @param week A string representing the week, typically formatted as YYYY-WW.
     * @param foods A list of food items consumed during that week.
     */
    public void addWeeklyIntake(String week, List<String> foods) {
        weeklyIntake.put(week, foods);
    }

    /**
     * Records food intake for a specific month.
     * @param month A string representing the month, typically formatted as YYYY-MM.
     * @param foods A list of food items consumed during that month.
     */
    public void addMonthlyIntake(String month, List<String> foods) {
        monthlyIntake.put(month, foods);
    }

    /**
     * Retrieves food intake for a specific day.
     * @param date The date for which food intake is to be retrieved.
     * @return A list of food items consumed on that day.
     */
    public List<String> getDailyIntake(String date) {
        return dailyIntake.getOrDefault(date, null);
    }

    /**
     * Retrieves food intake for a specific week.
     * @param week The week for which food intake is to be retrieved.
     * @return A list of food items consumed during that week.
     */
    public List<String> getWeeklyIntake(String week) {
        return weeklyIntake.getOrDefault(week, null);
    }

    /**
     * Retrieves food intake for a specific month.
     * @param month The month for which food intake is to be retrieved.
     * @return A list of food items consumed during that month.
     */
    public List<String> getMonthlyIntake(String month) {
        return monthlyIntake.getOrDefault(month, null);
    }
}

