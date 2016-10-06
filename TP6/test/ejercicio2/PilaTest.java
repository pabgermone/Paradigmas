package ejercicio2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class PilaTest {
    Pila pila;

    @Before
    public void setUp() throws Exception {
        pila = new Pila(5);
    }

    @Test
    public void getCantidadMaxima() throws Exception {
        assertEquals(pila.getCantidadMaxima(), 5);
    }

    @Test
    public void push() throws Exception {
        pila.push('a');

        assertEquals(pila.getLength(), 1);
    }

    @Test
    public void pop() throws Exception {
        pila.push('a');

        assertEquals(pila.pop().compareTo('a'), 0);
        assertEquals(pila.getLength(), 0);
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(pila.isEmpty());
    }

}