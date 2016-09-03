package Ejercicio8;

public class Caracol {

    public int diasEnSalir(int p, int s, int r){
        int dias = 1;

        while(p >= s){
            dias++;

            s += s;

            if(s < p){
                s -= r;
            }
        }

        return dias;
    }
}