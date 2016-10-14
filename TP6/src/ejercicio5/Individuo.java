package ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Pablo Germone
 */
public class Individuo {
    private Genoma genoma = Genoma.getInstancia();
    private List<Gen> genes = genoma.copiarGenoma();

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
            for(int i = 0; i < gen.getLongitud(); i ++){
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

        for(int i = 0; i < this.getGenes().size(); i++){
            Gen gen = this.getGenes().get(i);
            igual = false;

            int j = 0;

            while(!igual && j < individuo.getGenes().size()){
                Gen genComp = individuo.getGenes().get(j);

                if(gen.getLongitud() == genComp.getLongitud()){
                    contador = 0;

                    for(int k = 0; k < gen.getLongitud(); k++){
                        if(gen.getValorNucleotidos().get(k).equals(genComp.getValorNucleotidos().get(k))){
                            contador ++;
                        }
                    }

                    if(contador == gen.getLongitud()){
                        igual = true;
                    }
                }

                j++;
            }

            if(igual){
                iguales.add(gen);
            }
        }

        return iguales;
    }
}