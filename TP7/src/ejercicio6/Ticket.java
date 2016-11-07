package ejercicio6;

/**
 * @author Pablo Germone
 */
public class Ticket {
    private Teatro.tipoLocalidad tipoLocalidad;

    public Teatro.tipoLocalidad getTipoLocalidad() {
        return tipoLocalidad;
    }

    public void setTipoLocalidad(Teatro.tipoLocalidad tipoLocalidad) {
        this.tipoLocalidad = tipoLocalidad;
    }


    @Override
    public String toString(){
        return this.getTipoLocalidad() + ": " + Teatro.getMonto(this.getTipoLocalidad());
    }
}
