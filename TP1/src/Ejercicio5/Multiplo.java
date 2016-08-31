package Ejercicio5;

public class Multiplo {

    public int devolverValor(int x, int y){
        int r = 0;

        for(int i = 0; i <= 1000; i++){
            if(i%x == 0){
                if(i%y == 0){
                    r = i;
                }
            }
        }

        if(r != 0){
            return r;
        }
        else{
            return -1;
        }
    }
}
