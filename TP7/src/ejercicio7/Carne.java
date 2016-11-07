package ejercicio7;

/**
 * @author Pablo Germone
 */
public class Carne extends ProductoAlimenticio {
    public Carne(String nombre, double precio){
        super(nombre, precio);
        setDescuento(0.1);
    }
}
