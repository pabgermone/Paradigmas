package ejercicio5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Matriz {

    /**
     * Cambia, de una matriz, las columnas por las filas y las filas por las columnas
     * @param direccionMatriz Direccion donde se encuentra el archivo con la matriz a cambiar
     * @param direccionGuardar Direccion donde se quiere cambiar la nueva matriz
     */
    public void cambiarMatriz(String direccionMatriz, String direccionGuardar){
        int[][] matriz = leerMatriz(direccionMatriz);
        int[][] transpuesta = new int[matriz[0].length][matriz.length];

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                transpuesta[j][i] = matriz[i][j];
            }
        }

        guardarMatriz(transpuesta, direccionGuardar);
    }


    /**
     * Lee los valores de una matriz guardada en un archivo de texto
     * @param direccion Direccion del archivo donde se encuentra la matriz
     * @return Devuelve la matriz de numeros como tipo int[][]
     */
    public int[][] leerMatriz(String direccion){
        List<String> filas = new ArrayList<>();
        int[][] matriz;
        String line;

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(direccion));

            do{
                line = bufferedReader.readLine();

                if(line != null){
                    filas.add(line);
                }
            }while(line != null);

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }catch(IOException e){
            return null;
        }

        matriz = new int[filas.size()][filas.get(0).split("\\s").length];

        for(int i = 0; i < filas.size(); i++){
            String[] fila = filas.get(i).split("\\s");

            for(int j = 0; j < fila.length; j++){
                matriz[i][j] = Integer.parseInt(fila[j]);
            }
        }

        return matriz;
    }


    /**
     * Guarda una matriz en un archivo de texto
     * @param matriz Matriz a guardar
     * @param direccion Direccion en donde guardar la matriz
     */
    private void guardarMatriz(int[][] matriz, String direccion){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(direccion));
            String line;

            for(int i = 0; i < matriz.length; i++){
                line = "";

                for(int j = 0; j < matriz[0].length; j++){
                    line += matriz[i][j] + " ";

                    if(j == matriz[0].length - 1){
                        line += "\r\n";
                    }
                }

                bufferedWriter.write(line);
            }

            bufferedWriter.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
