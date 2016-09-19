package restaurant;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import com.sun.org.apache.xml.internal.security.signature.reference.ReferenceSubTreeData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static restaurant.BD.getResultSet;
import static restaurant.BD.getUltimoID;

/**
 * @author Pablo Germone
 */
public class IngredienteDAOTest {
    @Before
    public void setUp() throws Exception {
        IngredienteDAO.altaIngrediente("Papa", "Verdura");
        IngredienteDAO.altaIngrediente("CarneParaMilanesa", "Carne");
        IngredienteDAO.altaIngrediente("PanRallado", "Otros");
        IngredienteDAO.altaIngrediente("Huevo", "Otros");
        IngredienteDAO.altaIngrediente("Lechuga", "Verdura");
        IngredienteDAO.altaIngrediente("Tomate", "Verdura");
        IngredienteDAO.altaIngrediente("Fideos", "Pasta");
        IngredienteDAO.altaIngrediente("Salsa", "Otros");
        IngredienteDAO.altaIngrediente("Cebolla", "Verdura");
    }

    @After
    public void tearDown() throws Exception {
        BD.clear("INGREDIENTE");
    }

    @Test
    public void testCargaInicial() throws Exception{
        assertEquals(9, contarIngredientes());
    }

    @Test
    public void testAltaIngrediente() throws Exception{
        IngredienteDAO.altaIngrediente("Zanahoria", "Verdura");

        int idEsperado = 10;
        int idMax;
        int cantidadIngredientes = contarIngredientes();

        idMax = BD.getUltimoID("INGREDIENTE");

        assertEquals(idMax, idEsperado);
        assertEquals(cantidadIngredientes, 10);
    }

    @Test
    public void testBaja() throws Exception{
        IngredienteDAO.borrarIngrediente("Lechuga");
        int encontrado = 1;

        try{
            Class.forName("org.h2.Driver");

            Connection connection = DriverManager.getConnection("jdbc:h2:D:/paradigmas/restaurant", "sa", "");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(INGREDIENTE_ID) FROM INGREDIENTE WHERE INGREDIENTE_NOMBRE LIKE 'Lechuga';");
            resultSet.next();
            encontrado = resultSet.getInt(1);

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(0, encontrado);
    }

    @Test
    public void testModificacion() throws Exception{
        String nombre;
        String tipo;

        IngredienteDAO.modificarIngrediente("Cebolla", "Salchichas", "Verdura");

        ResultSet resultSet = BD.getResultSet("SELECT * FROM INGREDIENTE WHERE INGREDIENTE_ID = 9;");
        resultSet.next();
        nombre = resultSet.getString(2);

        assertTrue(nombre.compareTo("Salchichas") == 0);

        IngredienteDAO.modificarIngrediente("Salchichas", "Sachichas", "Carne");

        resultSet = BD.getResultSet("SELECT * FROM INGREDIENTE WHERE INGREDIENTE_ID = 9;");
        resultSet.next();
        tipo = resultSet.getString(3);

        assertTrue(tipo.compareTo("Carne") == 0);
    }

    @Test
    public void testDevolverVerduras() throws Exception{
        List<String> esperado = new ArrayList<>();
        esperado.add("Papa");
        esperado.add("Lechuga");
        esperado.add("Tomate");
        esperado.add("Cebolla");

        List<String> verduras = IngredienteDAO.devolverVerduras();

        for(int i = 0; i < verduras.size(); i++){
            assertEquals(verduras.get(i).compareTo(esperado.get(i)), 0);
        }
    }



    private int contarIngredientes(){
        int cantidadIngredientes = 0;

        try{
            Class.forName("org.h2.Driver");

            Connection con = DriverManager.getConnection("jdbc:h2:D:/paradigmas/restaurant", "sa", "");
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(INGREDIENTE_ID) FROM INGREDIENTE");
            resultSet.next();
            cantidadIngredientes = resultSet.getInt(1);

            resultSet.close();
            statement.close();
            con.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return cantidadIngredientes;
    }
}