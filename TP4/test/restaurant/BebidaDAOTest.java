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
public class BebidaDAOTest {
    @Before
    public void setUp() throws Exception {
        BebidaDAO.altaBebida("CervezaStella", 1000, 80);
        BebidaDAO.altaBebida("CervezaStella", 330, 40);
        BebidaDAO.altaBebida("CocaCola", 600, 40);
        BebidaDAO.altaBebida("AguaSinGas", 500, 30);
    }

    @After
    public void tearDown() throws Exception {
        BD.clear("BEBIDA");
    }

    @Test
    public void testCargaInicial() throws Exception{
        assertEquals(4, contarBebidas());
    }

    @Test
    public void testAltaBebida() throws Exception {
        BebidaDAO.altaBebida("CervezaQuilmes", 1000, 80);
        assertEquals(5, contarBebidas());
    }

    @Test
    public void testBorrarBebida() throws Exception {
        BebidaDAO.borrarBebida("AguaSinGas", 500);
        int encontrado;

        ResultSet resultSet = BD.getResultSet("SELECT COUNT(BEBIDA_ID) FROM BEBIDA WHERE BEBIDA_NOMBRE LIKE 'AguaSinGas';");
        resultSet.next();
        encontrado = resultSet.getInt(1);

        assertEquals(0, encontrado);
        assertEquals(3, contarBebidas());
    }

    @Test
    public void testModificarBebida() throws Exception {
        String nombre;
        int tamano;
        double precio;

        BebidaDAO.modificarBebida("AguaSinGas", 500, "Agua", 500, 30);

        ResultSet resultSet = BD.getResultSet("SELECT * FROM BEBIDA WHERE BEBIDA_ID = 4;");
        resultSet.next();
        nombre = resultSet.getString(2);

        assertEquals(nombre.compareTo("Agua"), 0);

        BebidaDAO.modificarBebida("Agua", 500, "Agua", 550, 30);

        resultSet = BD.getResultSet("SELECT * FROM BEBIDA WHERE BEBIDA_ID = 4;");
        resultSet.next();
        tamano = resultSet.getInt(3);

        assertEquals(tamano, 550);

        BebidaDAO.modificarBebida("Agua", 550, "Agua", 550, 25);

        resultSet = BD.getResultSet("SELECT * FROM BEBIDA WHERE BEBIDA_ID = 4;");
        resultSet.next();
        precio = resultSet.getDouble(4);

        assertTrue(precio == 25);
    }

    @Test
    public void testDevolverBebidas() throws Exception {
        List<String> esperado = new ArrayList<>();
        esperado.add("CervezaStella 1000");
        esperado.add("CervezaStella 330");
        esperado.add("CocaCola 600");
        esperado.add("AguaSinGas 500");

        List<String> bebidas = BebidaDAO.devolverBebidas();

        for(int i = 0; i < bebidas.size(); i++){
            assertEquals(0, bebidas.get(i).compareTo(esperado.get(i)));
        }
    }


    private int contarBebidas(){
        int cantidadBebidas = 0;

        try{
            ResultSet resultSet = BD.getResultSet("SELECT COUNT(BEBIDA_ID) FROM BEBIDA;");
            resultSet.next();
            cantidadBebidas = resultSet.getInt(1);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return cantidadBebidas;
    }
}