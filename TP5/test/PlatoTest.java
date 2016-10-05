import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class PlatoTest {
    Plato plato;
    Cocinero cocinero;

    Plato plato1;
    Plato plato2;
    Plato plato3;

    @Before
    public void setUp() throws Exception {
        plato = new Plato("Milanesas con Papas Fritas", 2);
        cocinero = new Cocinero();
    }

    @After
    public void tearDown() throws Exception {
        plato1 = null;
        plato2 = null;
        plato3 = null;
    }

    @Test
    public void testConstructor() throws Exception{
        plato1 = new Plato();
        plato2 = new Plato();
        plato3 = new Plato();

        plato1.setNombre("Milanesas con Papas Fritas");
        plato2.setNombre("Pollo a la Parrilla");
        plato3.setNombre("Ensalada de Rucula, Tomate y Queso");

        assertEquals(plato1.getNombre().compareTo("Milanesas con Papas Fritas"), 0);
        assertEquals(plato2.getNombre().compareTo("Pollo a la Parrilla"), 0);
        assertEquals(plato3.getNombre().compareTo("Ensalada de Rucula, Tomate y Queso"), 0);
    }

    @Test
    public void testConstructor2() throws Exception{
        plato1 = new Plato("Milanesas con Papas Fritas", 2);
        plato2 = new Plato("Pollo a la Parrilla", 1);
        plato3 = new Plato("Ensalada de Rucula, Tomate y Queso", 3);

        assertEquals(plato1.getNombre().compareTo("Milanesas con Papas Fritas"), 0);
        assertEquals(plato2.getNombre().compareTo("Pollo a la Parrilla"), 0);
        assertEquals(plato3.getNombre().compareTo("Ensalada de Rucula, Tomate y Queso"), 0);
    }

    @Test
    public void testGetPrecio() throws Exception {
        plato1 = new Plato("Milanesas con Papas Fritas", 2);
        plato2 = new Plato("Pollo a la Parrilla", 1);
        plato3 = new Plato("Ensalada de Rucula, Tomate y Queso", 3);

        assertTrue(plato1.getPrecio().intValue() == 6);
        assertTrue(plato2.getPrecio().intValue() == 3);
        assertTrue(plato3.getPrecio().intValue() == 6);
    }

    @Test
    public void testAgregarOpinion() throws Exception {
        plato.agregarOpinion(5);

        assertEquals(plato.getOpiniones().size(), 1);
    }

    @Test
    public void testGetOpinionPromedio() throws Exception {
        plato.agregarOpinion(5);
        plato.agregarOpinion(3);

        assertTrue(plato.getOpinionPromedio().intValue() == 4);
    }

    @Test
    public void testGetMailCocinero() throws Exception {
        cocinero.setMail("asd@gmail.com");
        plato.setCocinero(cocinero);

        assertEquals(plato.getMailCocinero().compareTo("asd@gmail.com"), 0);
    }

    @Test
    public void testImprimir() throws Exception {
        cocinero.setMail("asd@gmail.com");
        plato.setCocinero(cocinero);
        plato.agregarOpinion(5);

        assertEquals(plato.imprimir().compareTo("Milanesas con Papas Fritas(5 puntos) - asd@gmail.com"), 0);
    }

    @Test
    public void testSetCocinero() throws Exception {
        plato.setCocinero(cocinero);

        assertEquals(cocinero.getPlatos().size(), 1);
    }
}