package ejercicio5;

import java.util.Comparator;

/**
 * @author Pablo Germone
 */
public class PersonaDNIComparatorASC implements Comparator<Persona> {
    public int compare(Persona persona1, Persona persona2){
        return persona1.getDni() - persona2.getDni();
    }
}
