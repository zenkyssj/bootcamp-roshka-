package java002;

import java.util.Arrays;

public class Ejercicio04 {
    public static void main(String[] args) {
        String string = "82838821772";

        int[] arrayDeString = crearArray(string);

        System.out.println(Arrays.toString(arrayDeString));
    }

    private static int[] crearArray(String str) {
        int[] array = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            array[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return array;
    }
}
