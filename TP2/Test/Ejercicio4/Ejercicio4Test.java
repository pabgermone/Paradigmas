package Ejercicio4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio4Test {
    Potencia potencia;

    @Before
    public void setUp() throws Exception {
        potencia = new Potencia();
    }

    @Test
    public void encontrarNumero() throws Exception {
        assertEquals(2592, potencia.encontrarNumero());
    }

}