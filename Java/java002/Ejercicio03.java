package java002;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        System.out.println("Escribe una palabra o frase: ");
        String inputUser = pedirPalabra();

        if (esPalindrome(inputUser)) {
            System.out.println("\nLa palabra es palindrome.");
        } else {
            System.out.println("\nLa palabra no es palindrome.");
        }

    }

    private static String pedirPalabra() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        scanner.close();

        return input;
    }

    public static boolean esPalindrome(String str) {

        String strTemp = str.toLowerCase().replaceAll("[^A-Za-z0-9]+", "");

        String reversed = new StringBuilder(str).reverse().toString().toLowerCase().replaceAll("[^A-Za-z0-9]+", "");

        System.out.println("\nPalabra/frase original: " + strTemp);
        System.out.println("Palabra/frase del reves: " + reversed);

        if (strTemp.equals(reversed))
            return true;

        return false;
    }
}
