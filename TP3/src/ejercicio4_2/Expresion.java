package ejercicio4_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Expresion{
    private List<Character> pila = new ArrayList<Character>();

    /**
     * Revisa que la expresion ingresada este balanceada
     * @param exp Expresion a verificar
     * @return Devuelve un boolean indicando si la expresion esta balanceada
     */
    public boolean esBalanceada(String exp){
        for(int i = 0; i < exp.length(); i++){
            Character aux = exp.charAt(i);

            if((aux.compareTo('{') == 0) || (aux.compareTo('[') == 0) || (aux.compareTo('(') == 0)){
                pila.add(aux);
            }else if((aux.compareTo('}') == 0) || (aux.compareTo(']') == 0) || (aux.compareTo(')') == 0)){
                switch(aux){
                    case('}'):
                        if(pila.get(pila.size() - 1).compareTo('{') == 0){
                            pila.remove(pila.size() - 1);
                        }else{
                            return false;
                        }
                        break;

                    case(']'):
                        if(pila.get(pila.size() - 1).compareTo('[') == 0){
                            pila.remove(pila.size() - 1);
                        }else{
                            return false;
                        }
                        break;

                    case(')'):
                        if(pila.get(pila.size() - 1).compareTo('(') == 0){
                            pila.remove(pila.size() - 1);
                        }else{
                            return false;
                        }
                        break;
                }
            }
        }

        return pila.isEmpty();
    }
}