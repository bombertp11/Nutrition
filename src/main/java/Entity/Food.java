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
    private final int protein;
    private final int carbs;
    private final int fats;

    public Food(String name, int cals, int protein, int carbs, int fats) {
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

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFats() {
        return fats;
    }
}
