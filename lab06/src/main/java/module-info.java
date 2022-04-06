module com.example.lab06 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.lab06 to javafx.fxml;
    exports com.example.lab06;
}