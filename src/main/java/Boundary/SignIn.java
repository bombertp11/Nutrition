package Boundary;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
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

        //Create login page
        GridPane loginPane = new GridPane();
        HBox hBox = new HBox();
        loginPane.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        loginPane.add(hBox, 0, 0);

        //Create login fields and buttons and add them to loginPage
        TextField usrNameField = new TextField();
        TextField passwdField = new TextField();
        Button loginBtn = new Button("Login");
        Label status = new Label("Enter your username and password above");
        usrNameField.setPromptText("Username:");
        passwdField.setPromptText("Password:");
        hBox.getChildren().addAll(usrNameField, passwdField);
        loginPane.add(loginBtn, 0, 1);
        loginPane.add(status, 0, 2);
        loginPane.setHalignment(loginBtn, HPos.CENTER);
        loginPane.setHalignment(status, HPos.CENTER);
    }
}
