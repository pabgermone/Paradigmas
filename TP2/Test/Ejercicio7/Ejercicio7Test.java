package Ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio7Test {
    JuegoRectangulos juego;

    @Before
    public void setUp() throws Exception {
        juego = new JuegoRectangulos();
    }

    @Test
    public void comparar() throws Exception {
        assertTrue(0 == juego.comparar(2, 1, 4, 2).compareTo("Encajan sin girar"));
    }

    @Test
    public void comparar2() throws Exception {
        assertTrue(0 == juego.comparar(2, 1, 2, 4).compareTo("Encajan girando"));
    }

    @Test
    public void comparar3() throws Exception {
        assertTrue(0 == juego.comparar(2, 1, 1, 2).compareTo("No encajan"));
    }
}