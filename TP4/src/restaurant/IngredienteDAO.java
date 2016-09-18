package restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class IngredienteDAO {

    /**
     * Da de alta a un ingrediente en la base
     * @param nombre Nombre del ingrediente
     * @param tipo Tipo del ingrediente
     */
    public static void altaIngrediente(String nombre, String tipo){
        try{
            int id = BD.getUltimoID("INGREDIENTE") + 1;

            BD.update("INSERT INTO INGREDIENTE "
                    + "VALUES (" + id + ", '" + nombre + "', '" + tipo + "');");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * Quita de la base a todos los ingredientes con el nombre indicado
     * @param nombre Nombre del ingrediente
     */
    public static void borrarIngrediente(String nombre){
        try{
            BD.update("DELETE FROM INGREDIENTE WHERE INGREDIENTE_NOMBRE LIKE '" + nombre + "';");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * Modifica el nombre y tipo de un ingrediente
     * @param nombreViejo Nombre del ingrediente a modificar
     * @param nombreNuevo Nuevo nombre para el ingrediente
     * @param tipoNuevo Nuevo tipo para el ingrediente
     */
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

    /**
     * Lista todos los ingredientes
     * @return Devuelve una lista que contiene el nombre de todos los ingredientes
     */
    public static List<String> devolverIngredientes(){
        List<String> ingredientes = new ArrayList<>();

        try{
            ResultSet resultSet = BD.getResultSet("SELECT INGREDIENTE_NOMBRE FROM INGREDIENTE");

            while(resultSet.next()){
                ingredientes.add(resultSet.getString("INGREDIENTE_NOMBRE"));
            }

            return ingredientes;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Lista todas las verduras de la base
     * @return Devuelve la lista con los ingredientes que tengan tipo verdura
     */
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

    /**
     * Devuelve el ID de un ingrediente
     * @param nombre Nombre del ingrediente del que se quiere el ID
     * @return Devuelve el ID del ingrediente
     */
    public static Integer getID(String nombre){
        try{
            ResultSet resultSet = BD.getResultSet("SELECT INGREDIENTE_ID FROM INGREDIENTE WHERE INGREDIENTE_NOMBRE LIKE '" + nombre + "';");
            resultSet.next();
            return resultSet.getInt(1);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}