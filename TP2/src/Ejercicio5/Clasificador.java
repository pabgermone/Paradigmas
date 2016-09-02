package Ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Clasificador {

    public void clasificarNumeros(int[] numeros){
        String numPrimos = "";
        String numDivisores = "";
        String promedios;

        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();


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


    public boolean divisores(int numero){
        boolean divisor = true;

        if(3000 % numero != 0){
            divisor = false;
        }

        return divisor;
    }


    public boolean par(int numero){
        boolean par = true;

        if(numero % 2 != 0){
            par = false;
        }

        return par;
    }


    public int promedio(List<Integer> numeros){
        int prom;
        int sum = 0;

        for(int i = 0; i < numeros.size(); i++){
            sum += numeros.get(i);
        }

        prom = sum / numeros.size();

        return prom;
    }


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