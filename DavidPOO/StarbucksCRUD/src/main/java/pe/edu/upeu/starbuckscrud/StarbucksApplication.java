package pe.edu.upeu.starbuckscrud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StarbucksApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carga la vista FXML desde la carpeta resources/view/
        FXMLLoader fxmlLoader = new FXMLLoader(StarbucksApplication.class.getResource("/view/main_producto.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 550);
        stage.setTitle("Starbucks CRUD - Gestión de Productos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}