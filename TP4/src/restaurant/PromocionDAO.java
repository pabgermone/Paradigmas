package restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class PromocionDAO {

    /**
     * Da de alta una nueva promocion en la base
     * @param nombre Nombre de la promocion
     * @param plato Nombre del plato
     * @param bebida Nombre de la bebida (y tamaño)
     * @param precio Precio de la promocion
     */
    public static void altaPromocion(String nombre, String plato, String bebida, double precio){
        int id = BD.getUltimoID("PROMOCION") + 1;

        String[] datosBebida = bebida.split("\\s");
        int bebidaID = BebidaDAO.getID(datosBebida[0], Integer.parseInt(datosBebida[1]));
        int platoID = PlatoDAO.getID(plato);

        BD.update("INSERT INTO PROMOCION VALUES(" +
                   id + ", '" +
                  nombre + "', " +
                  platoID + ", " +
                  bebidaID + ", " +
                  precio + ");");
    }


    /**
     * Elimina una promocion de la base
     * @param nombre Nombre de la promocion a eliminar
     */
    public static void borrarPromocion(String nombre){
        BD.update("DELETE FROM PROMOCION WHERE PROMOCION_NOMBRE LIKE '" + nombre + "';");
    }


    /**
     * Modifica una promocion en la base
     * @param nombreViejo Nombre de la promocion a modificar
     * @param nombreNuevo Nuevo nombre para la promocion
     * @param precioNuevo Nuevo precio para la promocion
     */
    public static void modificarPromocion(String nombreViejo, String nombreNuevo, double precioNuevo){
        BD.update("UPDATE PROMOCION SET " +
                  "PROMOCION_NOMBRE = '" + nombreNuevo + "', " +
                  "PROMOCION_PRECIO = " + precioNuevo +
                  " WHERE PROMOCION_NOMBRE LIKE '" + nombreViejo + "';");
    }


    /**
     * Lista todas las promociones de la base
     * @return Devuelve una lista con los nombres de todas las promociones
     */
    public static List<String> devolverPromociones(){
        List<String> promociones = new ArrayList<>();

        try{
            ResultSet resultSet = BD.getResultSet("SELECT PROMOCION_NOMBRE FROM PROMOCION;");

            while(resultSet.next()){
                promociones.add(resultSet.getString(1));
            }

            return promociones;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
