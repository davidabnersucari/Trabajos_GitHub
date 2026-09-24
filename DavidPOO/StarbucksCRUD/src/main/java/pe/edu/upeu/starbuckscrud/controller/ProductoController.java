package pe.edu.upeu.starbuckscrud.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pe.edu.upeu.starbuckscrud.model.Producto;
import pe.edu.upeu.starbuckscrud.repository.ProductoRepository;

public class ProductoController {

    @FXML private TextField txtBuscar;
    @FXML private TextField txtNombre;
    @FXML private ComboBox<String> cbCategoria;
    @FXML private TextField txtPrecio;
    @FXML private ComboBox<String> cbTamano;

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, Integer> colId;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, String> colCategoria;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, String> colTamano;

    private ProductoRepository productoRepository = new ProductoRepository();
    private ObservableList<Producto> productosObservable = FXCollections.observableArrayList();

    // Variable para saber qué producto estamos seleccionando en la tabla
    private Producto productoSeleccionado = null;

    @FXML
    public void initialize() {
        cbCategoria.getItems().addAll("Café", "Bebida Fría", "Postre", "Sandwich");
        cbTamano.getItems().addAll("Pequeño", "Mediano", "Grande");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colTamano.setCellValueFactory(new PropertyValueFactory<>("tamano"));

        actualizarTabla();

        // Listener para detectar cuando haces clic en una fila de la tabla
        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                productoSeleccionado = newSelection;
                txtNombre.setText(newSelection.getNombre());
                cbCategoria.setValue(newSelection.getCategoria());
                txtPrecio.setText(String.valueOf(newSelection.getPrecio()));
                cbTamano.setValue(newSelection.getTamano());
            }
        });
    }

    @FXML
    public void guardarProducto() {
        try {
            String nombre = txtNombre.getText();
            String categoria = cbCategoria.getValue();
            double precio = Double.parseDouble(txtPrecio.getText());
            String tamano = cbTamano.getValue();

            Producto nuevoProducto = new Producto(0, nombre, categoria, precio, tamano);
            productoRepository.guardar(nuevoProducto);

            actualizarTabla();
            limpiarCampos();
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    public void actualizarProducto() {
        if (productoSeleccionado != null) {
            try {
                String nombre = txtNombre.getText();
                String categoria = cbCategoria.getValue();
                double precio = Double.parseDouble(txtPrecio.getText());
                String tamano = cbTamano.getValue();

                Producto productoModificado = new Producto(productoSeleccionado.getId(), nombre, categoria, precio, tamano);
                productoRepository.actualizar(productoSeleccionado.getId(), productoModificado);

                actualizarTabla();
                limpiarCampos();
            } catch (Exception e) {
                System.out.println("Error al actualizar: " + e.getMessage());
            }
        }
    }

    @FXML
    public void eliminarProducto() {
        if (productoSeleccionado != null) {
            productoRepository.eliminar(productoSeleccionado.getId());
            actualizarTabla();
            limpiarCampos();
        }
    }

    @FXML
    public void limpiarCampos() {
        txtNombre.clear();
        txtPrecio.clear();
        cbCategoria.setValue(null);
        cbTamano.setValue(null);
        txtBuscar.clear();
        productoSeleccionado = null;
        tablaProductos.getSelectionModel().clearSelection();
    }

    private void actualizarTabla() {
        productosObservable.setAll(productoRepository.listarTodos());
        tablaProductos.setItems(productosObservable);
    }
}