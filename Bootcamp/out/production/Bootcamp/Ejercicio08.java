package out.production.Bootcamp;

import java.util.Scanner;

public class Ejercicio08 {

    private static boolean completed = false;

    public static void main(String[] args) {
        System.out.println("Ingrese un numero: ");
        int numero = leerNumero();

        do {
            comprobarNumero(numero);
            if (completed)
                break;

            if (!completed) {
                System.out.println("Ingrese otro numero: ");
                numero = leerNumero();
            }

        } while (true);

    }

    private static int leerNumero() {
        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();

        // scanner.close();

        return numero;
    }

    private static void comprobarNumero(int numero) {

        if (numero >= 0) {
            completed = true;
        } else {
            completed = false;
        }
    }
}
