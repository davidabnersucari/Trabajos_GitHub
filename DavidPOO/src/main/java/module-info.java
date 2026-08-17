module com.example.davidpoo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.davidpoo to javafx.fxml;
    exports com.example.davidpoo;
}