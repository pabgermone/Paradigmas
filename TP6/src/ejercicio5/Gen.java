package ejercicio5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Gen{
    private int longitud;
    private int id;
    private List<Integer> valorNucleotidos = new ArrayList<Integer>();

    public Gen(int id, int longitud){
        setId(id);
        setLongitud(longitud);
    }


    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getValorNucleotidos() {
        return valorNucleotidos;
    }

    public void agregarValor(int valor){
        getValorNucleotidos().add(valor);
    }
}
