package out.production.Bootcamp;

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        System.out.println("Ingrese el precio del producto: ");
        float precioUsuario = pedirPrecio();
        float precioFinal = precioFinal(precioUsuario);

        System.out.println("Precio final del producto: " + precioFinal);
    }

    private static float pedirPrecio() {
        Scanner scanner = new Scanner(System.in);

        float precio = scanner.nextFloat();

        scanner.close();

        return precio;
    }

    private static float precioFinal(float precio) {
        final float iva = 0.1f;

        return precio - (precio * iva);
    }
}
