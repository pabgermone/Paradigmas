package Ejercicio5;

public class Multiplo {

    public int devolverValor(int valor1, int valor2){
        int resultado = 0;

        for(int i = 0; i <= 1000; i++){
            if(i%valor1 == 0){
                if(i%valor2 == 0){
                    resultado = i;
                }
            }
        }

        if(resultado != 0){
            return resultado;
        }
        else{
            return -1;
        }
    }
}

