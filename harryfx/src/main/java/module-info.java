module com.example.harryfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.harryfx to javafx.fxml;
    exports com.example.harryfx;
}