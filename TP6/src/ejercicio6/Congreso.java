package ejercicio6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Congreso {
    private String nombre;
    private List<Asistente> asistentes = new ArrayList<Asistente>();
    private double precioBase;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public List<Asistente> getAsistentes() {
        return asistentes;
    }

    public void agregarAsistente(Asistente asistente){
        getAsistentes().add(asistente);
    }


    /**
     * Lista los nombres de cada asistente
     * @return Lista con todos los nombres y apellidos
     */
    public List<String> listarAsistentes(){
        List<String> nombres = new ArrayList<String>();

        for(Asistente asistente : getAsistentes()){
            nombres.add(asistente.getNombre() + " " + asistente.getApellido());
        }

        return nombres;
    }
}
