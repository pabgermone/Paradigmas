package Ejercicio4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio4Test {
    Funcion funcion;

    @Before
    public void setUp(){
        funcion = new Funcion();
    }

    @Test
    public void devolverValor() throws Exception {
        assertEquals(5, funcion.devolverValor(1, -1));
    }

    @Test
    public void devolverValor2() throws Exception{
        assertEquals(4, funcion.devolverValor(1, 2));
    }
}
