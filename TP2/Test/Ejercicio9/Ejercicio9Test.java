package Ejercicio9;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Ejercicio9Test {
    Merge merge;

    @Before
    public void setUp() throws Exception {
        merge = new Merge();
    }

    @Test
    public void mergeArchivos() throws Exception {
        List<String> respuesta = new ArrayList<>();

        merge.mergeArchivos("d:\\Paradigmas_TP2_Archivo1.txt", "d:\\Paradigmas_TP2_Archivo2.txt");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\Paradigmas_TP2_Merge.txt"));
            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();

                if (line != null) {
                    respuesta.add(line);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(0 == respuesta.get(0).compareTo("asd, 1, 4"));
        assertTrue(0 == respuesta.get(1).compareTo("asdasd, 2, 5"));
    }
}