package out.production.Bootcamp;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TorosYVacas {

    public static void main(String[] args) {

        System.out.println("Intenta adivinar el numero!");
        int[] randomNumbers = generarNumero();
        // System.out.println(Arrays.toString(randomNumbers));

        adivinarElNumero(randomNumbers);

    }

    public static int[] pedirNumeroUsuario() {
        Scanner scanner = new Scanner(System.in);

        String userNumber = scanner.nextLine();

        int[] userNumberIntArray = stringToIntArray(userNumber);

        return userNumberIntArray;

    }

    public static int[] generarNumero() {
        Random random = new Random();
        int[] numeros = new int[4];
        int i = 0;

        while (i < numeros.length) {
            int numero = random.nextInt(10);
            boolean repetido = false;

            for (int j = 0; j < i; j++) {
                if (numeros[j] == numero) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido && (i != 0 || numero != 0)) {
                numeros[i] = numero;
                i++;
            }
        }

        return numeros;
    }

    public static void adivinarElNumero(int[] numberToGuess) {

        Boolean completed = false;

        int[] userNumber;
        System.out.println("Ingrese una cadena de 4 numeros.");
        userNumber = pedirNumeroUsuario();

        if (userNumber.equals(numberToGuess)) {
            System.out.println("¡Felicidades! El numero secreto era: " + Arrays.toString(numberToGuess));
        }

        do {
            int vacas = 0;
            int toros = 0;

            for (int i = 0; i < numberToGuess.length; i++) {

                if (userNumber[i] == numberToGuess[i]) {
                    toros++;
                } else {

                    for (int j = 0; j < numberToGuess.length; j++) {
                        if (i != j && userNumber[i] == numberToGuess[j]) {
                            vacas++;
                            break;
                        }
                    }
                }
            }
            System.out.println("**Vacas" + vacas);
            System.out.println("**Toros" + toros);

            if (toros == 4) {
                completed = true;
                System.out.println("¡Felicidades! El numero secreto era: " + Arrays.toString(numberToGuess));
            } else {
                System.out.println("Por favor, intente de nuevo.");
                userNumber = pedirNumeroUsuario();
            }

        } while (completed == false);

    }

    public static int[] stringToIntArray(String str) {

        String stringNuevo = str.replaceAll("[ ,]", "");
        int[] intArray = new int[stringNuevo.length()];
        for (int i = 0; i < stringNuevo.length(); i++) {
            intArray[i] = Integer.parseInt(String.valueOf(stringNuevo.charAt(i)));
        }
        return intArray;

    }
}