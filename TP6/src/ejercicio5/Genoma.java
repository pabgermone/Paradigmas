package ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Pablo Germone
 */
public class Genoma {
    private List<Gen> genes = new ArrayList<Gen>();
    private int idGen = 0;
    private static Genoma instancia = null;

    /**
     * Singleton para Genoma
     * @return Unica instancia creada de Genoma
     */
    public static synchronized Genoma getInstancia(){
        if(instancia == null){
            instancia = new Genoma();
        }

        return instancia;
    }

    private Genoma(){
        for(int i = 0; i <= 25000; i++){
            idGen++;
            crearGen(idGen);
        }
    }



    public List<Gen> getGenes() {
        return genes;
    }

    public void agregarGen(Gen gen){
        getGenes().add(gen);
    }



    /**
     * Intstancia un gen y lo agrega a la lista de genes del genoma
     * @param id ID para cada gen
     */
    public void crearGen(int id){
        Random random = new Random();
        int longitud = random.nextInt(6) + 5;

        random = null;

        Gen gen = new Gen(id, longitud);
        agregarGen(gen);
    }
}
