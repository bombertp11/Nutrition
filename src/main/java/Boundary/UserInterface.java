package Boundary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class controls the user interface by changing the pane to the corresponding view that the user has chosen
 * and also provides the pane for the main user interface
 *
 * @author Isaac Hotop
 */
public class UserInterface extends Application {
    Scene scene;
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        SignIn signIn = new SignIn();

        //Initially set pane to signInPane
        scene = new Scene(signIn.getSignInPane(), 550, 300);
        stage.setTitle("Calorie Calculator");
        stage.setScene(scene);
        stage.show();

        //sets the root of the scene to addUserPane when addUserBtn is clicked
        signIn.getAddUserBtn().setOnAction(e -> {
            scene.setRoot(signIn.getAddUserPane());
        });

        //resets the scene's root back to SignInPane when backBtn in addUserPane is clicked
        signIn.getBackBtn().setOnAction(e -> {
            scene.setRoot(signIn.getSignInPane());
        });
    }

    public UserInterface() {
        //Create and add modules to menuPane
        BorderPane menuPane = new BorderPane();
        HBox bottomPane = new HBox();
        Button signOutBtn = new Button("Sign Out");
        Button logFoodBtn = new Button("Log Food");
        Button reportBtn = new Button("Generate Report");
        Label welcomeLabel = new Label("Hello")

    }

    public void switchToMenu() {
        scene.setRoot()
    }
    public static void main(String[] args) {
        launch();
    }
}