package ejercicio5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Gen{
    private int longitud;
    private int id;
    private List<String> valorNucleotidos = new ArrayList<String>();

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

    public List<String> getValorNucleotidos() {
        return valorNucleotidos;
    }

    public void agregarValor(String valor){
        getValorNucleotidos().add(valor);
    }
}
