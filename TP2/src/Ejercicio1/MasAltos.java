package Ejercicio1;

/**
 * @author Pablo Germone
 */
public class MasAltos {

    /**
     * Encuentra los dos enteros mayores dentro de un array de int
     * @param numeros array de numeros a comparar
     * @return array con los dos numeros mayores
     */
    public int[] mayores(int [] numeros){
        int[] resultados = {Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] > resultados[0]){
                resultados[1] = resultados[0];
                resultados[0] = numeros[i];

            }else if(numeros[i] > resultados[1]){
                resultados[1] = numeros[i];
            }
        }

        return resultados;
    }
}
