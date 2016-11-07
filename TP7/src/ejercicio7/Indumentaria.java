package ejercicio7;

/**
 * @author Pablo Germone
 */
public class Indumentaria implements ProductoDeVenta {
    private String nombre;
    private String marca;
    private int talle;
    private double precio;

    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTalle() {
        return talle;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }

    private void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioVenta(){
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Indumentaria(String nombre, String marca, int talle, double precio){
        setNombre(nombre);
        setMarca(marca);
        setTalle(talle);
        setPrecio(precio);
    }
}
