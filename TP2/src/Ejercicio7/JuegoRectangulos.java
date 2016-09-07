package Ejercicio7;

/**
 * @author Pablo Germone
 */
public class JuegoRectangulos {

    /**
     * Usando las medidas de dos rectangulos, determina si uno puede entrar dentro del otro
     * @param a Base del primer rectangulo
     * @param b Altura del segundo rectangulo
     * @param c Base del segundo rectangulo
     * @param d Altura del segundo rectangulo
     * @return String indicando si encajan o no
     */
    public String comparar(int a, int b, int c, int d){

        if(((a < c) && (b < d)) || ((c < a) && (d < b))){
            return "Encajan sin girar";
        }else if(((a < d) && (b < c)) || ((d < a) && (c < b))){
            return "Encajan girando";
        }else{
            return "No encajan";
        }
    }
}