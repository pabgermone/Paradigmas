package restaurant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class PlatoDAOTest {
    @Before
    public void setUp() throws Exception {
        IngredienteDAO.altaIngrediente("CarneParaMilanesa", "Carne");
        IngredienteDAO.altaIngrediente("PanRallado", "Otros");
        IngredienteDAO.altaIngrediente("Huevo", "Otros");
        IngredienteDAO.altaIngrediente("Lechuga", "Verdura");
        IngredienteDAO.altaIngrediente("Tomate", "Verdura");
        IngredienteDAO.altaIngrediente("Fideos", "Pasta");
        IngredienteDAO.altaIngrediente("Salsa", "Otros");
        IngredienteDAO.altaIngrediente("Cebolla", "Verdura");

        List<String> ingredientesMilanesa = new ArrayList<>();
        ingredientesMilanesa.add("CarneParaMilanesa");
        ingredientesMilanesa.add("PanRallado");
        ingredientesMilanesa.add("Huevo");

        List<String> ingredientesEnsalada = new ArrayList<>();
        ingredientesEnsalada.add("Lechuga");
        ingredientesEnsalada.add("Tomate");
        ingredientesEnsalada.add("Cebolla");

        List<String> ingredientesFideos = new ArrayList<>();
        ingredientesFideos.add("Fideos");
        ingredientesEnsalada.add("Salsa");

        PlatoDAO.altaPlato("Milanesa", 70, ingredientesMilanesa);
        PlatoDAO.altaPlato("EnsaladaMixta", 50, ingredientesEnsalada);
        PlatoDAO.altaPlato("FideosConSalsa", 70, ingredientesFideos);
    }

    @After
    public void tearDown() throws Exception {
        BD.update("DELETE FROM INGREDIENTEPLATO WHERE INGREDIENTEPLATO_PLATO_ID >= 0");
        BD.clear("INGREDIENTE");
        BD.clear("PLATO");
    }

    @Test
    public void testCargaInicial() throws Exception{
        assertEquals(3, contarPlatos());
    }

    @Test
    public void testAltaPlato() throws Exception{
        List<String> ingredientes = new ArrayList<>();
        ingredientes.add("CarneParaMilanesa");
        ingredientes.add("PanRallado");
        ingredientes.add("Huevo");
        ingredientes.add("Salsa");

        PlatoDAO.altaPlato("MilanesaNapolitana", 90, ingredientes);

        assertEquals(4, contarPlatos());
    }

    @Test
    public void testBajaPlato() throws Exception{
        PlatoDAO.borrarPlato("EnsaladaMixta");
        int encontrado = 1;

        try{
            Class.forName("org.h2.Driver");

            Connection connection = DriverManager.getConnection("jdbc:h2:D:/paradigmas/restaurant", "sa", "");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(PLATO_ID) FROM PLATO WHERE PLATO_NOMBRE LIKE 'EnsaladaMixta';");
            resultSet.next();
            encontrado = resultSet.getInt(1);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        assertEquals(0, encontrado);
        assertEquals(2, contarPlatos());
    }

    @Test
    public void testModificacion() throws Exception{
        String nombre;
        double precio;

        PlatoDAO.modificar("FideosConSalsa", "FideosConTuco", 70);

        ResultSet resultSet = BD.getResultSet("SELECT * FROM PLATO WHERE PLATO_ID = 3;");
        resultSet.next();
        nombre = resultSet.getString(2);

        assertEquals(nombre.compareTo("FideosConTuco"), 0);

        PlatoDAO.modificar("FideosConTuco", "FideosConTuco", 75);

        resultSet = BD.getResultSet("SELECT * FROM PLATO WHERE PLATO_ID = 3;");
        resultSet.next();
        precio = resultSet.getDouble(3);

        assertTrue(precio == 75);
    }

    @Test
    public void testListarPlatos() throws Exception{
        List<String> esperado = new ArrayList<>();
        esperado.add("Milanesa");
        esperado.add("EnsaladaMixta");
        esperado.add("FideosConSalsa");

        List<String> platos = PlatoDAO.devolverPlatos();

        for(int i = 0; i < platos.size(); i++){
            assertEquals(0, platos.get(i).compareTo(esperado.get(i)));
        }
    }



    private int contarPlatos(){
        int cantidadPlatos = 0;

        try{
            ResultSet resultSet = BD.getResultSet("SELECT COUNT(PLATO_ID) FROM PLATO;");
            resultSet.next();
            cantidadPlatos = resultSet.getInt(1);

            resultSet.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return cantidadPlatos;
    }
}