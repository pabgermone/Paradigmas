package restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class BebidaDAO {

    /**
     * Da de alta a una nueva bebida en la base
     * @param nombre Nombre de la bebida
     * @param tamano Tamaño de la bebida
     * @param precio Precio de la bebida
     */
    public static void altaBebida(String nombre, int tamano, double precio){
        int id = BD.getUltimoID("BEBIDA") + 1;

        BD.update("INSERT INTO BEBIDA VALUES(" +
                  id + ", '" +
                  nombre + "', " +
                  tamano + ", " +
                  precio + ");");
    }


    /**
     * Elimina una bebida de la base junto con sus relaciones con promocion
     * @param nombre Nombre de la bebida a eliminar
     * @param tamano Tamaño de la bebida a eliminar
     */
    public static void borrarBebida(String nombre, int tamano){
        PromocionBebidaDAO.borrarPorBebida(getID(nombre, tamano));
        BD.update("DELETE FROM BEBIDA WHERE BEBIDA_NOMBRE LIKE '" + nombre + "';");
    }


    /**
     * Modifica una bebida de la base
     * @param nombreViejo Nombre de la bebida a modificar
     * @param nombreNuevo Nuevo nombre para la bebida
     * @param tamanoNuevo Nuevo tamaño para la bebida
     * @param precioNuevo Nuevo precio para la bebida
     */
    public static void modificarBebida(String nombreViejo, int tamanoViejo, String nombreNuevo, int tamanoNuevo, double precioNuevo){
        BD.update("UPDATE BEBIDA SET " +
                  "BEBIDA_NOMBRE = '" + nombreNuevo + "', " +
                  "BEBIDA_TAMANO = '" + tamanoNuevo + "', " +
                  "BEBIDA_PRECIO = " + precioNuevo +
                  " WHERE BEBIDA_NOMBRE LIKE '" + nombreViejo + "' AND BEBIDA_TAMANO LIKE '" + tamanoViejo + "';");
    }


    /**
     * Lista todas las bebidas de la base
     * @return Devuelve una lista con todas las bebidas
     */
    public static List<String> devolverBebidas(){
        List<String> bebidas = new ArrayList<String>();

        try{
            ResultSet resultSet = BD.getResultSet("SELECT BEBIDA_NOMBRE, BEBIDA_TAMANO FROM BEBIDA;");

            while(resultSet.next()){
                bebidas.add(resultSet.getString(1) + " " + resultSet.getInt(2));
            }

            return bebidas;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    /**
     * Devuelve el ID de una bebida
     * @param nombre Nombre de la bebida de la que se quiere el ID
     * @param tamano Tamaño de la bebida de la que se quiere el ID
     * @return
     */
    public static Integer getID(String nombre, int tamano){
        try{
            ResultSet resultSet = BD.getResultSet("SELECT BEBIDA_ID FROM BEBIDA" +
                                                  " WHERE BEBIDA_NOMBRE LIKE '" + nombre + "' AND BEBIDA_TAMANO = " + tamano + ";");
            resultSet.next();
            return resultSet.getInt(1);

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
