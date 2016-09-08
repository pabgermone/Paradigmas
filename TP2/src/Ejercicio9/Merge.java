package Ejercicio9;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pablo Germone
 */
public class Merge {

    /**
     * Merge de dos archivos de texto en uno donde solo se encuentren los valores de claves repetidas
     * @param dir1 Directorio donde se encuentra el primer archivo
     * @param dir2 Directorio donde se encuentra el segundo archivo
     * @param dir3 Directorio en el que se guardara el archivo resultante
     */
    public void mergeArchivos(String dir1, String dir2, String dir3){
        Map<String, String> archivo1 = leerArchivo(dir1);
        Map<String, String> archivo2 = leerArchivo(dir2);
        Map<String, String> archivo3 = new HashMap<>();

        String value;

        for(String key : archivo1.keySet()){
            if(archivo2.containsKey(key)){
                if((archivo1.get(key) != null) && (archivo2.get(key) != null)){
                    value = archivo1.get(key) + ", " + archivo2.get(key);

                    archivo3.put(key, value);
                }
            }
        }

        guardar(archivo3, dir3);
    }


    /**
     * Lee un archivo y devuelve un Map con su contenido
     * @param direccion Directorio del archivo a leer
     * @return Map con el contenido del archivo
     */
    public Map<String, String> leerArchivo(String direccion){
        Map<String, String> archivo = new HashMap<>();

        List<String> contenido = new ArrayList<>();
        String[] palabras;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(direccion));
            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();

                if(line != null){
                    contenido.add(line);
                }
            }

            for(String linea : contenido){
                palabras = linea.split(", ");

                archivo.put(palabras[0], palabras[1]);
            }

            return archivo;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Guarda en un archivo el contenido de un Map
     * @param archivo Map que se quiere guardar
     * @param dir Directorio donde se guardara el archivo
     */
    public void guardar(Map<String, String> archivo, String dir){
        String contenido = "";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dir));

            for(String key : archivo.keySet()){
                contenido += key + ", " + archivo.get(key) + "\r\n";
            }

            bufferedWriter.write(contenido);

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
