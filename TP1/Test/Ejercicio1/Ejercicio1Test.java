package Ejercicio1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio1Test {
    Recta recta;


    @Before
    public void setUp(){
        recta = new Recta();
    }

    @Test
    public void probarPunto() throws Exception {
        assertTrue(recta.probarPunto(1, 10));
    }

    @Test
    public void probarPunto2() throws Exception{
        assertFalse(recta.probarPunto(2,10));
    }

}
