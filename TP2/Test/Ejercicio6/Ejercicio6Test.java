package Ejercicio6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio6Test {
    PrimosGemelos gemelos;

    @Before
    public void setUp() throws Exception {
        gemelos = new PrimosGemelos();
    }

    @Test
    public void encontrarGemelos() throws Exception {
        int[] esperado = {5, 7};

        assertArrayEquals(esperado, gemelos.encontrarGemelos(4));
    }

    @Test
    public void encontrarGemelos2() throws Exception {
        int[] esperado = {11, 13};

        assertArrayEquals(esperado, gemelos.encontrarGemelos(10));
    }

    @Test
    public void encontrarGemelos3() throws Exception {
        int[] esperado = {17, 19};

        assertArrayEquals(esperado, gemelos.encontrarGemelos(14));
    }

    @Test
    public void esPrimo() throws Exception {
        assertTrue(gemelos.esPrimo(7));
    }

}