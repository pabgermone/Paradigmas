package Ejercicio1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio1Test {

    @Test
    public void probarPunto() throws Exception {
        assertTrue(new Recta().probarPunto(1, 10));
    }

    @Test
    public void probarPunto2() throws Exception{
        assertFalse(new Recta().probarPunto(2,10));
    }

}