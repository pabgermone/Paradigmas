package ejercicio3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pablo Gernmone
 */
public class ClienteTest {
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
    public void getCuentas() throws Exception {
        assertEquals(cliente.getCuentas().get(0).getNumero(), cuenta.getNumero());
    }

    @Test
    public void eliminarCuenta() throws Exception {
        cliente.eliminarCuenta(cuenta);

        assertEquals(cliente.getCuentas().size(), 0);
    }

}