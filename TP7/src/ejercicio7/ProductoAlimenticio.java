package ejercicio7;

/**
 * @author Pablo Germone
 */
public abstract class ProductoAlimenticio implements ProductoDeVenta{
    private String nombre;
    private double precio;
    private double descuento;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProductoAlimenticio(String nombre, double precio){
        setNombre(nombre);
        setPrecio(precio);
    }

    public double getPrecioVenta(){
        return getPrecio() - (getPrecio() * getDescuento());
    }
}