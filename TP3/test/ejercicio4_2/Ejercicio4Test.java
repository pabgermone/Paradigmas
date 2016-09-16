package ejercicio4_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class Ejercicio4Test {
    Expresion expresion;

    @Before
    public void setUp() throws Exception {
        expresion = new Expresion();
    }

    @Test
    public void esBalanceada() throws Exception {
        assertTrue(expresion.esBalanceada("{[1+2+(3*4)]/4}"));
        assertTrue(!expresion.esBalanceada("{[1+2+)(3*4)]/4}"));
    }
}