package ejercicio7;

/**
 * @author Pablo Germone
 */
public class Lacteo extends ProductoAlimenticio{
    public Lacteo(String nombre, double precio){
        super(nombre, precio);
        setDescuento(0.2);
    }
}
