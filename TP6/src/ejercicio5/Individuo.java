package ejercicio5;

import java.util.List;
import java.util.Random;

/**
 * @author Pablo Germone
 */
public class Individuo {
    private Genoma genoma = Genoma.getInstancia();
    private List<Gen> genes = genoma.getGenes();

    public Individuo(){
        generarValores();
    }


    public List<Gen> getGenes() {
        return genes;
    }


    /**
     * Genera los valores para cada nucleotido de cada gen del genoma
     */
    private void generarValores(){
        for(Gen gen : genes){
            for(int i = 0; i <= gen.getLongitud(); i ++){
                Random random = new Random();
                int valor = random.nextInt(11);

                gen.agregarValor(valor);

                random = null;
            }
        }
    }
}