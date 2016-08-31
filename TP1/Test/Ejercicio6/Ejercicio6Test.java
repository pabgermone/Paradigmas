package Ejercicio6;

import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio6Test {
    @Test
    public void ordenar() throws Exception {
        Reales reales = new Reales();
        reales.ordenar(7, 9, -3);

        assertTrue(reales.x == -3);
        assertTrue(reales.y == 7);
        assertTrue(reales.z == 9);
    }

}