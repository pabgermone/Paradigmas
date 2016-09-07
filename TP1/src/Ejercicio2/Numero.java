package Ejercicio2;

/**
 * @author Pablo Germone
 */
public class Numero {
    int valor;

    /**
     * Indica cual es el digito mayor de Numero
     *
     * @return Digito mayor
     */
    public int digitoMayor(){
        int max = 0;
        int num = valor;
        int digito;

        while(num != 0){
            digito = num % 10;

            if(digito > max){
                max = digito;
            }

            num = num/10;
        }

        return max;
    }
}

