package ejercicio1;

/**
 * @author Pablo Germone
 */
public class NumeroComplejo {
    private String valor;
    private int parteReal;
    private String parteImaginaria;
    private int valorImaginario;


    public NumeroComplejo(String valor){
        setValor(valor);
        setPartes();
    }



    public int getParteReal() {
        return parteReal;
    }

    public String getParteImaginaria() {
        return parteImaginaria;
    }

    public String getValor() {
        return valor;
    }

    private void setValor(String valor) {
        this.valor = valor;
    }

    public int getValorImaginario() {
        return valorImaginario;
    }

    /**
     * Separa el String de la parte imaginaria, quedandose solo con el valor numerico
     */
    private void setValorImaginario() {
        String[] imaginario = getParteImaginaria().split("i");
        valorImaginario = Integer.parseInt(imaginario[0]);
    }

    /**
     * Toma las partes del numero complejo y las asigna a las propiedades correspondientes
     */
    private void setPartes(){
        String[] partes = getValor().split("\\s");

        this.parteReal = Integer.parseInt(partes[0]);

        if(partes[1].compareTo("-") == 0){
            this.parteImaginaria = "-" + partes[2];
        }else{
            this.parteImaginaria = partes[2];
        }

        setValorImaginario();
    }


    /**
     * Suma el numero actual con otro numero complejo
     * @param numero Numero con el que se quiere sumar
     * @return Numero complejo resultante de la suma
     */
    public NumeroComplejo suma(NumeroComplejo numero){
        String respuesta;
        int respuestaReal;
        int respuestaImaginaria;

        respuestaReal = this.getParteReal() + numero.getParteReal();
        respuestaImaginaria = this.getValorImaginario() + numero.getValorImaginario();

        if(respuestaImaginaria < 0){
            respuesta = respuestaReal + " - " + respuestaImaginaria * -1 + "i";
        }else{
            respuesta = respuestaReal + " + " + respuestaImaginaria + "i";
        }

        return new NumeroComplejo(respuesta);
    }


    /**
     * Resta al numero actual otro numero complejo
     * @param numero Numero complejo que se quiere restar
     * @return Numero complejo resultante de la resta
     */
    public NumeroComplejo resta(NumeroComplejo numero){
        String respuesta;
        int respuestaReal;
        int respuestaImaginaria;

        respuestaReal = this.getParteReal() - numero.getParteReal();
        respuestaImaginaria = this.getValorImaginario() - numero.getValorImaginario();

        if(respuestaImaginaria < 0){
            respuesta = respuestaReal + " - " + respuestaImaginaria * -1 + "i";
        }else{
            respuesta = respuestaReal + " + " + respuestaImaginaria + "i";
        }

        return new NumeroComplejo(respuesta);
    }
}