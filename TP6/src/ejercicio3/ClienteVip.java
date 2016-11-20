package ejercicio3;


/**
 * @author Pablo Germone
 */
public class ClienteVip extends Cliente {
    private boolean deCapital;


    private void setDeCapital(boolean capital){
        deCapital = capital;
    }

    public boolean isDeCapital(){
        return deCapital;
    }


    public ClienteVip(String nombre, String apellido, int dni, boolean capital, Banco banco){
        super(nombre, apellido, dni, banco);
        setDeCapital(capital);
    }


    @Override
    public void pagarOperacion(Cuenta cuenta){
        if(this.isDeCapital()){
            cuenta.setSaldo(cuenta.getSaldo() - 2);
        }
    }

}
