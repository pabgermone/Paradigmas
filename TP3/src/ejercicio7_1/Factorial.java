package ejercicio7_1;

/**
 * @author Pablo Germone
 */
public class Factorial {

    /**
     * Calcula el factorial de un numero
     * @param numero Numero con el que se quiere realizar el calculo
     * @return Devuelve el resultado de la cuenta
     */
    public int calcular(int numero){
        if(numero == 1){
            return 1;
        }else{
            return numero * calcular(numero - 1);
        }
    }
}
