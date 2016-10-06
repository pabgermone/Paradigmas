package ejercicio3;

/**
 * @author Pablo Germone
 */
public class Cuenta {
    private int numero;
    private double saldo;
    private Cliente propietario;

    public Cuenta(int numero, Cliente propietario){
        setNumero(numero);
        setPropietario(propietario);
        propietario.agregarCuenta(this);
    }


    public int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    private void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }
}
