import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class CartaTest {
    Carta carta;

    @Before
    public void setUp() throws Exception {
        carta = new Carta();
    }

    @Test
    public void agregarPlato() throws Exception {
        Plato plato = new Plato();

        carta.agregarPlato(plato);

        assertEquals(carta.getPlatos().size(), 1);
    }

    @Test
    public void removerPlato() throws Exception {
        Plato plato = new Plato();

        carta.agregarPlato(plato);
        carta.removerPlato(plato);

        assertEquals(carta.getPlatos().size(), 0);
    }

    @Test
    public void precioPromedio() throws Exception {
        Plato plato = new Plato("asd", 3);

        carta.agregarPlato(plato);

        assertEquals(carta.precioPromedio().intValue(), 6);
    }

    @Test
    public void platoConMejorOpinion() throws Exception {
        Plato plato = new Plato("milanesas", 1);
        plato.agregarOpinion(5);

        carta.agregarPlato(plato);

        assertEquals(carta.platoConMejorOpinion().getNombre().compareTo("milanesas"), 0);
    }
}