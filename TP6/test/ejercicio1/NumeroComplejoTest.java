package ejercicio1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class NumeroComplejoTest {
    NumeroComplejo numeroComplejo;

    @Before
    public void setUp() throws Exception {
        numeroComplejo = new NumeroComplejo("5 - 3i");
    }

    @Test
    public void getParteReal() throws Exception {
        assertEquals(numeroComplejo.getParteReal(), 5);
    }

    @Test
    public void getParteImaginaria() throws Exception {
        assertEquals(numeroComplejo.getParteImaginaria().compareTo("-3i"), 0);
    }

    @Test
    public void getValor() throws Exception {
        assertEquals(numeroComplejo.getValor().compareTo("5 - 3i"), 0);
    }

    @Test
    public void getValorImaginario() throws Exception {
        assertEquals(numeroComplejo.getValorImaginario(), -3);
    }

    @Test
    public void suma() throws Exception {
        NumeroComplejo numero = new NumeroComplejo("5 - 3i");

        assertEquals(numeroComplejo.suma(numero).getValor().compareTo("10 - 6i"), 0);
    }

    @Test
    public void suma2() throws Exception {
        NumeroComplejo numero = new NumeroComplejo("-5 - 3i");

        assertEquals(numeroComplejo.suma(numero).getValor().compareTo("0 - 6i"), 0);
    }

    @Test
    public void suma3() throws Exception {
        NumeroComplejo numero = new NumeroComplejo("-5 + 3i");

        assertEquals(numeroComplejo.suma(numero).getValor().compareTo("0 + 0i"), 0);
    }

    @Test
    public void resta() throws Exception {
        NumeroComplejo numero = new NumeroComplejo("5 - 3i");

        assertEquals(numeroComplejo.resta(numero).getValor().compareTo("0 + 0i"), 0);
    }

    @Test
    public void resta2() throws Exception {
        NumeroComplejo numero = new NumeroComplejo("-5 - 3i");

        assertEquals(numeroComplejo.resta(numero).getValor().compareTo("10 + 0i"), 0);
    }

    @Test
    public void resta3() throws Exception {
        NumeroComplejo numero = new NumeroComplejo("5 + 3i");

        assertEquals(numeroComplejo.resta(numero).getValor().compareTo("0 - 6i"), 0);
    }
}