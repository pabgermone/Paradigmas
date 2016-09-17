package ejercicio8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class Ejercicio8Test {
    Combinacion combinacion;

    @Before
    public void setUp() throws Exception {
        combinacion = new Combinacion();
    }

    @Test
    public void getCombinaciones() throws Exception {
        String[] esperado = {"BB", "BN", "NB", "NN"};
        String[] resultado = combinacion.getCombinaciones(2);

        for(int i = 0; i < esperado.length; i++){
            assertEquals(esperado[i], resultado[i]);
        }
    }
}