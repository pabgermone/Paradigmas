package Ejercicio5;

/**
 * @author Pablo Germone
 */
public class Multiplo {

    /**
     * Devuelve el menor multiplo (menor a 1000) que tengan en comun valor1 y valor2
     * @param valor1 Primer int
     * @param valor2 Segundo int
     * @return int multiplo de ambos numeros; si no se encuentra multiplo, devuelve -1
     */
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

