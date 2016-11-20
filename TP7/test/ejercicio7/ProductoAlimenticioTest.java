package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductoAlimenticioTest {
    Carne carne;
    Lacteo lacteo;
    Enlatado enlatado;

    @Before
    public void setUp() throws Exception {
        carne = new Carne("Asado", 100);
        lacteo = new Lacteo("Leche", 10);
        enlatado = new Enlatado("Atun", 10);
    }

    @Test
    public void getPrecioVenta() throws Exception {
        assertTrue(carne.getPrecioVenta() == 90);
        assertTrue(lacteo.getPrecioVenta() == 8);
        assertTrue(enlatado.getPrecioVenta() == 10);
    }

    @Test
    public void aplicarDescuento() throws Exception {
        carne.aplicarDescuento();
        lacteo.aplicarDescuento();
        enlatado.aplicarDescuento();

        assertTrue(carne.getPrecioVenta() == 27);
        assertTrue(lacteo.getPrecioVenta() == 2.4);
        assertTrue(enlatado.getPrecioVenta() == 3);
    }

}