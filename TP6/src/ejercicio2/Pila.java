package ejercicio2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Pila {
    private List<Character> elementos = new ArrayList<Character>();
    private int cantidadMaxima = 0;


    public Pila(){}

    /**
     * Instancia una Pila con una cantidad maxima de elementos permitidos
     * @param max Cantidad maxima
     */
    public Pila(int max){
        setCantidadMaxima(max);
    }


    public List<Character> getElementos() {
        return elementos;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    private void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public int getLength(){
        return getElementos().size();
    }


    /**
     * Agrega un caracter a la pila
     * @param caracter caracter a agregar
     */
    public void push(Character caracter){
        if(getCantidadMaxima() != 0){
            if(getLength() < getCantidadMaxima()){
                getElementos().add(caracter);
            }else{
                System.out.println("Cantidad maxima de elementos alcanzada");
            }
        }else{
            getElementos().add(caracter);
        }
    }


    /**
     * Devuelve y quita el ultimo elemento de la pila
     * @return Ultimo elemento de la pila
     */
    public Character pop(){
        Character caracter = getElementos().get(getLength() - 1);
        getElementos().remove(getLength() - 1);
        return caracter;
    }


    /**
     * Indica si la pila esta vacia
     * @return Bolean indicando si la pila esta vacia
     */
    public boolean isEmpty(){
        return getElementos().isEmpty();
    }
}
