package ejercicio4_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Pablo Germone
 */
public class Ahorcado {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args){

        int random = new Random().nextInt(5);

        Map<Integer, String> palabras = obtenerPalabras("d:\\Paradigmas_TP3_Ahorcado.txt");
        String palabra = palabras.get(random);


        jugar(palabra);
    }


    /**
     *  Contiene toda la logica del juego
     * @param palabra Es la palabra qe debe adivinar el jugador
     */
    private static void jugar(String palabra){
        int intentos = 5;
        boolean valido;
        boolean completo = false;

        String descubierto = "";
        String letra;


        for(int i = 0; i < palabra.length(); i++){
            descubierto += "-";
        }

        while((intentos != 0) && (!completo)){
            System.out.println("Intentos restantes: " + intentos);
            System.out.println(descubierto);
            System.out.println("Elija una letra: ");

            do{
                letra = scanner.next();

                if(letra.length() == 1){
                    if(!Character.isLetter(letra.charAt(0))) {
                        System.out.println("Elija una LETRA: ");
                    }
                }else{
                    System.out.print("Elija UNA letra: ");
                }
            }while((!Character.isLetter(letra.charAt(0))) || (letra.length() != 1));

            valido = false;

            for(int i = 0; i < palabra.length(); i++){
                if(letra.compareTo(palabra.substring(i, (i + 1))) == 0){
                    descubierto = reemplazar(descubierto, letra, i);
                    valido = true;
                }
            }

            if(revisar(descubierto)){
                completo = true;
            }else if(!valido){
                intentos--;
            }
        }

        System.out.println(descubierto);

        if(intentos == 0){
            System.out.println("Perdiste:, la palabra era " + palabra);
        }else{
            System.out.println("Ganaste!!");
        }
    }


    /**
     * Cambia el "-" en la palabra adivinada por la letra que fue ingresada por el usuario
     * @param palabra String en el que se quiere reemplazar la letra
     * @param reemplazo Letra con la que se quiere reemplazar
     * @param index Posicion de la letra que se quiere reemplazar
     * @return Devuelve el String con la letra reemplazada
     */
    private static String reemplazar(String palabra, String reemplazo, int index){
        return palabra.substring(0, index) + reemplazo + palabra.substring((index + 1));
    }


    /**
     * Revisa que la palabra haya sido adivinada por completo
     * @param palabra String que contiene las letras que se adivinaron hasta el momento
     * @return Devuelve un boolean indicando si la palabra fue adivinada completamente
     */
    private static boolean revisar(String palabra){
        int letras = 0;

        for(int i = 0; i < palabra.length(); i++){
            if(Character.isLetter(palabra.charAt(i))){
                letras++;
            }
        }

        return palabra.length() == letras;
    }


    /**
     * Lee el archivo y crea un HashMap con las palabras que puede elegir el programa
     * @param archivo Direccion del archivo que contiene las palabras
     * @return Devuelve el HashMap con las palabras
     */
    private static Map<Integer, String> obtenerPalabras(String archivo){
        Map<Integer, String> mapa = new HashMap<>();

        List<String> contenido = new ArrayList<>();
        String[] palabras;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();

                if(line != null){
                    contenido.add(line);
                }
            }

            for(String linea : contenido){
                palabras = linea.split(", ");

                mapa.put(Integer.parseInt(palabras[0]), palabras[1]);
            }

            return mapa;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
