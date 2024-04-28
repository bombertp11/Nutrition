package Boundary;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * This class generates a pie graph that users can view on their home page that displays the percentage of
 * each macro nutrient (protein, carbohydrates, and fats) out of the total amount of calories consumed
 *
 * @author Isaac Hotop
 */
public class GenerateGraph {
    PieChart pieChart;

    private ObservableList<PieChart.Data> pieChartData;

    /**
     * Creates a graph that displays the total grams of protein, carbohydrates, and fats
     * @param totalProteinG amount of protein in grams that the user has consumed
     * @param totalCarbsG amount of carbohydrates in grams that the user has consumed
     * @param totalFatsG amount of fats in grams that the user has consumed
     * @return pieChart
     */
    public PieChart generateGraphInGrams(double totalProteinG, double totalCarbsG, double totalFatsG) {
        pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Grams of Protein", totalProteinG),
                new PieChart.Data("Grams of Carbohydrates", totalCarbsG),
                new PieChart.Data("Grams of Fats", totalFatsG)
        );
        pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Daily Intake of Macronutrients in Grams");
        pieChart.setStyle("-fx-border-color: black; -fx-border-width: 2px;"); //set pie chart border
        
        return pieChart;
    }

    /**
     * Creates a graph that displays the total Calories of protein, carbohydrates, and fats
     * @param totalProteinC amount of protein in Calories that the user has consumed
     * @param totalCarbsC amount of carbohydrates in Calories that the user has consumed
     * @param totalFatsC amount of fats in Calories that the user has consumed
     * @return pieChart
     */
    public PieChart generateGraphInCalories(double totalProteinC, double totalCarbsC, double totalFatsC) {
        pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Calories in Proteins", totalProteinC),
                new PieChart.Data("Calories in Carbohydrates", totalCarbsC),
                new PieChart.Data("Calories in Fats", totalFatsC)
        );
        pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Daily Intake of Macronutrients in Calories");
        pieChartData.forEach(data ->{
            if(data.getName().equals("Calories in Proteins")){      //sets pie piece color by data
                data.getNode().setStyle("-fx-pie-color: #FFD700;");
            }
            else if(data.getName().equals("Calories in Carbohydrates")){      //sets pie piece color by data
                data.getNode().setStyle("-fx-pie-color: #ADD8E6;");
            }
            if(data.getName().equals("Calories in Fats")){      //sets pie piece color by data
                data.getNode().setStyle("-fx-pie-color: #FFA07A;");
            }

        });
        
        return pieChart;
    }

}
