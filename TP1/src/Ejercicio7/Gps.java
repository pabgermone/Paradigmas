package Ejercicio7;

/**
 * @author Pablo Germone
 */
public class Gps {
    double tiempo;

    /**
     * Usa la velocidad constante promedio y la distancia restante para calcular el tiempo que falta para llegar a destino
     * @param velocidad Velocidad promedio (double)
     * @param distancia Distancia restante (double)
     * @return Tiempo restante para lelgar a destino
     */
    public double obtenerTiempoRestante(double velocidad, double distancia){
        tiempo = distancia/velocidad;

        tiempo = tiempo * 60;

        return tiempo;
    }
}

