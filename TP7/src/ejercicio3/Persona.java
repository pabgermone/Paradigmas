package ejercicio3;

/**
 * @author Pablo Germone
 */
public class Persona {
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public Persona(int dni, String nombre, String apellido){
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
    }


    @Override
    public String toString(){
        return this.getDni() + " " + this.getNombre() + " " + this.getApellido();
    }
}
