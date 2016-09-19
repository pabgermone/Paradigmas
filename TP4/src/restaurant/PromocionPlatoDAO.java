package restaurant;

/**
 * @author Pablo Germone
 */
public class PromocionPlatoDAO {

    /**
     * Da de alta a una relacion entre plato y promocion en la tabla intermedia
     * @param idPromocion ID de la promocion que se queire relacionar con el plato
     * @param idPlato ID del plato que se quiere relacionar con la promocion
     */
    public static void altaPromocionPlato(int idPromocion, int idPlato){
        BD.update("INSERT INTO PROMOCIONPLATO VALUES(" +
                  idPromocion + ", " +
                  idPlato + ");");
    }


    /**
     * Quita todas las relaciones que haya con una promocion
     * @param idPromocion ID de la promocion de la que se quiere quitar las relaciones
     */
    public static void borrarPorPromocion(int idPromocion){
        BD.update("DELETE FROM PROMOCIONPLATO WHERE PROMOCIONPLATO_PROMOCION_ID = " + idPromocion + ";");
    }


    /**
     * Quita todas las relaciones que haya con un plato
     * @param idPlato ID del plato del que se quieren quitar las relaciones
     */
    public static void borrarPorPlato(int idPlato){
        BD.update("DELETE FROM PROMOCIONPLATO WHERE PROMOCIONPLATO_PLATO_ID = " +idPlato + ";");
    }
}
