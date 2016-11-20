package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Banco {
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();
    private List<Cliente> clientes = new ArrayList<Cliente>();


    public List<Cuenta> getCuentas(){
        return cuentas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Devuelve la instancia de la cuenta que tenga el numero de cuenta ingresado por parametro
     * @param numeroCuenta Nuemero de la cuenta que se quiere encontrar
     * @return Cuenta con el mismo numero
     */
    public Cuenta obtenerCuenta(int numeroCuenta){
        Cuenta cuenta = null;

        for(Cuenta cta : getCuentas()){
            if(numeroCuenta == cta.getNumero()){
                cuenta = cta;
            }
        }

        return cuenta;
    }

    /**
     * Devuelve la instancia del cliente que tenga el DNI ingresado por parametro
     * @param dni DNI del cliente que se quiere encontrar
     * @return Cliente con el mismo DNI
     */
    public Cliente obtenerCliente(int dni){
        Cliente cliente = null;

        for(Cliente cte : getClientes()){
            if(cte.getDni() == dni){
                cliente = cte;
            }
        }

        return cliente;
    }

    public void agregarCuenta(Cuenta cuenta){
        getCuentas().add(cuenta);
    }

    public void agregarCliente(Cliente cliente){
        getClientes().add(cliente);
    }


    /**
     * Extrae dinero de una cuenta, siempre que haya suficiente
     * @param numeroCuenta Nuemero de la cuenta de la que se quiere extraer
     * @param monto Cantidad de dinero que se quiere extraer
     */
    public void extraer(int numeroCuenta, double monto){
        Cuenta cuenta = obtenerCuenta(numeroCuenta);

        if(cuenta.getSaldo() > monto){
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            cobrar(cuenta);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    /**
     * Deposita dinero en una cuenta
     * @param numeroCuenta Cuenta en la que se quiere depositar
     * @param monto Cantidad de dinero que se quiere depositar
     */
    public void depositar(int numeroCuenta, double monto){
        Cuenta cuenta = obtenerCuenta(numeroCuenta);
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        cobrar(cuenta);
    }

    /**
     * Cobra a un cliente la cantidad de dinero correspondiente
     * @param cuenta Cuenta en la que hay que cobrar
     */
    private void cobrar(Cuenta cuenta){
        cuenta.getPropietario().pagarOperacion(cuenta);
    }

    /**
     * Devuelve el saldo total del banco
     * @return Total de saldo en las cuentas del banco
     */
    public double generarInforme(){
        double saldo = 0;

        for(Cuenta cuenta : getCuentas()){
            saldo += cuenta.getSaldo();
        }

        return saldo;
    }

    /**
     * Cambia o setea el PIN de ingreso de un cliente
     * @param cliente Cliente al que se quiere asignar el PIN
     * @param pin PIN que se quiere asignar al cliente
     */
    public void cambiarPin(Cliente cliente, int pin){
        cliente.setPin(pin);
    }
}