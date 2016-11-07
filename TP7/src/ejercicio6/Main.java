package ejercicio6;

/**
 * @author Pablo Germone
 */
public class Main {
    public static void main(String[] args){
        Ticket ticket = new Ticket();

        ticket.setTipoLocalidad(Teatro.tipoLocalidad.adelante);

        System.out.println(ticket);
    }
}
