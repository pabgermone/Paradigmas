package Ejercicio1;

public class Recta {

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