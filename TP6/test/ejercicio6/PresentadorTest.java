package ejercicio6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class PresentadorTest {
    Congreso congreso;
    Presentador presentador;

    @Before
    public void setUp() throws Exception {
        congreso = new Congreso("congreso", 100.0);
        presentador = new Presentador("nombre", "apellido", "institucion", congreso);
    }

    @Test
    public void getMontoAPagar() throws Exception {
        assertTrue(presentador.getMontoAPagar() == 25.0);
    }

    @Test
    public void crearCredencial() throws Exception {
        String credencial = presentador.crearCredencial();
        String esperado = "congreso\nnombre apellido\ninstitucion";

        assertTrue(credencial.compareTo(esperado) == 0);
    }
}