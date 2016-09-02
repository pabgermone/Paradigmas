package Ejercicio5;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Ejercicio5Test {
    Clasificador clasif;

    public int[] leerNumeros(String archivo){
        List<Integer> listaNumeros = new ArrayList<>();

        String contenido = "";
        String[] strNumeros;

        boolean numerico = true;


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            String line = "";// = bufferedReader.readLine();

            while (line != null) {
                line = bufferedReader.readLine();

                if(line != null){
                    contenido += line;
                }
            }

            strNumeros = contenido.split("\\s+");

            for(int i = 0; i < strNumeros.length; i++){
                for(int j = 0; j < strNumeros[i].length(); j++){
                    if(!Character.isDigit(strNumeros[i].charAt(j))){
                        numerico = false;
                    }else{
                        numerico = true;
                    }
                }

                if(numerico){
                    listaNumeros.add(Integer.parseInt(strNumeros[i]));
                }
            }

            return listToArray(listaNumeros);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public int[] listToArray(List<Integer> lista){
        int[] resultado = new int[lista.size()];

        for(int i = 0; i < resultado.length; i++){
            resultado[i] = lista.get(i);
        }

        return resultado;
    }


    @Before
    public void setUp() throws Exception {
        clasif = new Clasificador();
    }

    @Test
    public void clasificarNumeros() throws Exception {
        int[] numeros = {1, 4, 7, 13, 19, 2, 3};
        int[] primos;
        int[] divisores;
        int[] promedios;

        int[] primosEsp = {7, 13, 19, 2, 3};
        int[] divisoresEsp = {1, 4, 2, 3};
        int[] promediosEsp = {3, 8};

        clasif.clasificarNumeros(numeros);

        primos = leerNumeros("d:\\Paradigmas_TP2_Ej5_Primos.txt");
        divisores = leerNumeros("d:\\Paradigmas_TP2_Ej5_Divisores3000.txt");
        promedios = leerNumeros("d:\\Paradigmas_TP2_Ej5_Promedios.txt");

        assertArrayEquals(primosEsp, primos);
        assertArrayEquals(divisoresEsp, divisores);
        assertArrayEquals(promediosEsp, promedios);
    }

    @Test
    public void primos() throws Exception {
        assertTrue(clasif.primos(7));
    }

    @Test
    public void divisores() throws Exception {
        assertTrue(clasif.divisores(3));
    }

    @Test
    public void par() throws Exception {
        assertTrue(clasif.par(2));
        assertTrue(!clasif.par(3));
    }

    @Test
    public void promedio() throws Exception {
        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(4);

        assertEquals(3, clasif.promedio(lista));
    }

}