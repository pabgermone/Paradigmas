package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private int dni;
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();
    private int pin;


    public Cliente(String nombre, String apellido, int dni, Banco banco){
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        banco.agregarCliente(this);
    }


    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    /**
     * Asocia una cuenta al cliente
     * @param cuenta Cuenta a asignar
     */
    public void agregarCuenta(Cuenta cuenta){
        getCuentas().add(cuenta);
    }


    /**
     * Elimina una de las cuentas del cliente
     * @param cuenta Cuenta a eliminar
     */
    public void eliminarCuenta(Cuenta cuenta){
        for(int i = 0; i < getCuentas().size(); i++){
            if(getCuentas().get(i).getNumero() == cuenta.getNumero()){
                getCuentas().remove(i);
            }
        }
    }


    /**
     * Paga cualquier operacion realizada en un banco
     * @param cuenta Cuenta de la que se descuenta el monto de la operacion
     */
    public void pagarOperacion(Cuenta cuenta){
        cuenta.setSaldo(cuenta.getSaldo() - 6);
    }
}
