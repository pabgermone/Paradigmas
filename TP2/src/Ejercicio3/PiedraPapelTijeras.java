package Ejercicio3;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Pablo Germone
 */
public class PiedraPapelTijeras {

    public static void main(String[] args){
        int random;
        int valor = 0;
        int g = 1;
        String rta = "";
        String resultado = "";
        String opcion;
        Scanner scanner = new Scanner(System.in);


        while(g == 1){
            int f = 0;

            while(f == 0){
                System.out.println("Elija una opcion:\n.PIEDRA\n.PAPEL\n.TIJERAS");
                opcion = scanner.next();

                if(opcion.equals("PIEDRA")){
                    valor = 0;
                    f = 1;
                }else if(opcion.equals("PAPEL")){
                    valor = 1;
                    f = 1;
                }else if(opcion.equals("TIJERAS")){
                    valor = 2;
                    f = 1;
                }else{
                    System.out.println("Elija una opcion valida");
                }
            }

            random = new Random().nextInt(3);

            switch(valor) {
                case 0:
                    if(random == 0){
                        System.out.println("PC: PIEDRA");
                        resultado = "Empate";
                    }else if(random == 1){
                        System.out.println("PC: PAPEL");
                        resultado = "Perdiste";
                    }else if(random == 2){
                        System.out.println("PC: TIJERAS");
                        resultado = "Ganaste";
                    }
                    break;

                case 1:
                    if(random == 0){
                        System.out.println("PC: PIEDRA");
                        resultado = "Ganaste";
                    }else if(random == 1){
                        System.out.println("PC: PAPEL");
                        resultado = "Empate";
                    }else if(random == 2){
                        System.out.println("PC: TIJERAS");
                        resultado = "Perdiste";
                    }
                    break;

                case 2:
                    if(random == 0){
                        System.out.println("PC: PIEDRA");
                        resultado = "Perdiste";
                    }else if(random == 1){
                        System.out.println("PC: PAPEL");
                        resultado = "Ganaste";
                    }else if(random == 2){
                        System.out.println("PC: TIJERAS");
                        resultado = "Empate";
                    }
                    break;
            }

            System.out.println(resultado + "\n\nVolver a jugar?:\n.SI\n.NO");
            rta = scanner.next();

            int x = 0;

            while(x == 0){
                if(rta.equals("NO")){
                    g = 0;
                    x = 1;
                }else if(rta.equals("SI")){
                    x = 1;
                }else{
                    System.out.println("Elija una opcion valida:\n.SI\n.NO");
                    rta = scanner.next();
                }
            }
        }
    }
}