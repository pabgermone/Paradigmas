package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class JuegoDeLaSillaTest {
    JuegoDeLaSilla juego;

    @Before
    public void setUp() throws Exception {
        juego = new JuegoDeLaSilla();

        juego.getJugadores().add("Pablo");
        juego.getJugadores().add("Melisa");
        juego.getJugadores().add("Marcelo");
        juego.getJugadores().add("Alejandra");

        juego.setCantidadSillas(3);
    }

    @Test
    public void jugar() throws Exception {
        juego.jugar();

        assertEquals(juego.getJugadores().size(), 1);
        assertEquals(juego.getCantidadSillas(), 0);
    }

}