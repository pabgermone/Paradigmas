package Ejercicio1;

import static org.junit.Assert.*;

public class Ejercicio1Test {
    MasAltos masAltos;

    @org.junit.Before
    public void setUp() throws Exception {
        masAltos = new MasAltos();
    }

    @org.junit.Test
    public void mayores() throws Exception {
        int[] numeros = {1, 3, 84, 51, 7};
        int[] esperado = {84, 51};

        assertArrayEquals(esperado, masAltos.mayores(numeros));
    }
}
