package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerfumeTest {
    Perfume perfume;

    @Before
    public void setUp() throws Exception {
        perfume = new Perfume("asd", 100);
    }

    @Test
    public void aplicarDescuento() throws Exception {
        perfume.aplicarDescuento();

        assertTrue(perfume.getPrecioVenta() == 30);
    }

}