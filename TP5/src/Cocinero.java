import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Cocinero {
    private String nombre;
    private String apellido;
    private String mail;
    private List<Plato> platos = new ArrayList<Plato>();



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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Plato> getPlatos() {
        return platos;
    }



    public void agregarPlato(Plato plato){
        getPlatos().add(plato);
    }
}