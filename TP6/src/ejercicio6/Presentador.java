package ejercicio6;

/**
 * @author Pablo Germone
 */
public class Presentador extends Asistente{
    public Presentador(String nombre, String apellido, Congreso congreso){
        super(nombre, apellido, congreso);
    }

    /**
     * Calcula el precio que debe descontarse del precio base del congreso
     * @return Percio a descontar
     */
    public double calcularDescuento(){
        setDescuento(0.75);
        return getCongreso().getPrecioBase() * getDescuento();
    }
}
