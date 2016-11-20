package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SupermercadoTest {
    Chango chango;
    Chango chango2;
    Caja caja;
    Caja caja2;
    Supermercado supermercado;

    @Before
    public void setUp() throws Exception {
        supermercado = new Supermercado();
        caja = new Caja(supermercado);
        caja2 = new Caja(supermercado);
        chango = new Chango();
        chango2 = new Chango();

        chango.addProducto(new Carne("Asado", 100));
        chango.addProducto(new Carne("Pollo", 100));
        chango.addProducto(new Carne("Pollo", 100));
        chango.addProducto(new Lacteo("Leche", 10));
        chango.addProducto(new Lacteo("Leche", 10));
        chango.addProducto(new Lacteo("Leche", 10));
        chango.addProducto(new Enlatado("Atun", 20));

        chango2.addProducto(new Carne("Asado", 100));
        chango2.addProducto(new Carne("Pollo", 100));
        chango2.addProducto(new Carne("Pollo", 100));
        chango2.addProducto(new Lacteo("Leche", 10));
        chango2.addProducto(new Lacteo("Leche", 10));
        chango2.addProducto(new Lacteo("Leche", 10));
        chango2.addProducto(new Enlatado("Atun", 20));
    }

    @Test
    public void liquidacionDelDia() throws Exception {
        caja.facturar(chango);
        caja2.facturar(chango2);

        assertTrue(supermercado.liquidacionDelDia() == 490.8);
    }

}