module com.example.nutrition {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;
    requires com.google.gson;


    opens Boundary to javafx.fxml;
    exports Boundary;
}