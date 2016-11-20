package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndumentariaTest {
    Indumentaria indumentaria;

    @Before
    public void setUp() throws Exception {
        indumentaria = new Indumentaria("Remera", "Nike", 14, 100);
    }

    @Test
    public void aplicarDescuento() throws Exception {
        indumentaria.aplicarDescuento();

        assertTrue(indumentaria.getPrecioVenta() == 30);
    }

}