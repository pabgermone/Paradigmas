package ejercicio5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class IndividuoTest {
    Individuo individuo;

    @Before
    public void setUp() throws Exception {
        individuo = new Individuo();
    }

    @Test
    public void genesIguales() throws Exception {
        assertEquals(individuo.genesIguales(individuo).size(), 25000);
    }

}