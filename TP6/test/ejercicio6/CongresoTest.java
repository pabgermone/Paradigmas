package ejercicio6;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class CongresoTest {
    Congreso congreso;
    Alumno alumno;
    Presentador presentador;
    Particular particular;

    @Before
    public void setUp() throws Exception {
        congreso = new Congreso("congreso", 100.0);

        alumno = new Alumno("Pablo", "Germone", "asd", congreso, 3);
        presentador = new Presentador("Pablo", "Germone", "asd", congreso);
        particular = new Particular("Pablo", "Germone", "asd", congreso, "Buenos Aires");
    }

    @Test
    public void listarAsistentes() throws Exception {
        List<Asistente> asistentes = new ArrayList<Asistente>();
        List<Asistente> esperado = new ArrayList<Asistente>();

        esperado.add(alumno);
        esperado.add(presentador);
        esperado.add(particular);

        for(int i = 0; i < asistentes.size(); i++){
            assertEquals(asistentes.get(i), esperado.get(i));
        }
    }
}