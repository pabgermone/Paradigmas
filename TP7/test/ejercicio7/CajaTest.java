package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CajaTest {
    Chango chango;
    Caja caja;
    Supermercado supermercado;

    @Before
    public void setUp() throws Exception {
        supermercado = new Supermercado();
        caja = new Caja(supermercado);
        chango = new Chango();

        chango.addProducto(new Carne("Asado", 100));
        chango.addProducto(new Carne("Pollo", 100));
        chango.addProducto(new Carne("Pollo", 100));
        chango.addProducto(new Lacteo("Leche", 10));
        chango.addProducto(new Lacteo("Leche", 10));
        chango.addProducto(new Lacteo("Leche", 10));
        chango.addProducto(new Enlatado("Atun", 20));
    }

    @Test
    public void facturar() throws Exception {
        caja.facturar(chango);

        assertTrue(caja.getRecaudado() == 245.4);
    }

}