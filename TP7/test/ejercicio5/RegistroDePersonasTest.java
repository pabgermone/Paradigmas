package ejercicio5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class RegistroDePersonasTest {
    RegistroDePersonas registro;
    Persona persona1;
    Persona persona2;

    @Before
    public void setUp() throws Exception {
        registro = new RegistroDePersonas();
        persona1 = new Persona("Luciano", "Perez", 29111999, "34 nro 567");
        persona2 = new Persona("Maricel", "Gonzales", 30333666, "34 nro 567");

        registro.agregarPersona(persona1);
        registro.agregarPersona(persona2);
    }

    @Test
    public void retornarPersona() throws Exception {
        Persona persona = registro.recuperarPersona(30333666);

        System.out.println(persona.getNombre() + " " + persona.getApellido() + " " + persona.getDni());

        assertEquals(persona.getDni(), 30333666);
    }

    @Test
    public void cantidadPersonas() throws Exception {
        assertEquals(registro.cantidadPersonas(), 2);
    }
}