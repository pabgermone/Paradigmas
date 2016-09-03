package Ejercicio7;

public class JuegoRectangulos {

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