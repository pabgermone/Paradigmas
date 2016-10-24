package ejercicio6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class ParticularTest {
    Particular particular1;
    Particular particular2;
    Congreso congreso;

    @Before
    public void setUp() throws Exception {
        congreso = new Congreso("congreso", 100.0);
        particular1 = new Particular("nombre", "apellido", "institucion", congreso, "Buenos Aires");
        particular2 = new Particular("nombre", "apellido", "institucion", congreso, "asd");
    }

    @Test
    public void getMontoAPagar1() throws Exception {
        assertTrue(particular1.getMontoAPagar() == 100.0);
    }

    @Test
    public void getMontoAPagar2() throws Exception {
        assertTrue(particular2.getMontoAPagar() == 90.0);
    }

    @Test
    public void crearCredencial() throws Exception {
        String credencial = particular1.crearCredencial();
        String esperado = "congreso\nnombre apellido\ninstitucion";

        assertTrue(credencial.compareTo(esperado) == 0);
    }
}