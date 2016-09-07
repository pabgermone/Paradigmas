package Ejercicio2;

/**
 * @author Pablo Germone
 */
public class Par {

    /**
     * Devuelve el entero con la mayor cantidad de digitos pares
     * @param numeros Array con los numero a comparar
     * @return Entero con mayor cantidad de digitos pares
     */
    public int mayorCantidadPares(int[] numeros){
        int digito;
        int num;
        int max = 0;
        int aux = 0;
        int pares;

        for(int i = 0; i < numeros.length; i++){
            num = numeros[i];
            pares = 0;

            while(num != 0){
                digito = num%10;

                if(digito%2 == 0){
                    pares++;
                }

                num = num/10;
            }

            if(pares > max){
                max = pares;
                aux = numeros[i];
            }
        }

        return aux;
    }
}