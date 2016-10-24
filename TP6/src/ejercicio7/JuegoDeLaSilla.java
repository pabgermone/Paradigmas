package ejercicio7;

import java.util.Scanner;

/**
 * @author Pablo Germone
 */
public class JuegoDeLaSilla {
    private int cantidadJugadores;
    private int cantidadSillas;
    private String[] jugadores;

    private Scanner scanner = new Scanner(System.in);


    public JuegoDeLaSilla(int cantidadJugadores){
        setCantidadJugadores(cantidadJugadores);
        setJugadores(cargarJugadores());
        setCantidadSillas(cantidadJugadores - 1);
    }


    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    private void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public String[] getJugadores() {
        return jugadores;
    }

    private void setJugadores(String[] jugadores) {
        this.jugadores = jugadores;
    }

    public int getCantidadSillas() {
        return cantidadSillas;
    }

    private void setCantidadSillas(int cantidadSillas) {
        this.cantidadSillas = cantidadSillas;
    }



    private String[] cargarJugadores(){
        String nombre;
        String[] nombres = new String[getCantidadJugadores()];

        for(int i = 1; i <= getCantidadJugadores(); i++){
            System.out.println("Ingresar nombre del participante " + i + ":\n");
            nombre = scanner.nextLine();

            nombres[i - 1] = nombre;
        }

        return nombres;
    }
}