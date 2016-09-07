package Ejercicio6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio6Test {
    Reales reales;

    @Before
    public void setUp(){
        reales = new Reales();
    }

    @Test
    public void ordenar() throws Exception {
        reales.ordenar(7, 9, -3);

        assertTrue(reales.x == -3);
        assertTrue(reales.y == 7);
        assertTrue(reales.z == 9);
    }

}
