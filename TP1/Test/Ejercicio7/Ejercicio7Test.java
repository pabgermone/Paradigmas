package Ejercicio7;

import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio7Test {
    @Test
    public void obtenerTiempoRestante() throws Exception {
        assertTrue(new Gps().obtenerTiempoRestante(2, 4) == 120);
    }

}
