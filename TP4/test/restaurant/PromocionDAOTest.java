package restaurant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        IngredienteDAO.altaIngrediente("Fideos", "Pasta");
        IngredienteDAO.altaIngrediente("Salsa", "Otros");


        List<String> ingredientesMilanesa = new ArrayList<String>();
        ingredientesMilanesa.add("CarneParaMilanesa");
        ingredientesMilanesa.add("PanRallado");
        ingredientesMilanesa.add("Huevo");

        List<String> ingredientesEnsalada = new ArrayList<String>();
        ingredientesEnsalada.add("Lechuga");
        ingredientesEnsalada.add("Tomate");
        ingredientesEnsalada.add("Cebolla");

        List<String> ingredientesFideos = new ArrayList<String>();
        ingredientesFideos.add("Fideos");
        ingredientesEnsalada.add("Salsa");


        PlatoDAO.altaPlato("Milanesa", 70, ingredientesMilanesa);
        PlatoDAO.altaPlato("EnsaladaMixta", 50, ingredientesEnsalada);
        PlatoDAO.altaPlato("FideosConSalsa", 70, ingredientesFideos);


        List<String> platosPromo1 = new ArrayList<String>();
        platosPromo1.add("Milanesa");
        platosPromo1.add("EnsaladaMixta");

        List<String> platosPromo2 = new ArrayList<String>();
        platosPromo2.add("FideosConSalsa");


        BebidaDAO.altaBebida("AguaSinGas", 500, 30);
        BebidaDAO.altaBebida("CervezaStella", 330, 40);


        List<String> bebidasPromo1 = new ArrayList<String>();
        bebidasPromo1.add("AguaSinGas 500");

        List<String> bebidasPromo2 = new ArrayList<String>();
        bebidasPromo2.add("CervezaStella 330");


        PromocionDAO.altaPromocion("MilaConEnsalada", platosPromo1, bebidasPromo1, 100);
        PromocionDAO.altaPromocion("FideosConBebida", platosPromo2, bebidasPromo2, 100);
    }

    @After
    public void tearDown() throws Exception {
        BD.update("DELETE FROM PROMOCIONPLATO WHERE PROMOCIONPLATO_PROMOCION_ID >= 0;");
        BD.update("DELETE FROM PROMOCIONBEBIDA WHERE PROMOCIONBEBIDA_BEBIDA_ID >= 0;");
        BD.update("DELETE FROM INGREDIENTEPLATO WHERE INGREDIENTEPLATO_PLATO_ID >= 0;");
        BD.clear("BEBIDA");
        BD.clear("INGREDIENTE");
        BD.clear("PLATO");
        BD.clear("PROMOCION");
    }

    @Test
    public void testCargaInicial() throws Exception{
        assertEquals(2, contarPromociones());
    }

    @Test
    public void testAltaPromocion() throws Exception {
        List<String> platosPromo3 = new ArrayList<String>();
        platosPromo3.add("Milanesa");
        platosPromo3.add("FideosConSalsa");

        List<String> bebidasPromo3 = new ArrayList<String>();
        bebidasPromo3.add("AguaSinGas 500");
        bebidasPromo3.add("CervezaStella 330");

        PromocionDAO.altaPromocion("MilanesaYFideos", platosPromo3, bebidasPromo3, 150);

        assertEquals(3, contarPromociones());
    }

    @Test
    public void testBorrarPromocion() throws Exception {
        PromocionDAO.borrarPromocion("MilaConEnsalada");
        int encontrado = 1;

        try{
            ResultSet resultSet = BD.getResultSet("SELECT COUNT(PROMOCION_ID) FROM PROMOCION WHERE PROMOCION_NOMBRE LIKE 'MilaConEnsalada';");
            resultSet.next();
            encontrado = resultSet.getInt(1);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        assertEquals(0, encontrado);
        assertEquals(1, contarPromociones());
    }

    @Test
    public void testModificarPromocion() throws Exception {
        String nombre;
        double precio;

        PromocionDAO.modificarPromocion("MilaConEnsalada", "MilanesaConEnsalada", 100);

        ResultSet resultSet = BD.getResultSet("SELECT * FROM PROMOCION WHERE PROMOCION_ID = 1;");
        resultSet.next();
        nombre = resultSet.getString(2);

        assertEquals(nombre.compareTo("MilanesaConEnsalada"), 0);

        PromocionDAO.modificarPromocion("MilanesaConEnsalada", "MilanesaConEnsalada", 120);

        resultSet = BD.getResultSet("SELECT * FROM PROMOCION WHERE PROMOCION_ID = 1;");
        resultSet.next();
        precio = resultSet.getDouble(3);

        assertTrue(precio == 120);
    }

    @Test
    public void testDevolverPromociones() throws Exception{
        List<String> esperado = new ArrayList<String>();
        esperado.add("MilaConEnsalada");
        esperado.add("FideosConBebida");

        List<String> promociones = PromocionDAO.devolverPromociones();

        for(int i = 0; i < promociones.size(); i++){
            assertEquals(0, promociones.get(i).compareTo(esperado.get(i)));
        }
    }


    private static int contarPromociones(){
        int cantidadPromociones = 0;

        try{
            ResultSet resultSet = BD.getResultSet("SELECT COUNT(PROMOCION_ID) FROM PROMOCION;");
            resultSet.next();
            cantidadPromociones = resultSet.getInt(1);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return cantidadPromociones;
    }
}