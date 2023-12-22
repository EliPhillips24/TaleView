module com.example.taleview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taleview to javafx.fxml;
    exports com.example.taleview;
}