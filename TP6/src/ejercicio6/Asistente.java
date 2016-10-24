package ejercicio6;

/**
 * @author Pablo Germone
 */
public abstract class Asistente{
    private String nombre;
    private String apellido;
    private String institucion;
    private double descuento = 0;
    private Congreso congreso;

    public Asistente(String nombre, String apellido, String institucion, Congreso congreso){
        setNombre(nombre);
        setApellido(apellido);
        setInstitucion(institucion);
        setCongreso(congreso);

        this.congreso.agregarAsistente(this);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Congreso getCongreso() {
        return congreso;
    }

    public void setCongreso(Congreso congreso) {
        this.congreso = congreso;
    }


    /**
     * Template para el calculo del precio a pagar por un asistente
     * @return Precio que debe pagar el asistente
     */
    public double getMontoAPagar(){
        return getCongreso().getPrecioBase() - calcularDescuento();
    }


    /**
     * Calcula el descuento que se debe aplicar al precio base del congreso
     * @return Descuento a aplicar
     */
    public abstract double calcularDescuento();


    public String crearCredencial(){
        return getCongreso().getNombre() + "\n" + getNombre() + " " + getApellido() + "\n" + getInstitucion();
    }
}
