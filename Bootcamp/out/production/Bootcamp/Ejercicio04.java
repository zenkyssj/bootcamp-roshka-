package out.production.Bootcamp;

import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {

        System.out.println("Ingrese su nombre: ");
        String nombreUsuario = pedirNombre();

        System.out.println("Bienvenido " + nombreUsuario);
    }

    private static String pedirNombre() {
        Scanner scanner = new Scanner(System.in);

        String nombre = scanner.nextLine();

        scanner.close();

        return nombre;
    }
}
