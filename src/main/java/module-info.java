module com.example.nutrition {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.nutrition to javafx.fxml;
    exports com.example.nutrition;
}