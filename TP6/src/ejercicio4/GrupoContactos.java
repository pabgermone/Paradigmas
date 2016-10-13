package ejercicio4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class GrupoContactos {
    private String nombre;
    private List<Contacto> contactos = new ArrayList<Contacto>();


    public GrupoContactos(String nombre){
        setNombre(nombre);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }


    public void agregarContacto(Contacto contacto){
        getContactos().add(contacto);
    }

    public void eliminarContacto(Contacto contacto){
        getContactos().remove(contacto);
    }
}
