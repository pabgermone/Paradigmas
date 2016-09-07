package Ejercicio4;

/**
 * @author Pablo Germone
 */
public class Potencia {

    /**
     * Encuentra el numero que cumple con x^y * z^w = xyzw
     * @return Devuelve el resultado
     */
    public int encontrarNumero(){
        int esperado;
        int resultado = 0;

        for(int x = 1; x < 10; x++){
            for(int y = 1; y < 10; y++){
                for(int z = 1; z < 10; z++){
                    for(int w = 1; w < 10; w++){
                        esperado = (1000 * x) + (100 * y) + (10 * z) + w;

                        if(esperado == (Math.pow(x, y) * Math.pow(z, w))){
                            resultado = esperado;
                            x = 10;
                        }
                    }
                }
            }
        }

        return resultado;
    }
}
