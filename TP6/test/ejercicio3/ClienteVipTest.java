package ejercicio3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteVipTest {
    Banco banco;
    ClienteVip cliente;
    ClienteVip cliente2;
    Cuenta cuenta;
    Cuenta cuenta2;

    @Before
    public void setUp() throws Exception {
        banco = new Banco();
        cliente = new ClienteVip("Pablo", "Germone", 123, true, banco);
        cliente2 = new ClienteVip("Pablo", "Germone", 123, false, banco);
        cuenta = new Cuenta(123, cliente, banco);
        cuenta2 = new Cuenta(456, cliente2, banco);
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

    @Test
    public void pagarOperacion() throws Exception{
        cuenta.setSaldo(10);
        cliente.pagarOperacion(cuenta);

        assertTrue(cliente.getCuentas().get(0).getSaldo() == 8);

        cuenta2.setSaldo(10);
        cliente2.pagarOperacion(cuenta2);

        assertTrue(cliente2.getCuentas().get(0).getSaldo() == 10);
    }
}