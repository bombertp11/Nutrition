module com.example.nutrition {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens Boundary to javafx.fxml;
    exports Boundary;
}