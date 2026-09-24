module pe.edu.upeu.starbuckscrud {
    requires javafx.controls;
    requires javafx.fxml;

    // Permite a JavaFX acceder al controlador y a la aplicación principal
    opens pe.edu.upeu.starbuckscrud to javafx.fxml;
    opens pe.edu.upeu.starbuckscrud.controller to javafx.fxml;

    // Permite que la tabla lea los atributos de tu modelo Producto (PropertyValues)
    opens pe.edu.upeu.starbuckscrud.model to javafx.base;

    exports pe.edu.upeu.starbuckscrud;
}