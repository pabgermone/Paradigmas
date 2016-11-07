package ejercicio7;

/**
 * @author Pablo Germone
 */
public class Caja {
    private Supermercado supermercado;
    private double recaudado;

    public Supermercado getSupermercado() {
        return supermercado;
    }

    private void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public double getRecaudado() {
        return recaudado;
    }


    public Caja(Supermercado supermercado){
        setSupermercado(supermercado);
        getSupermercado().addCaja(this);
    }


    public void facturar(Chango chango){
        for(ProductoDeVenta producto : chango.getProductos()){
            recaudado += producto.getPrecioVenta();
        }
    }

    private void aplicarDescuento(ProductoDeVenta producto){

    }
}
