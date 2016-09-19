package restaurant;

/**
 * @author Pablo Germone
 */
public class IngredientePlatoDAO {

    /**
     * Agrega una relacion entre un plato y un ingrediente a la tabla intermedia de ambas
     * @param idPlato Id del plato que se quiere relacionar a un ingrediente
     * @param idIngrediente Id del ingrediente que se va a relacionar con el plato
     */
    public static void altaIngredientesPlato(int idPlato, int idIngrediente){
        BD.update("INSERT INTO INGREDIENTEPLATO VALUES( " + idPlato + ", " + idIngrediente + ");");
    }


    /**
     * Quita toda las relaciones de un plato
     * @param idPlato ID del plato del que se quieren eliminar las relaciones
     */
    public static void borrarPorPlato(int idPlato){
        BD.update("DELETE FROM INGREDIENTEPLATO WHERE INGREDIENTEPLATO_PLATO_ID = " + idPlato);
    }


    /**
     * Quita todas las relaciones de un ingrediente
     * @param idIngrediente ID del ingrediente del que se quieren eliminar las relaciones
     */
    public static void borrarPorIngrediente(int idIngrediente){
        BD.update("DELETE FROM INGREDIENTEPLATO WHERE INGREDIENTEPLATO_INGREDIENTE_ID = " + idIngrediente + ";");
    }
}
