package Boundary;

import Control.InputValidation;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Isaac Hotop
 *
 * This class alows the user to securely sign in, sign out, or sign up to access or create their account
 */
public class SignIn extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {

        //Create signIn page
        GridPane signInPane = new GridPane();
        HBox hBox = new HBox();
        signInPane.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        signInPane.add(hBox, 0, 0);

        //Create sign in fields and buttons and add them to SignInPage
        TextField usrNameField = new TextField();
        TextField passwdField = new TextField();
        Button signInBtn = new Button("Sign In");
        Label status = new Label("Enter your username and password above");
        usrNameField.setPromptText("Username:");
        passwdField.setPromptText("Password:");
        hBox.getChildren().addAll(usrNameField, passwdField);
        signInPane.add(signInBtn, 0, 1);
        signInPane.add(status, 0, 2);
        signInPane.setHalignment(signInBtn, HPos.CENTER);
        signInPane.setHalignment(status, HPos.CENTER);

        //gets credentials from the textFields, validates them, then attempts a connection to the database when signinBtn is clicked
        signInBtn.setOnAction(e -> {
            InputValidation inputValidation = new InputValidation();
            FoodDatabaseManagement foodDatabaseManagement = new FoodDatabaseManagement();

            if (inputValidation.UsernamePasswordValidation(usrNameField.getText(), passwdField.getText())) {
                try {
                    foodDatabaseManagement.connectDatabase(usrNameField.getText(), passwdField.getText());
                }
                catch (ClassNotFoundException e1) {
                    throw new RuntimeException(e1);
                }
            }
            else {
                status.setText("Login Failed...");
            }
        });

        //Sets the scene as SignInPane
        Scene scene = new Scene(signInPane, 550, 300);
        stage.setTitle("Calorie Tracker");
        stage.setScene(scene);
        stage.show();
    }
}
