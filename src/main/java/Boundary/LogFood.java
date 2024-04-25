package Boundary;

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

    public LogFood() {
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
