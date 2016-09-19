package Ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Pablo Germone
 */
public class Clasificador {

    /**
     * Toma un grupo de numeros, los clasifica en primos, divisores de 3000, pares, impares y los guarda en diferentes archivos
     * @param numeros Array de numeros a clasificar
     */
    public void clasificarNumeros(int[] numeros){
        String numPrimos = "";
        String numDivisores = "";
        String promedios;

        List<Integer> pares = new ArrayList<Integer>();
        List<Integer> impares = new ArrayList<Integer>();


        for(int i = 0; i < numeros.length; i++){
            if(primos(numeros[i])){
                numPrimos += numeros[i] + " ";
            }

            if(divisores(numeros[i])){
                numDivisores += numeros[i] + " ";
            }

            if(par(numeros[i])){
                pares.add(numeros[i]);
            }else{
                impares.add(numeros[i]);
            }
        }

        promedios = "Promedio de numeros pares: " + promedio(pares) + " Promedio de numeros impares: " + promedio(impares);

        guardar(numPrimos, "d:\\Paradigmas_TP2_Ej5_Primos.txt");
        guardar(numDivisores, "d:\\Paradigmas_TP2_Ej5_Divisores3000.txt");
        guardar(promedios, "d:\\Paradigmas_TP2_Ej5_Promedios.txt");
    }


    /**
     * Indica si un entero es primo o no
     * @param numero entero a revisar
     * @return boolean indicando si es primo
     */
    public boolean primos(int numero){
        boolean primo = true;

        if(numero >= 2){
            for(int i = 2; i != numero; i++){
                if(numero % i == 0){
                    primo = false;
                }
            }
        }else{
            primo = false;
        }

        return primo;
    }


    /**
     * Indica si un entero es divisor de 3000
     * @param numero Entero a revisar
     * @return boolean indicando si es divisor de 3000
     */
    public boolean divisores(int numero){
        boolean divisor = true;

        if(3000 % numero != 0){
            divisor = false;
        }

        return divisor;
    }


    /**
     * Indica si un entero es par o no
     * @param numero Entero a revisar
     * @return boolean indicando si es par
     */
    public boolean par(int numero){
        boolean par = true;

        if(numero % 2 != 0){
            par = false;
        }

        return par;
    }


    /**
     * Toma una lista de enteros y devuelve su promedio
     * @param numeros Lista con enteros para calcular
     * @return Promedio de la lista
     */
    public int promedio(List<Integer> numeros){
        int prom;
        int sum = 0;

        for(int i = 0; i < numeros.size(); i++){
            sum += numeros.get(i);
        }

        prom = sum / numeros.size();

        return prom;
    }


    /**
     * Escribe un String en un archivo
     * @param contenido String a escribir
     * @param archivo Direccion donde se encuentra o donde se quiere crear el archivo que contendra el String
     */
    public void guardar(String contenido, String archivo){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo));
            bufferedWriter.write(contenido);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}