package restaurant;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class IngredienteDAO {

    public static void altaIngrediente(String nombre, String tipo){
        try{
            int id = BD.getUltimoID("INGREDIENTE") + 1;

            BD.update("INSERT INTO INGREDIENTE "
                    + "VALUES (" + id + ", '" + nombre + "', '" + tipo + "');");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void borrarIngrediente(String nombre){
        try{
            BD.update("DELETE FROM INGREDIENTE WHERE INGREDIENTE_NOMBRE LIKE '" + nombre + "';");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void modificarIngrediente(String nombreViejo, String nombreNuevo, String tipoNuevo){
        try{
            BD.update("UPDATE INGREDIENTE "
                    + "SET INGREDIENTE_NOMBRE = '" + nombreNuevo
                    + "', INGREDIENTE_TIPO = '" + tipoNuevo
                    + "' WHERE INGREDIENTE_NOMBRE LIKE '" + nombreViejo + "';");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static List<String> devolverVerduras(){
        List<String> ingredientes = new ArrayList<>();

        try{
            ResultSet resultSet = BD.getResultSet("SELECT INGREDIENTE_NOMBRE FROM INGREDIENTE WHERE INGREDIENTE_TIPO LIKE 'Verdura';");

            while(resultSet.next()){
                ingredientes.add(resultSet.getString("INGREDIENTE_NOMBRE"));
            }

            return ingredientes;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}