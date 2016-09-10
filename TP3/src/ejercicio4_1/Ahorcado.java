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

    public static void main(String[] args){
        int random = new Random().nextInt(5);

        Map<Integer, String> palabras = obtenerPalabras("d:\\Paradigmas_TP3_Ahorcado.txt");
        String palabra = palabras.get(random);

        jugar(palabra);
    }




    public static void jugar(String palabra){
        int l = 1;
        int c = 0;
        int intentos = 5;

        String descubierto = "";
        Character letra = ' ';

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < palabra.length(); i++){
            descubierto += "-";
        }

        while(intentos != 0){
            System.out.println("Intentos restantes: " + intentos);
            System.out.println(descubierto);
            System.out.println("Elija una letra: ");

            while(l == 1){
                if(scanner.next().length() == 1){
                    if(Character.isLetter(scanner.next().charAt(0))){
                        letra = scanner.next().charAt(0);
                        l = 0;
                    }else{
                        System.out.println("Elija una LETRA: ");
                    }
                }else{
                    System.out.print("Elija UNA letra: ");
                }
            }


            for(int i = 0; i < palabra.length(); i++){
                if(Character.compare(letra, palabra.charAt(i)) == 0){

                }
            }
        }
    }



    public static Map<Integer, String> obtenerPalabras(String archivo){
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
