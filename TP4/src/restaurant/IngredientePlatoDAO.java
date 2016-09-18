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
        BD.update("DELETE FROM INGREDIENTE PLATO WHERE INGREDIENTEPLATO_PLATO_ID = " + idPlato);
    }
}
