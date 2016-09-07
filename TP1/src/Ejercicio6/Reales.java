package Ejercicio6;

/**
 * @author Pablo Germone
 */
public class Reales {
    double x, y, z;

    /**
     * Toma tres numeros reales y los oredena de menor a mayor
     * @param a Primer numero
     * @param b Segundo numero
     * @param c Tercer numero
     * @return String que muestra el orden de los numeros
     */
    public String ordenar(double a, double b, double c){
        if(a < b){
            if (a < c){
                if(b < c){

                    x = a;
                    y = b;
                    z = c;
                }
                else{
                    x = a;
                    y = c;
                    z = b;
                }
            }
            else{
                x = c;
                y = a;
                z = b;
            }
        }
        else if(c < b){
            x = c;
            y = b;
            z = a;
        }
        else if(b < c){
            if(a < c){
                x = b;
                y = a;
                z = c;
            }
            else{
                x = b;
                y = c;
                z = a;
            }
        }

        return "el orden de los numeros es: " + x + ", " + y + ", " + z;
    }
}

