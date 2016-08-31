package Ejercicio7;

public class Gps {
    double tiempo;

    public double obtenerTiempoRestante(double velocidad, double distancia){
        tiempo = distancia/velocidad;

        tiempo = tiempo * 60;

        return tiempo;
    }
}
