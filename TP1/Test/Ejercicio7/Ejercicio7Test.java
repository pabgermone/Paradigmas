package Ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio7Test {
    Gps gps;

    @Before
    public void setUp(){
        gps = new Gps();
    }

    @Test
    public void obtenerTiempoRestante() throws Exception {
        assertTrue(gps.obtenerTiempoRestante(2, 4) == 120);
    }

}
