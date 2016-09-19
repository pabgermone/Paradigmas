package ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Pablo Germone
 */
public class InterpreteProlog {
    private static String[][] hechos;

    public static void main(String[] args){
        hechos = getHechos("d:\\Paradigmas_TP3_Prolog.txt");

        Scanner scanner = new Scanner(System.in);
        String command;
        String[] commandSplit;

        System.out.println("Comandos:\nesHermano(nombre,nombre)\nesAbuelo(nombre,nombre)\nend\n");

        do{
            command = scanner.nextLine();
            commandSplit = command.split("[^a-zA-Z]");

            switch(commandSplit[0]){
                case("esHermano"):
                    System.out.println(esHermano(commandSplit[1], commandSplit[2]));
                    break;

                case("esAbuelo"):
                    System.out.println(esAbuelo(commandSplit[1], commandSplit[2]));
                    break;

                case("end"): break;

                default: System.out.println("Comando no valido");
            }
        }while(command.compareTo("end") != 0);
    }


    /**
     * Lee el archivo que contiene los hechos del programa
     * @param direccion Direccion del archivo
     * @return Devuelve una matriz con los hechos
     */
    private static String[][] getHechos(String direccion){
        List<String> contenido = new ArrayList<String>();
        String[][] hechosDir;
        String[] split;
        String line;

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(direccion));

            do{
                line = bufferedReader.readLine();

                if(line != null){
                    contenido.add(line);
                }
            }while(line != null);

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;

        }catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }

        if(!contenido.isEmpty()){
            hechosDir = new String[contenido.size()][3];

            for(int i = 0; i < contenido.size(); i++){
                split = contenido.get(i).split("[^a-zA-Z]");

                hechosDir[i][0] = split[0];
                hechosDir[i][1] = split[1];
                hechosDir[i][2] = split[2];
            }

            return hechosDir;
        }else{
            return null;
        }
    }


    /**
     * Revisa que una persona sea hermana de la otra
     * @param nombre1 Nombre de la primer persona
     * @param nombre2 Nombre de la segunda persona
     * @return Devuelve un boolean indicando si son hermanos
     */
    private static boolean esHermano(String nombre1, String nombre2){

        if(existe(nombre1) && existe(nombre2)){
            if((getPadre(nombre1).compareTo(getPadre(nombre2)) == 0) || (getMadre(nombre1).compareTo(getMadre(nombre2)) == 0)){
                return true;
            }else{
                return false;
            }
        }else{
            System.out.println("El nombre no existe");
            return false;
        }
    }

    /**
     * Revisa que una persona sea abuelo de otra
     * @param nombre1 Nombre de la primer persona
     * @param nombre2 Nombre de la segunda persona
     * @return Devuelve un boolean indicando si la primer persona es abuelo de la segunda
     */
    private static boolean esAbuelo(String nombre1, String nombre2){
        String padre;
        String madre;
        String abuelo1;
        String abuelo2;

        if(existe(nombre1) && existe(nombre2)){
            padre = getPadre(nombre2);
            madre = getMadre(nombre2);
            abuelo1 = getPadre(padre);
            abuelo2 = getPadre(madre);

            if((abuelo1.compareTo(nombre1) == 0) || (abuelo2.compareTo(nombre1) == 0)){
                return true;
            }else{
                return false;
            }
        }else{
            System.out.println("El nombre no existe");
            return false;
        }
    }


    /**
     * Encuentra el nombre del padre de una persona
     * @param nombre Nombre del hijo
     * @return Devuelve el nombre del padre
     */
    private static String getPadre(String nombre){
        String padre = "";

        for(int i = 0; i < hechos.length; i++){
            if((hechos[i][0].compareTo("padre") == 0) && (hechos[i][2].compareTo((nombre))) == 0){
                padre = hechos[i][1];
            }
        }

        return padre;
    }

    /**
     * Encuentra el nombre de la madre de una persona
     * @param nombre Nombre del hijo
     * @return Devuelve el nombre de la madre
     */
    private static String getMadre(String nombre){
        String madre = "";

        for(int i = 0; i < hechos.length; i++){
            if((hechos[i][0].compareTo("madre") == 0) && (hechos[i][2].compareTo((nombre))) == 0){
                madre = hechos[i][1];
            }
        }

        return madre;
    }


    /**
     * Revisa que el nombre aparezca, al menos una vez, en la base de hechos
     * @param nombre Nombre a buscar
     * @return Devuelve un boolean indicando si existe en la base
     */
    private static boolean existe(String nombre){
        boolean existe = false;

        for(int i = 0; i < hechos.length; i++){
            if((nombre.compareTo(hechos[i][1]) == 0) || (nombre.compareTo(hechos[i][2]) == 0)){
                existe = true;
            }
        }

        return existe;
    }
}