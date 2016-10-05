import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class CocineroTest {
    Cocinero cocinero;

    @Before
    public void setUp() throws Exception {
        cocinero = new Cocinero();
    }

    @Test
    public void getPlatos() throws Exception {
        Plato plato1 = new Plato();
        Plato plato2 = new Plato();
        List<Plato> esperado = new ArrayList<Plato>();

        esperado.add(plato1);
        esperado.add(plato2);
        cocinero.agregarPlato(plato1);
        cocinero.agregarPlato(plato2);

        for(int i = 0; i < cocinero.getPlatos().size(); i++){
            assertEquals(cocinero.getPlatos().get(i), esperado.get(i));
        }
    }

    @Test
    public void agregarPlato() throws Exception {
        Plato plato = new Plato();

        cocinero.agregarPlato(plato);

        assertEquals(cocinero.getPlatos().size(), 1);
    }

}