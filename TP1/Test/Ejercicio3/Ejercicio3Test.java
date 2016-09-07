package Ejercicio3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio3Test {
    Factorial fact;

    @Before
    public void setUp(){
        fact = new Factorial();
    }

    @Test
    public void calcular() throws Exception {
        assertEquals(120, fact.calcular(5));
    }

}
