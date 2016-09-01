package Ejercicio3;

public class Factorial {

    public int calcular(int num){
        int r = num;

        for(int i = 1; i < num; i++){
            r = r * i;
        }

        return r;
    }
}

