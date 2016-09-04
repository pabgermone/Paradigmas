package Ejercicio9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Merge {

    public void mergeArchivos(String dir1, String dir2){
        String[][] archivo1 = leerArchivo(dir1);
        String[][] archivo2 = leerArchivo(dir2);

        List<String> archivo3 = new ArrayList<>();
        //String[][] archivo3;

        for(int i = 0; i < archivo1.length; i++){
            for(int j = 0; j < archivo2.length; j++){
                if(archivo1[i][0].equals(archivo2[j][0])){
                    archivo3.add(archivo1[i][0] + ", " + archivo1[i][1] + ", " + archivo2[j][1]);
                }
            }
        }

        //archivo3 = listToArray(listMerge);
        guardar(archivo3, "d:\\Paradigmas_TP2_Merge.txt");
    }


    public String[][] leerArchivo(String direccion){
        List<String> listaContenido = new ArrayList<>();
        String[][] contenido;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(direccion));
            String line = "";// = bufferedReader.readLine();

            while (line != null) {
                line = bufferedReader.readLine();

                if(line != null){
                    listaContenido.add(line);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        contenido = listToArray(listaContenido);

        return contenido;
    }


    public void guardar(List<String> contenido, String archivo){
        String merge = "";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo));

            for(int i = 0; i < contenido.size(); i++){
                merge += contenido.get(i) + "\r\n";
            }

            bufferedWriter.write(merge);

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String[][] listToArray(List<String> lista){
        String[][] contenido = new String[lista.size()][2];
        String[] linea;

        for(int i = 0; i < lista.size(); i++){
            linea = lista.get(i).split(", ");

            contenido[i][0] = linea[0];
            contenido[i][1] = linea[1];
            /*if(linea.length == 3){
                contenido[i][3] = linea[2];
            }*/
        }

        return contenido;
    }
}
