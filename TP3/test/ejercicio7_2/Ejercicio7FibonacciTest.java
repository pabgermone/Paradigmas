package ejercicio7_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class Ejercicio7FibonacciTest {
    Fibonacci fibonacci;

    @Before
    public void setUp() throws Exception {
        fibonacci = new Fibonacci();
    }

    @Test
    public void getNumero() throws Exception {
        assertEquals(21, fibonacci.getNumero(8));
        assertEquals(55, fibonacci.getNumero(10));
    }

}