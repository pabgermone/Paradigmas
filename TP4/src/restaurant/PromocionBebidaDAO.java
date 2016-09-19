package restaurant;

/**
 * @author Pablo Germone
 */
public class PromocionBebidaDAO {

    /**
     * Da de alta a una relacion entre una promocion y una bebida
     * @param idPromocion ID de la promocion que se quiere relacionar con una bebida
     * @param idBebida ID de la bebida que se quiere relacionar con una promocion
     */
    public static void altaPromocionBebida(int idPromocion, int idBebida){
        BD.update("INSERT INTO PROMOCIONBEBIDA VALUES(" +
                  idPromocion + ", " +
                  idBebida + ");");
    }


    /**
     * Quita todas las relaciones que haya con una promocion
     * @param idPromocion ID de la promocion de la que se quieren borrar las relaciones
     */
    public static void borrarPorPromocion(int idPromocion){
        BD.update("DELETE FROM PROMOCIONBEBIDA WHERE PROMOCIONBEBIDA_PROMOCION_ID = " + idPromocion + ";");
    }


    /**
     * Quita todas las relaciones que haya con una bebida
     * @param idBebida ID de la bebida de la que se quieren borrar las relaciones
     */
    public static void borrarPorBebida(int idBebida){
        BD.update("DELETE FROM PROMOCIONBEBIDA WHERE PROMOCIONBEBIDA_BEBIDA_ID = " + idBebida + ";");
    }
}
