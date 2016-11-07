package ejercicio7;

/**
 * @author Pablo Germone
 */
public class Perfume implements ProductoDeVenta{
    private String nombre;
    private double precio;

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioVenta(){
        return this.precio;
    }


    public Perfume(String nombre, double precio){
        setNombre(nombre);
        setPrecio(precio);
    }
}
