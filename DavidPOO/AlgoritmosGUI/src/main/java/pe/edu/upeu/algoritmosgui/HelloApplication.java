package pe.edu.upeu.algoritmosgui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        var contenido = "Bienvenido a JavaFX";

        Label mensaje = new Label();
        mensaje.setStyle("-fx-font-size: 18px; -fx-text-fill: blue;");

        TextField nombre = new TextField();
        nombre.setPromptText("Escribe tu nombre");

        Button boton = new Button("Saludar");
        Button boton1 = new Button("Volver");

        boton.setOnAction(evento -> {
            String nombreIngresado = nombre.getText();
            mensaje.setText("¡Hola " + nombreIngresado + "!");
        });
        boton1.setOnAction(e -> {
            mensaje.setText(contenido);
        });

        VBox raiz = new VBox(15, mensaje, nombre, boton, boton1);
        raiz.setAlignment(Pos.CENTER);
        raiz.setStyle("-fx-padding: 30;");

        Scene escena = new Scene(raiz, 400, 250);

        stage.setTitle("Hola JavaFX");
        stage.setScene(escena);
        stage.show();
    }
}