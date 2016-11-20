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
        boolean aplicado = false;

        for(int i = 0; i < chango.getProductos().size(); i++){
            ProductoDeVenta producto = chango.getProductos().get(i);

            if(i > 0){
                if(chango.getProductos().get(i - 1).getNombre().compareTo(producto.getNombre()) == 0){
                    if(!aplicado){
                        producto.aplicarDescuento();
                        aplicado = true;
                    }
                }else{
                    aplicado = false;
                }
            }

            recaudado += producto.getPrecioVenta();
        }
    }
}
