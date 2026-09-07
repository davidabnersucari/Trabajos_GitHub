module pe.edu.upeu.sysventas {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.validation; // Habilita Lombok en el módulo

    opens pe.edu.upeu.sysventas.model to javafx.base;
    exports pe.edu.upeu.sysventas.model;

    opens pe.edu.upeu.sysventas to javafx.fxml;
    exports pe.edu.upeu.sysventas;
}