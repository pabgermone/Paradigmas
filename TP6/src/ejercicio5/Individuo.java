package ejercicio5;

import java.util.ArrayList;
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


    /**
     * Compara el individuo actual con otro y devuelve una lista con todos los genes iguales
     * @param individuo Individuo con el que se quiere comparar
     * @return Lista con los genes comunes entre los dos individuos
     */
    public List<Gen> genesIguales(Individuo individuo){
        List<Gen> iguales = new ArrayList<Gen>();
        int contador;
        boolean igual;

        for(Gen gen : this.getGenes()){
            for(Gen genComp : individuo.getGenes()){
                igual = false;

                if(gen.getLongitud() == genComp.getLongitud()){
                    contador = gen.getLongitud();

                    for(int i = 0; i < gen.getValorNucleotidos().size(); i++){
                        if(gen.getValorNucleotidos().get(i).equals(genComp.getValorNucleotidos().get(i))){
                            contador++;
                        }
                    }

                    if(contador == gen.getLongitud()){
                        igual = true;
                    }
                }

                if(igual){
                    iguales.add(gen);
                }
            }
        }

        return iguales;
    }
}