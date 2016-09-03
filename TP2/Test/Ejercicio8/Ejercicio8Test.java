package Ejercicio8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio8Test {
    Caracol caracol;

    @Before
    public void setUp() throws Exception {
        caracol = new Caracol();
    }

    @Test
    public void diasEnSalir() throws Exception {
        assertEquals(3, caracol.diasEnSalir(10, 5, 2));
    }
}