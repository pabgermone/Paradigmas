package ejercicio5;

/**
 * @author Pablo Germone
 */
public class Persona{// implements Comparable<Persona>{
    private String nombre;
    private String apellido;
    private int dni;
    private String direccion;


    public Persona(String nombre, String apellido, int dni, String direccion){
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setDireccion(direccion);
    }


    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
