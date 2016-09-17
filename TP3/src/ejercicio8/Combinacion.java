package ejercicio8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Combinacion {

    /**
     * Devuelve un array con todas las combinaciones posibles de B y N para una cierta cantidad de letras
     * @param cantidadLetras Cantidad de letras que tendra cada combinacion
     * @return Devuelve el array con todas las combinaciones
     */
    public String[] getCombinaciones(int cantidadLetras){
        List<String> combinaciones = new ArrayList<>();
        combinar(cantidadLetras, "", combinaciones);
        String[] combs = new String[combinaciones.size()];

        for(int i = 0; i < combinaciones.size(); i++){
            combs[i] = combinaciones.get(i);
        }

        return combs;
    }


    /**
     * Crea las combinaciones de letras y las guarda en una lista
     * @param cantidadLetras Cantidad de letras que tiene cada combinacion
     * @param stringActual String que se usa para generar las combinaciones
     * @param combinaciones Lista en donde se guardan las combinaciones
     */
    private void combinar(int cantidadLetras, String stringActual, List<String> combinaciones){
        if(stringActual.length() == cantidadLetras){
            combinaciones.add(stringActual);
        }else{
            combinar(cantidadLetras, stringActual + "B", combinaciones);
            combinar(cantidadLetras, stringActual + "N", combinaciones);
        }
    }
}
