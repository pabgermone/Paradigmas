package Ejercicio1;

/**
 * @author Pablo Germone
 */

public class Recta {

    /**
     * Compara los valores de x e y para saber si pertenen a la recta
     *
     * @param x Valor x del punto a verificar
     * @param y Valor y del punto a verificar
     *
     * @return boolean indicando si el punto pertenece o no a la recta
     */
    public boolean probarPunto(int x, int y){
        if (y == 7 * x + 3){
            System.out.println("(X;Y) es parte de la recta Y = 7X + 3");
            return true;
        }
        else{
            System.out.println("(X;Y) no es parte de la recta Y = 7X + 3");
            return false;
        }
    }
}
