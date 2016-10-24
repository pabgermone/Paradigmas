package ejercicio6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class AlumnoTest {
    Congreso congreso;
    Alumno alumno;

    @Before
    public void setUp() throws Exception {
        congreso = new Congreso("congreso", 100.0);
        alumno = new Alumno("nombre", "apellido", "institucion", congreso, 3);
    }

    @Test
    public void getMontoAPagar() throws Exception {
        assertTrue(alumno.getMontoAPagar() == 75.0);
    }

    @Test
    public void crearCredencial() throws Exception {
        String credencial = alumno.crearCredencial();
        String esperado = "congreso\nnombre apellido\ninstitucion";

        assertTrue(credencial.compareTo(esperado) == 0);
    }
}