package restaurant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class PromocionDAOTest {
    @Before
    public void setUp() throws Exception {
        IngredienteDAO.altaIngrediente("CarneParaMilanesa", "Carne");
        IngredienteDAO.altaIngrediente("PanRallado", "Otros");
        IngredienteDAO.altaIngrediente("Huevo", "Otros");
        IngredienteDAO.altaIngrediente("Lechuga", "Verdura");
        IngredienteDAO.altaIngrediente("Tomate", "Verdura");
        IngredienteDAO.altaIngrediente("Cebolla", "Verdura");

        List<String> ingredientesMilanesa = new ArrayList<>();
        ingredientesMilanesa.add("CarneParaMilanesa");
        ingredientesMilanesa.add("PanRallado");
        ingredientesMilanesa.add("Huevo");

        List<String> ingredientesEnsalada = new ArrayList<>();
        ingredientesEnsalada.add("Lechuga");
        ingredientesEnsalada.add("Tomate");
        ingredientesEnsalada.add("Cebolla");

        PlatoDAO.altaPlato("Milanesa", 70, ingredientesMilanesa);
        PlatoDAO.altaPlato("EnsaladaMixta", 50, ingredientesEnsalada);

        BebidaDAO.altaBebida("AguaSinGas", 500, 30);
        BebidaDAO.altaBebida("CervezaStella", 330, 40);

        //PromocionDAO.altaPromocion("MilaConEnsalada");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAltaPromocion() throws Exception {

    }

    @Test
    public void testBorrarPromocion() throws Exception {

    }

    @Test
    public void testModificarPromocion() throws Exception {

    }

    @Test
    public void testDevolverPromociones() throws Exception{

    }
}