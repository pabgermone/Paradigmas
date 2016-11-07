package ejercicio5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class RegistroDePersonas {
    private List<Persona> personas = new ArrayList<>();


    private List<Persona> getPersonas() {
        return personas;
    }


    public void agregarPersona(Persona persona){
        getPersonas().add(persona);
    }

    public Persona recuperarPersona(int dni){
        Persona encontrada = null;

        for(Persona persona : getPersonas()){
            if(persona.getDni() == dni){
                encontrada = persona;
            }
        }

        return encontrada;
    }

    public int cantidadPersonas(){
        return getPersonas().size();
    }

    public void imprimirListaPersonas(){
        for(Persona persona : getPersonas()){
            System.out.println(persona.getNombre() + " " + persona.getApellido() + persona.getDireccion() + "  DNI: " + persona.getDni());
        }
    }

    public List<Persona> retornarPersonasDeMayorAMenor(){
        getPersonas().sort(new PersonaDNIComparatorASC());

        return getPersonas();
    }
}