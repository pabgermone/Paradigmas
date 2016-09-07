package Ejercicio3;

/**
 * @author Pablo Germone
 */
public class Factorial {

    /**
     * Calcula el factorial de un numero
     *
     * @param num int con el que se quiere hacer el calculo
     *
     * @return Devuelve el factorial de num
     */
    public int calcular(int num){
        int resultado = num;

        for(int i = 1; i < num; i++){
            resultado = resultado * i;
        }

        return resultado;
    }
}

