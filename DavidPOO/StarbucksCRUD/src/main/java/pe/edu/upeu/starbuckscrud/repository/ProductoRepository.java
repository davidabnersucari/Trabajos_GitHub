package pe.edu.upeu.starbuckscrud.repository;

import pe.edu.upeu.starbuckscrud.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {
    private List<Producto> listaProductos = new ArrayList<>();
    private int idContador = 1;

    public Producto guardar(Producto producto) {
        producto.setId(idContador++);
        listaProductos.add(producto);
        return producto;
    }

    public List<Producto> listarTodos() {
        return listaProductos;
    }

    public Producto actualizar(int id, Producto productoActualizado) {
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto p = listaProductos.get(i);
            if (p.getId() == id) {
                productoActualizado.setId(id);
                listaProductos.set(i, productoActualizado);
                return productoActualizado;
            }
        }
        return null;
    }

    public boolean eliminar(int id) {
        return listaProductos.removeIf(p -> p.getId() == id);
    }
}