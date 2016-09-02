package Ejercicio6;

public class PrimosGemelos {

    public int[] encontrarGemelos(int numero){
        int f = 1;
        int primoA = 0;
        int primoB = 0;

        while(f == 1){
            if(esPrimo(numero)){
                if(esPrimo(numero + 2)){
                    primoA = numero;
                    primoB = numero + 2;

                    f = 0;
                }else{
                    numero++;
                }
            }else{
                numero++;
            }
        }

        int[] resultado = {primoA, primoB};

        return resultado;
    }


    public boolean esPrimo(int numero){
        boolean primo = true;

        if(numero >= 2){
            for(int i = 2; i != numero; i++){
                if(numero % i == 0){
                    primo = false;
                }
            }
        }else{
            primo = false;
        }

        return primo;
    }
}
