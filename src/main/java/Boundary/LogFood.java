package Boundary;

import Control.InputValidation;
import Entity.Food;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * @author Isaac Hotop
 *
 * This class alows the user to input their food intake
 */
public class LogFood {
    private BorderPane logFoodPane;
    private Button backBtn;

    public LogFood() throws ClassNotFoundException {
        FoodDatabaseManagement foodDatabaseManagement = new FoodDatabaseManagement();
        InputValidation inputValidation = new InputValidation();

        //Create logFoodPane
        logFoodPane = new BorderPane();
        HBox centerPane = new HBox();
        logFoodPane.setCenter(centerPane);

        //Create and add nodes to logFoodPane
        backBtn = new Button("Back to Menu");
        Button enterBtn = new Button("Enter");
        TextField foodField = new TextField();
        Label status = new Label("Enter your food in the field above");
        logFoodPane.setLeft(backBtn);
        centerPane.getChildren().addAll(foodField, enterBtn);
        logFoodPane.setBottom(status);

        //searches for the user's food in the food database then adds that food to the user's database
        enterBtn.setOnAction(e -> {
            if (inputValidation.foodInputValidation(foodField.getText())) {
                Food userFood = foodDatabaseManagement.findFood(foodField.getText());

                //Checks if the food was found, if so then add food to User
                if (!userFood.getName().equals("Error")) {

                }
                else {
                    status.setText("Food was not found in the database");
                }
            }
            else {
                status.setText("Food input was not valid");
            }


        });
    }

    /**
     * @return logFoodPane
     */
    public BorderPane getLogFoodPane() {
        return logFoodPane;
    }

    /**
     * @return logFoodPane
     */
    public Button getBackBtn() {
        return backBtn;
    }
}
