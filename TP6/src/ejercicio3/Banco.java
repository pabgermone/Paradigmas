package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Banco {
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();


    public List<Cuenta> getCuentas(){
        return cuentas;
    }

    public Cuenta obtenerCuenta(int numeroCuenta){
        Cuenta cuenta = null;

        for(Cuenta cta : getCuentas()){
            if(numeroCuenta == cta.getNumero()){
                cuenta = cta;
            }
        }

        return cuenta;
    }

    public void extraer(int numeroCuenta, double monto){
        Cuenta cuenta = obtenerCuenta(numeroCuenta);

        if(cuenta.getSaldo() > monto){
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            cobrar(cuenta);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositar(int numeroCuenta, double monto){
        Cuenta cuenta = obtenerCuenta(numeroCuenta);
        cobrar(cuenta);
    }

    private void cobrar(Cuenta cuenta){
        Cliente propietario = cuenta.getPropietario();

        if(propietario.isVip() && propietario.isCapital()){
            cuenta.setSaldo(cuenta.getSaldo() - 6);
        }else if(!propietario.isVip()){
            cuenta.setSaldo(cuenta.getSaldo() - 2);
        }
    }

    public double generarInforme(){
        double saldo = 0;

        for(Cuenta cuenta : getCuentas()){
            saldo += cuenta.getSaldo();
        }

        return saldo;
    }
}
