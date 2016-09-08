package ejercicio1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio1Test {
    Expresion expresion;

    @Before
    public void setUp() throws Exception {
        expresion = new Expresion();
    }

    @Test
    public void calcular() throws Exception {
        assertEquals(4, expresion.calcular("2 * 2"));
        assertEquals(10, expresion.calcular("4 + 6"));
        assertEquals(7, expresion.calcular("10 - 3"));
        assertEquals(5, expresion.calcular("10 / 2"));
    }

}