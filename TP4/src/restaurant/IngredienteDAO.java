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
            int id = BD.getUltimoID("Ingrediente");

            BD.update("INSERT INTO Ingrediente "
                    + "VALUES (" + id + ", '" + nombre + "', '" + tipo + "');");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void borrarIngrediente(String nombre){
        try{
            BD.update("DELETE FROM Ingrediente WHERE ingrediente_nombre LIKE '" + nombre + "';");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void modificarIngrediente(String nombreViejo, String nombreNuevo, String tipoNuevo){
        try{
            BD.update("UPDATE Ingrediente "
                    + "SET ingrediente_nombre = '" + nombreNuevo
                    + "', ingrediente_tipo = '" + tipoNuevo
                    + "' WHERE ingrediente_nombre LIKE '" + nombreViejo + "';");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static List<String> devolverIngredientes(){
        List<String> ingredientes = new ArrayList<>();

        try{
            ResultSet resultSet = BD.getResultSet("SELECT ingrediente_nombre FROM Ingrediente;");

            while(resultSet.next()){
                ingredientes.add(resultSet.getString("ingrediente_nombre"));
            }

            return ingredientes;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}