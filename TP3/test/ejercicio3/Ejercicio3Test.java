package ejercicio3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio3Test {
    Verificador verificador;

    @Before
    public void setUp() throws Exception {
        verificador = new Verificador();
    }

    @Test
    public void verifMail() throws Exception {
        assertTrue(verificador.verifMail("pabgermone@gmail.com"));
        assertTrue(!verificador.verifMail("asd12asd13a1d321"));
        assertTrue(!verificador.verifMail("asdasdasd@12a3sd1a23sd1"));
    }

}