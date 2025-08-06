package out.production.Bootcamp;

import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        System.out.println("Ingrese un numero: ");
        int numero = leerNumero();

        calcularDivisible(numero);
    }

    private static int leerNumero() {
        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();

        scanner.close();

        return numero;
    }

    private static void calcularDivisible(int numero) {

        if (numero % 2 == 0) {
            System.out.println("El numero es divisible entre 2.");
        } else {
            System.out.println("El numero no es divisible entre 2.");
        }
    }
}
