package ejercicio7_1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class Ejercicio7FactorialTest {
    Factorial factorial;

    @Before
    public void setUp() throws Exception {
        factorial = new Factorial();
    }

    @Test
    public void calcular() throws Exception {
        assertEquals(120, factorial.calcular(5));
    }
}