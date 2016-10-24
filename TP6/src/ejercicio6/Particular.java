package ejercicio6;

/**
 * @author Pablo Germone
 */
public class Particular extends Asistente{
    private String ciudadResidencia;

    public Particular(String nombre, String apellido, Congreso congreso, String ciudad){
        super(nombre, apellido, congreso);
        setCiudadResidencia(ciudad);
    }


    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }


    /**
     * Calcula el precio que debe descontarse del precio base
     * @return Precio a descontar
     */
    public double calcularDescuento(){
        if(getCiudadResidencia().compareTo("Buenos Aires") != 0){
            setDescuento(0.1);
        }

        return getCongreso().getPrecioBase() * getDescuento();
    }
}
