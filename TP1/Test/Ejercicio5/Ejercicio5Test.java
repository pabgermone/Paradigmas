package Ejercicio5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio5Test {
    Multiplo multiplo;

    @Before
    public void setUp(){
        multiplo = new Multiplo();
    }

    @Test
    public void devolverValor() throws Exception {
        assertEquals(999, multiplo.devolverValor(3, 9));
    }

    @Test
    public void devolverValor2() throws Exception{
        assertNotEquals(999, multiplo.devolverValor(2, 9));
    }

}
