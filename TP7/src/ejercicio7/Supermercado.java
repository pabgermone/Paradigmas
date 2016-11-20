package ejercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Supermercado {
    private List<Caja> cajas = new ArrayList<Caja>();

    public List<Caja> getCajas() {
        return cajas;
    }

    public void addCaja(Caja caja){
        getCajas().add(caja);
    }


    public double liquidacionDelDia(){
        double total = 0;

        for(Caja caja : this.getCajas()){
            total += caja.getRecaudado();
        }

        return total;
    }
}
