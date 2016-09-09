package ejercicio3;

/**
 * @author Pablo Germone
 */
public class Verificador {

    /**
     * Verifica que una direccion de e-mail sea valida
     * @param mail direccion a verificar
     * @return boolean indicando si es valida
     */
    public boolean verifMail(String mail){
        String patron = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if(mail.matches(patron)){
            return true;
        }else{
            return false;
        }
    }
}
