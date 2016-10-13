package ejercicio3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Germone
 */
public class BancoTest {
    Banco banco;
    Cliente cliente;
    Cuenta cuenta;

    @Before
    public void setUp() throws Exception {
        banco = new Banco();
        cliente = new Cliente("Pablo", "Germone", 123, false, false, banco);
        cuenta = new Cuenta(123, cliente, banco);
    }

    @Test
    public void obtenerCuenta() throws Exception {
        assertEquals(banco.obtenerCuenta(123).getPropietario().getNombre().compareTo("Pablo"), 0);
    }

    @Test
    public void extraer() throws Exception {
        banco.depositar(123, 106);
        banco.extraer(123, 10);

        assertTrue(cuenta.getSaldo() == 84.0);
    }

    @Test
    public void depositar() throws Exception {
        banco.depositar(123, 106);

        assertTrue(cuenta.getSaldo() == 100.0);
    }

    @Test
    public void generarInforme() throws Exception {
        Cuenta cta = new Cuenta(111, cliente, banco);

        banco.depositar(111, 106);
        banco.depositar(123, 106);

        assertTrue(banco.generarInforme() == 200.0);
    }

    @Test
    public void cambiarPin() throws Exception {
        banco.cambiarPin(cliente, 100);

        assertEquals(cliente.getPin(), 100);
    }

}