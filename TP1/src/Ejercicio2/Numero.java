package Ejercicio2;

public class Numero {
    int num;

    public Numero(int num){
        this.num = num;
    }

    public int digitoMayor(){
        int m = 0;
        int n = num;
        int d;

        while(n/10 > 0){
            d = n%10;

            if(d > m){
                m = d;
            }

            n = n/10;
        }

        return m;
    }
}
