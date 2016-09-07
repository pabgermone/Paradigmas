package Ejercicio2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio2Test {
    Numero numero;

    @Before
    public void setUp(){
        numero = new Numero();
    }

    @Test
    public void digitoMayor() throws Exception {
        numero.valor = 1927;

        assertEquals(9, numero.digitoMayor());
    }

}
