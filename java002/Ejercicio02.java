package java002;

import java.util.ArrayList;
import java.util.Random;

public class Ejercicio02 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[100];
        int masRepetido = 0;
        ArrayList<Integer> contadorAusentes = new ArrayList<>();
        int maxFrecuencia = 0;

        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt(-30, 30);

            array[i] = randomNumber;
        }

        for (int number : array) {
            System.out.println(number);

        }

        for (int i = -30; i <= 30; i++) {
            int contadorElemento = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    contadorElemento++;
                }
            }
            if (contadorElemento > maxFrecuencia) {
                maxFrecuencia = contadorElemento;
                masRepetido = i;
            }

            if (contadorElemento == 0) {
                contadorAusentes.add(i);
            }

        }

        System.out.println("El elemento que mas veces se repite: " + masRepetido);

        if (contadorAusentes.size() != 0) {
            System.out.println("Los numeros que no estan presentes son: ");
            contadorAusentes.forEach((n) -> System.out.print(n + ", "));
        }

    }
}
