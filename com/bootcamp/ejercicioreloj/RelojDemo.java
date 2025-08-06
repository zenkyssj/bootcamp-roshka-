package com.bootcamp.ejercicioreloj;

import java.util.Scanner;;

public class RelojDemo {
    public static void main(String[] args) {

        System.out.println("Ingrese la hora en segundos: ");
        int segundos = pedirSegundos();

        Reloj reloj = new Reloj(segundos);
        System.out.println("Hora: " + reloj.toString());

        for (int i = 0; i < 10; i++) {
            reloj.tick();
            System.out.println((i + 1) + " - " + reloj.toString());
        }

        Reloj restarReloj = new Reloj(14400);

        Reloj resta = reloj.restaReloj(restarReloj);
        System.out.println("Restando " + restarReloj.toString() + " de " + reloj.toString() + ": "
                + resta.toString());

    }

    private static int pedirSegundos() {
        Scanner scanner = new Scanner(System.in);

        int segundos = scanner.nextInt();

        scanner.close();

        return segundos;
    }
}
//no cerrar el scanner en este caso porque cierra System.in