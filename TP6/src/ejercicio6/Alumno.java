package ejercicio6;

/**
 * @author Pablo Germone
 */
public class Alumno extends Asistente{
    private int anho;


    public Alumno(String nombre, String apellido, String institucion, Congreso congreso, int anho){
        super(nombre, apellido, institucion, congreso);

        setAnho(anho);
    }


    public int getAnho() {
        return anho;
    }

    private void setAnho(int anho) {
        this.anho = anho;
    }


    /**
     * Calcula el descuento para alumnos entre 1er y 3er año
     * @return Precio que se debe descontar al precio base
     */
    public double calcularDescuento(){
        if(getAnho() >= 1 && getAnho() <= 3){
            setDescuento(0.25);
        }

        return getCongreso().getPrecioBase() * getDescuento();
    }
}
