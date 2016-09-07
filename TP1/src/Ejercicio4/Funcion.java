package Ejercicio4;

/**
 * @author Pablo Germone
 */
public class Funcion {

    /**
     * Devuelve un valor determinado dependiendo de los valores de x e y
     * @param x Primer int
     * @param y Segundo int
     * @return 5: Si la suma de ambos es menor a 1; y*y: Si el resultado de la suma es mayor a 1
     */
    public int devolverValor(int x, int y){
        if(x + y < 1){
            return 5;
        }
        else{
            return y*y;
        }
    }
}

