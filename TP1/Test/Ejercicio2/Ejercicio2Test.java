package Ejercicio2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio2Test {

    @Test
    public void digitoMayor() throws Exception {
        assertEquals(9, new Numero(1927).digitoMayor());
    }

}