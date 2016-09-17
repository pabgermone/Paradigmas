package ejercicio7_2;

/**
 * @author Pablo Germone
 */
public class Fibonacci {

    /**
     * Encuentra el numero de la serie de Fibonacci que se encuentre en la posicion indicada
     * @param posicion Posicion de la serie
     * @return Devuelve el numero de la serie que este en esa posicion
     */
    public int getNumero(int posicion){
        if(posicion != 0){
            return calcular(0, 1, posicion - 1);
        }else{
            return 0;
        }
    }

    /**
     * Realiza los calculos necesarios para llegar al numero pedido
     * @param valor1 Primer numero a sumar
     * @param valor2 Segundo numero a sumar
     * @param contador Valor de referencia para saber a que posisicion de la serie pertenece el numero calculado
     * @return Devuelve el ultimo numero calculado cuando el contador lelga a 0
     */
    private int calcular(int valor1, int valor2, int contador){
        int resultado;

        if(contador == 0){
            return valor2;
        }else{
            resultado = valor1 + valor2;
            return calcular(valor2, resultado, contador - 1);
        }
    }
}
