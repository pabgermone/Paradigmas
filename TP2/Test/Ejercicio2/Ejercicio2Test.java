package Ejercicio2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio2Test {
    Par par;

    @Before
    public void setUp() throws Exception {
        par = new Par();
    }

    @Test
    public void mayorCantidadPares() throws Exception {
        int[] numeros = {10, 14, 15, 22, 34};
        int esperado = 22;

        assertEquals(esperado, par.mayorCantidadPares(numeros));
    }

}