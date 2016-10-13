package ejercicio4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class ContactManager {
    private List<Contacto> contactos = new ArrayList<Contacto>();
    private List<GrupoContactos> grupos = new ArrayList<GrupoContactos>();



    public List<Contacto> getContactos() {
        return contactos;
    }

    public List<GrupoContactos> getGrupos() {
        return grupos;
    }



    public void agregarContacto(Contacto contacto){
        getContactos().add(contacto);
    }

    public void agregarGrupo(GrupoContactos grupoContactos){
        getGrupos().add(grupoContactos);
    }


    /**
     * Obtiene la instancia de un contacto que tenga el nombre y apellido que llega por parametro
     * @param nombre Nombre del contacto buscado
     * @param apellido Apellido del contacto buscado
     * @return Contacto buscado
     */
    private Contacto obtenerContacto(String nombre, String apellido){
        Contacto cont = null;

        for(Contacto contacto : getContactos()){
            if(contacto.getApellido().compareTo(apellido) == 0 && contacto.getNombre().compareTo(nombre) == 0){
                cont = contacto;
            }
        }

        return cont;
    }

    /**
     * Obtiene la instancia del grupo con el nombre ingresado por parametro
     * @param nombre Nombre del grupo buscado
     * @return Grupo buscado
     */
    private GrupoContactos obtenerGrupo(String nombre){
        GrupoContactos grupo = null;

        for(GrupoContactos grupoContactos : getGrupos()){
            if(grupoContactos.getNombre().compareTo(nombre) == 0){
                grupo = grupoContactos;
            }
        }

        return grupo;
    }



    /**
     * Elimina un contacto de la lista de contactos y de todos los frupos en los que este
     * @param contacto Contacto a eliminar
     */
    public void eliminarContacto(Contacto contacto){
        for(GrupoContactos grupo : grupos){
            for(Contacto cont : grupo.getContactos()){
                if(cont == contacto){
                    grupo.eliminarContacto(contacto);
                }
            }
        }

        getContactos().remove(contacto);
    }

    /**
     * Elimina un grupo de contactos de la lista de grupos
     * @param grupoContactos Grupo a eliminar
     */
    public void eliminarGrupo(GrupoContactos grupoContactos){
        getGrupos().remove(grupoContactos);
    }



    /**
     * Crea un contacto y lo agrega a la lista de contactos
     * @param nombre Nombre del nuevo contacto
     * @param apellido Apellido del nuevo contacto
     * @param telefono Telefono del nuevo contacto
     * @param mail direccion de e-mail del nuevo contacto
     */
    public void crearContacto(String nombre, String apellido, int telefono, String mail){
        Contacto contacto = new Contacto(nombre, apellido, telefono, mail);
        agregarContacto(contacto);
    }

    /**
     * Crea un grupo de contactos y lo agrega a la lista de grupos
     * @param nombre Nombre del nuevo grupo de contactos
     */
    public void crearGrupo(String nombre){
        GrupoContactos grupoContactos = new GrupoContactos(nombre);
        agregarGrupo(grupoContactos);
    }


    /**
     * Agrega un contacto a un grupo
     * @param nombreGrupo Nombre del grupo al que se quiere agregar el contacto
     * @param nombreContacto Nombre del contacto que se quiere agregar al grupo
     * @param apellidoContacto Apellido del contacto que se quiere agregar al grupo
     */
    public void agregarAGrupo(String nombreGrupo, String nombreContacto, String apellidoContacto){
        Contacto contacto = obtenerContacto(nombreContacto, apellidoContacto);
        GrupoContactos grupo = obtenerGrupo(nombreGrupo);

        grupo.agregarContacto(contacto);
    }


    /**
     * Modifica la direccion de mail de un contacto
     * @param mailNuevo Nueva direccion de mail a asignar
     * @param nombre Nombre del contacto al que se quiere cambiar el mail
     * @param apellido Apellido del contacto al que se quiere cambiar el mail
     */
    public void cambiarMail(String mailNuevo, String nombre, String apellido){
        Contacto contacto = obtenerContacto(nombre, apellido);

        contacto.setMail(mailNuevo);
    }
}
