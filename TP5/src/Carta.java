import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
*/
public class Carta {
    private List<Plato> platos = new ArrayList<Plato>();



    public List<Plato> getPlatos() {
        return platos;
    }



    public void agregarPlato(Plato plato){
        getPlatos().add(plato);
    }

    public void removerPlato(Plato plato){
        getPlatos().remove(plato);
    }

    public Double precioPromedio(){
        int total = 0;
        double promedio;

        for(Plato plato : getPlatos()){
            total += plato.getPrecio();
        }

        promedio = total / getPlatos().size();

        return promedio;
    }

    public Plato platoConMejorOpinion(){
        Plato aux = null;
        double puntaje = 0;

        for(Plato plato : getPlatos()){
            if(plato.getOpinionPromedio() > puntaje){
                aux = plato;
                puntaje = plato.getOpinionPromedio();
            }
        }

        return aux;
    }
}