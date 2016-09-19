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
     * @param platos Nombres de los platos
     * @param bebidas Nombres y tamaños de las bebidas
     * @param precio Precio de la promocion
     */
    public static void altaPromocion(String nombre, List<String> platos, List<String> bebidas, double precio){
        int id = BD.getUltimoID("PROMOCION") + 1;

        BD.update("INSERT INTO PROMOCION VALUES(" +
                   id + ", '" +
                  nombre + "', " +
                  precio + ");");

        for(String bebida : bebidas){
            String[] datosBebida = bebida.split("\\s");
            int bebidaID = BebidaDAO.getID(datosBebida[0], Integer.parseInt(datosBebida[1]));
            PromocionBebidaDAO.altaPromocionBebida(id, bebidaID);
        }

        for(String plato : platos){
            int platoID = PlatoDAO.getID(plato);
            PromocionPlatoDAO.altaPromocionPlato(id, platoID);
        }
    }


    /**
     * Elimina una promocion de la base
     * @param nombre Nombre de la promocion a eliminar
     */
    public static void borrarPromocion(String nombre){
        PromocionBebidaDAO.borrarPorPromocion(getID(nombre));
        PromocionPlatoDAO.borrarPorPromocion(getID(nombre));
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


    /**
     * Devuelve el ID de una promocion
     * @param nombre Nombre de la promocion de la que se queire el ID
     * @return ID de la promocion
     */
    public static Integer getID(String nombre){
        try{
            ResultSet resultSet = BD.getResultSet("SELECT PROMOCION_ID FROM PROMOCION WHERE PROMOCION_NOMBRE LIKE '" + nombre + "';");
            resultSet.next();
            return resultSet.getInt(1);

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
