package Ejercicio1;

public class MasAltos {

    public int[] mayores(int [] numeros){
        int[] resultados = {Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] > resultados[0]){
                resultados[1] = resultados[0];
                resultados[0] = numeros[i];

            }else if(numeros[i] > resultados[1]){
                resultados[1] = numeros[i];
            }
        }

        return resultados;
    }
}
