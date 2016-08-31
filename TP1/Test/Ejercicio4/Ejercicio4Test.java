package Ejercicio4;

import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio4Test {
    @Test
    public void devolverValor() throws Exception {
        assertEquals(5, new Funcion().devolverValor(1, -1));
    }

    @Test
    public void devolverValor2() throws Exception{
        assertEquals(4, new Funcion().devolverValor(1, 2));
    }
}