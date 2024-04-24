package Entity;

/**
 * This class stores data of a food that is given by the FoodDatabaseManagement class. the food class contains
 * attributes such as name, calories, protein, carbohydrates, and fats
 *
 * @author Isaac Hotop
 */
public class Food {
    private final String name;
    private final int cals;
    private final double protein;
    private final double carbs;
    private final double fats;

    public Food(String name, int cals, double protein, double carbs, double fats) {
        this.name = name;
        this.cals = cals;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

    public String getName() {
        return name;
    }

    public int getCals() {
        return cals;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFats() {
        return fats;
    }
}
