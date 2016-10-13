package ejercicio4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class ContactManagerTest {
    ContactManager contactManager;

    @Before
    public void setUp() throws Exception {
        contactManager = new ContactManager();
    }

    @Test
    public void crearContacto() throws Exception {
        contactManager.crearContacto("Pablo", "Germone", 123, "asdasd");

        assertEquals(contactManager.getContactos().size(), 1);
    }

    @Test
    public void crearGrupo() throws Exception {
        contactManager.crearGrupo("asd");

        assertEquals(contactManager.getGrupos().size(), 1);
    }

    @Test
    public void agregarAGrupo() throws Exception {
        GrupoContactos grupoContactos;

        contactManager.crearContacto("Pablo", "Germone", 123, "asd");
        contactManager.crearGrupo("asd");

        grupoContactos = contactManager.obtenerGrupo("asd");

        contactManager.agregarAGrupo("asd", "Pablo", "Germone");

        assertEquals(grupoContactos.getContactos().size(), 1);
    }

    @Test
    public void eliminarContacto() throws Exception {
        contactManager.crearContacto("Pablo", "Germone", 123, "asd");
        contactManager.crearContacto("asd", "asd", 123, "asd");
        contactManager.crearGrupo("asd");
        contactManager.crearGrupo("asdasd");

        Contacto contacto = contactManager.obtenerContacto("asd", "asd");

        GrupoContactos grupo1 = contactManager.obtenerGrupo("asd");
        GrupoContactos grupo2 = contactManager.obtenerGrupo("asdasd");

        contactManager.agregarAGrupo("asd", "Pablo", "Germone");
        contactManager.agregarAGrupo("asdasd", "Pablo", "Germone");
        contactManager.agregarAGrupo("asdasd", "asd", "asd");

        contactManager.eliminarContacto(contacto);

        assertEquals(contactManager.getContactos().size(), 1);
        assertEquals(grupo1.getContactos().size(), 1);
        assertEquals(grupo2.getContactos().size(), 1);
    }

    @Test
    public void eliminarGrupo() throws Exception {
        contactManager.crearGrupo("asd");
        GrupoContactos grupo = contactManager.obtenerGrupo("asd");

        assertEquals(contactManager.getGrupos().size(), 1);
    }

    @Test
    public void cambiarMail() throws Exception {
        contactManager.crearContacto("Pablo", "Germone", 123, "aaa");
        contactManager.cambiarMail("bbb", "Pablo", "Germone");

        assertEquals(contactManager.obtenerContacto("Pablo", "Germone").getMail().compareTo("bbb"), 0);
    }

}