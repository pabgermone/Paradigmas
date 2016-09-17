package ejercicio5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class Ejercicio5Test {
    Matriz matriz;

    String direccionMatriz = "d:\\Paradigmas_TP3_Matriz.txt";
    String direccionGuardado = "d:\\Paradigmas_TP3_Transpuesta.txt";

    @Before
    public void setUp() throws Exception {
        matriz = new Matriz();
    }

    @Test
    public void numeroFilas() throws Exception {
        matriz.cambiarMatriz(direccionMatriz, direccionGuardado);

        int[][] original = matriz.leerMatriz(direccionMatriz);
        int[][] transpuesta = matriz.leerMatriz(direccionGuardado);

        assertTrue(transpuesta.length == original[0].length);
    }

    @Test
    public void numeroColumnas() throws Exception{
        matriz.cambiarMatriz(direccionMatriz, direccionGuardado);

        int[][] original = matriz.leerMatriz(direccionMatriz);
        int[][] transpuesta = matriz.leerMatriz(direccionGuardado);

        assertTrue(transpuesta[0].length == original.length);
    }

    @Test
    public void contenido() throws Exception{
        matriz.cambiarMatriz(direccionMatriz, direccionGuardado);

        int[][] original = matriz.leerMatriz(direccionMatriz);
        int[][] transpuesta = matriz.leerMatriz(direccionGuardado);

        for(int i = 0; i < transpuesta.length; i++){
            for(int j = 0; j < transpuesta[0].length; j++){
                assertTrue(transpuesta[i][j] == original[j][i]);
            }
        }
    }
}