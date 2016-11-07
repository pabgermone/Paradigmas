package ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Pablo Germone
 */
public class JuegoDeLaSilla {
    private int cantidadSillas;
    private List<String> jugadores = new ArrayList<String>();

    private Scanner scanner = new Scanner(System.in);

/**
    public JuegoDeLaSilla(int cantidadJugadores){
        setJugadores(cargarJugadores(cantidadJugadores));
        setCantidadSillas(cantidadJugadores - 1);
    }
**/

    public List<String> getJugadores() {
        return jugadores;
    }

    public int getCantidadSillas() {
        return cantidadSillas;
    }

    public void setCantidadSillas(int cantidadSillas) {
        this.cantidadSillas = cantidadSillas;
    }


    /**
     * Pide los nombres de los jugadores
     * @return Lista con el nombre de todos los jugadores
     */
    private List<String> cargarJugadores(int cantidad){
        String nombre;
        List<String> nombres = new ArrayList<String>();

        for(int i = 1; i <= cantidad; i++){
            System.out.println("Ingresar nombre del participante " + i + ":\n");
            nombre = scanner.nextLine();

            nombres.add(nombre);
        }

        return nombres;
    }


    /**
     * Simula la forma en la que funciona el juego, esperando a que termine la cancion durante una cantidad de
     * segundos y eliminando alguno de los jugadores hasta qe quede uno
     */
    public void jugar(){
        int tiempo;
        String nombre;
        int ronda = 0;

        while(getCantidadSillas() > 0){
            ronda++;
            Random segundos = new Random();
            Random jugador = new Random();

            tiempo = segundos.nextInt(31) * 1000;
            nombre = getJugador(jugador.nextInt(getJugadores().size()));

            System.out.println("*Musica*");

            try{
                Thread.sleep(tiempo);
            }catch(Exception ex){
                System.out.println("Error en tiempo de espera");
            }

            System.out.println("Ronda " + ronda + ": La musica sono " + tiempo/1000 + " segundos y perdio " + nombre);

            eliminarJugador(nombre);
            setCantidadSillas(getCantidadSillas() - 1);
        }

        System.out.println("El ganador es: " + getGanador());
    }


    /**
     * Obtiene el nombre del jugador guardado en cierto indice de la lista
     * @param indice Posicion en  la que esta guardado el jugador en la lista
     * @return Nombre del jugador deseado
     */
    public String getJugador(int indice){
        return getJugadores().get(indice);
    }

    /**
     * Quita u jugador de la lista
     * @param nombre Nombre del jugador que se quiere eliminar
     */
    public void eliminarJugador(String nombre){
        getJugadores().remove(nombre);
    }


    /**
     * Devuelve el jugador ganador del juego
     * @return Nombre del jugador que gano
     */
    public String getGanador(){
        if(getJugadores().size() == 1){
            return getJugadores().get(0);
        }else{
            return "Hubo un empate";
        }
    }
}