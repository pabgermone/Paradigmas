package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private boolean vip = false;
    private boolean capital;
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();


    public Cliente(String nombre, String apellido, boolean capital){
        setNombre(nombre);
        setApellido(apellido);
        setCapital(capital);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
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
}
