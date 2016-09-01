package Ejercicio3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio3Test {

    @Test
    public void calcular() throws Exception {
        assertEquals(120, new Factorial().calcular(5));
    }

}
