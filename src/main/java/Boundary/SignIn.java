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
import java.sql.PreparedStatement;

/**
 * @author Isaac Hotop
 *
 * This class alows the user to securely sign in, sign out, or sign up to access or create their account
 */
public class SignIn extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        InputValidation inputValidation = new InputValidation();
        FoodDatabaseManagement foodDatabaseManagement = new FoodDatabaseManagement();

        //Create signIn pane
        GridPane signInPane = new GridPane();
        HBox hBox = new HBox();
        signInPane.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        signInPane.add(hBox, 0, 0);

        //Create addUser pane
        GridPane addUserPane = new GridPane();
        HBox addUserHbox = new HBox();
        addUserPane.setAlignment(Pos.CENTER);
        addUserHbox.setAlignment(Pos.CENTER);
        addUserPane.add(addUserHbox, 1, 1);

        //Create sign in fields and buttons and add them to SignInPane
        TextField usrNameField = new TextField();
        TextField passwdField = new TextField();
        Button signInBtn = new Button("Sign In");
        Button addUserBtn = new Button("Create New User");
        Label status = new Label("Enter your username and password above");
        usrNameField.setPromptText("Username:");
        passwdField.setPromptText("Password:");
        hBox.getChildren().addAll(usrNameField, passwdField);
        signInPane.add(signInBtn, 0, 1);
        signInPane.add(addUserBtn, 0,2);
        signInPane.add(status, 0, 3);
        signInPane.setHalignment(signInBtn, HPos.CENTER);
        signInPane.setHalignment(addUserBtn, HPos.CENTER);
        signInPane.setHalignment(status, HPos.CENTER);

        //Create add user fields and buttons and add them to addUserPane
        TextField addUsrNamefield = new TextField();
        TextField addPasswdField = new TextField();
        TextField passwdConfirmation = new TextField();
        Button createUserBtn = new Button("Create User");
        Button backBtn = new Button("Back to Sign in Page");
        addUsrNamefield.setPromptText("Username:");
        addPasswdField.setPromptText("Password:");
        passwdConfirmation.setPromptText("Confirm Password:");
        addUserHbox.getChildren().addAll(addPasswdField, passwdConfirmation);
        addUserPane.add(addUsrNamefield,1,0);
        addUserPane.add(status,1,2);
        addUserPane.add(backBtn,0,3);
        addUserPane.add(createUserBtn,2,3);

        //Sets the scene as SignInPane
        Scene scene = new Scene(signInPane, 550, 300);
        stage.setTitle("Calorie Tracker");
        stage.setScene(scene);
        stage.show();

        //gets credentials from the textFields, validates them, then attempts a connection to the database when signInBtn is clicked
        signInBtn.setOnAction(e -> {


            if (inputValidation.UsernamePasswordValidation(usrNameField.getText(), passwdField.getText())) {

            }
            else {
                status.setText("Login Failed...");
            }
        });

        //sets the root of the scene to addUserPane when addUserBtn is clicked
        addUserBtn.setOnAction(e -> {
            scene.setRoot(addUserPane);
        });

        //resets the scene's root back to SignInPane when backBtn is clicked
        backBtn.setOnAction(e -> {
            scene.setRoot(signInPane);
        });

        //Gets credentials from the textFields, validates them, then creates a query to add the user and their
        //associated table to the database when the createUserBtn is clicked
        createUserBtn.setOnAction(e -> {
            if(addPasswdField.getText().equals(passwdConfirmation.getText())) {
                if (inputValidation.UsernamePasswordValidation(addUsrNamefield.getText(), addPasswdField.getText())) {
                        if(foodDatabaseManagement.addUser(addUsrNamefield.getText(), addPasswdField.getText())) {
                            status.setText(addUsrNamefield.getText()+" was added");
                        }
                        else {
                            status.setText("Could not add user...");
                        }
                }
                else {
                    status.setText("Don't use these characters: ', \", ;, `, -, _, (), [], *, =, /, \\, %, >, <, $, &, |");
                }
            }
            else {
                status.setText("Both password fields need to match!");
            }

        });

    }
}
