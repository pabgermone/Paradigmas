package ejercicio1;

/**
 * @author Pablo Germone
 */
public class Expresion {

    /**
     * Resuelve el calculo de una expresion aritmetica en formato String
     * @param exp Expresion aritmetica
     * @return Resultado
     */
    public int calcular(String exp){
        String[] cuenta = exp.split("\\s");
        int respuesta = 0;

        switch(cuenta[1]){
            case "+":
                respuesta = Integer.parseInt(cuenta[0]) + Integer.parseInt(cuenta[2]);
                break;
            case "-":
                respuesta = Integer.parseInt(cuenta[0]) - Integer.parseInt(cuenta[2]);
                break;
            case "*":
                respuesta = Integer.parseInt(cuenta[0]) * Integer.parseInt(cuenta[2]);
                break;
            case "/":
                respuesta = Integer.parseInt(cuenta[0]) / Integer.parseInt(cuenta[2]);
                break;
        }

        return respuesta;
    }
}