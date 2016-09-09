package ejercicio3;

/**
 * @author Pablo Germone
 */
public class Verificador {

    public boolean verifMail(String mail){
        String patron = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if(mail.matches(patron)){
            return true;
        }else{
            return false;
        }
    }
}
