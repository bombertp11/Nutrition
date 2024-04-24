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
    public GenerateGraph(double totalProtein, double totalCarbs, double totalFats) {
        pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Proteins", totalProtein),
                new PieChart.Data("Carbohydrates", totalCarbs),
                new PieChart.Data("Fats", totalFats)
        );
        pieChart = new PieChart(pieChartData);
    }

    public PieChart getGraph() {
        return pieChart;
    }
}
