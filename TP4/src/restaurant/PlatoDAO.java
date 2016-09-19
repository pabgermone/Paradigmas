package restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class PlatoDAO{

    /**
     * Da de alta un nuevo plato en la base y a su relacion con cada uno de los ingredientes
     * @param nombre Nombre del plato
     * @param precio Precio del plato
     * @param ingredientes Lista de ingredientes necesarios para el plato
     */
    public static void altaPlato(String nombre, double precio, List<String> ingredientes){
        int idPlato = BD.getUltimoID("PLATO") + 1;
        int idIngrediente;

        BD.update("INSERT INTO PLATO VALUES( " +
                  idPlato + ", '" +
                  nombre + "', " +
                  precio + ");");

        for(String ingrediente : ingredientes){
            idIngrediente = IngredienteDAO.getID(ingrediente);
            IngredientePlatoDAO.altaIngredientesPlato(idPlato, idIngrediente);
        }
    }

    /**
     * Elimina un plato y todas las relaciones que tenga con algun ingrediente
     * @param nombre Nombre del plato a eliminar
     */
    public static void borrarPlato(String nombre){
        IngredientePlatoDAO.borrarPorPlato(getID(nombre));
        BD.update("DELETE FROM PLATO WHERE PLATO_NOMBRE LIKE '" + nombre + "';");
    }


    /**
     * Modifica el precio y el nombre de un cierto plato
     * @param nombreViejo Nombre del plato a modificar
     * @param nombreNuevo Nuevo nombre para el plato
     * @param precioNuevo Nuevo precio para el plato
     */
    public static void modificar(String nombreViejo, String nombreNuevo, double precioNuevo){
        BD.update("UPDATE PLATO SET " +
                  "PLATO_NOMBRE = '" + nombreNuevo + "', " +
                  "PLATO_PRECIO = " + precioNuevo +
                  " WHERE PLATO_NOMBRE LIKE '" + nombreViejo + "';");
    }


    /**
     * Lista todos los platos de la base
     * @return Devuelve una lista con todos los platos
     */
    public static List<String> devolverPlatos(){
        List<String> platos = new ArrayList<String>();

        try{
            ResultSet resultSet = BD.getResultSet("SELECT PLATO_NOMBRE FROM PLATO");

            while(resultSet.next()){
                platos.add(resultSet.getString(1));
            }

            return platos;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    /**
     * Encuentra el ID de un plato
     * @param nombre Nombre del plato del que se quiere conocer el ID
     * @return Devuelve el ID del plato
     */
    public static Integer getID(String nombre){
        try{
            ResultSet resultSet = BD.getResultSet("SELECT PLATO_ID FROM PLATO WHERE PLATO_NOMBRE LIKE '" + nombre + "';");
            resultSet.next();
            return resultSet.getInt(1);

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
