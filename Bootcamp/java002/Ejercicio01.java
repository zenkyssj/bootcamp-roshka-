package java002;

import java.util.Random;

public class Ejercicio01 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[10];
        int mayor = 0;

        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt(-5, 5);
            array[i] = randomNumber;
        }

        for (int number : array) {
            System.out.println(number);

            if (number > mayor) {
                mayor = number;
            }
        }

        System.out.println("El mayor elemento del vector es: " + mayor);
    }

}
