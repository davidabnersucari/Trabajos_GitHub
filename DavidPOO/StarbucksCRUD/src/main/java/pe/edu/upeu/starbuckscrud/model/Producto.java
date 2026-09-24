package pe.edu.upeu.starbuckscrud.model;

public class Producto {

    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private String tamano;

    public Producto() {
    }

    public Producto(int id, String nombre, String categoria, double precio, String tamano) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.tamano = tamano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return nombre + " - " + categoria + " - S/ " + precio;
    }
}