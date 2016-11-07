package ejercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Chango {
    private List<ProductoDeVenta> productos = new ArrayList<ProductoDeVenta>();
    private Supermercado supermercado;

    public List<ProductoDeVenta> getProductos() {
        return productos;
    }

    public void addProducto(ProductoDeVenta producto){
        getProductos().add(producto);
    }
}
