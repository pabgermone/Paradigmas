package Ejercicio5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio5Test {
    @Test
    public void devolverValor() throws Exception {
        assertEquals(999, new Multiplo().devolverValor(3, 9));
    }

    @Test
    public void devolverValor2() throws Exception{
        assertNotEquals(999, new Multiplo().devolverValor(2, 9));
    }

}