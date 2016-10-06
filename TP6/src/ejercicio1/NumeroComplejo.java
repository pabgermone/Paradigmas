package ejercicio1;

/**
 * @author Pablo Germone
 */
public class NumeroComplejo {
    private String[] partes;

    private int parteReal;
    private int valorImaginario;
    private String parteImaginaria;

    private String valor;



    public NumeroComplejo(String valor){
        setValor(valor);

        setPartes();
        setParteReal();
        setParteImaginaria();
        setValorImaginario();
    }



    public int getParteReal() {
        return parteReal;
    }

    private void setParteReal() {
        this.parteReal = Integer.parseInt(partes[0]);
    }

    public String getParteImaginaria() {
        return parteImaginaria;
    }

    private void setParteImaginaria() {
        this.parteImaginaria = partes[2];
    }

    private String getValor() {
        return valor;
    }

    private void setValor(String valor) {
        this.valor = valor;
    }

    private void setPartes(){
        partes = getValor().split("//s");
    }

    public int getValorImaginario() {
        return valorImaginario;
    }

    private void setValorImaginario() {
        String[] imaginario = getParteImaginaria().split("[0-9]");
        valorImaginario = Integer.parseInt(imaginario[0]);
    }



    public NumeroComplejo suma(NumeroComplejo numero){

    }
}
