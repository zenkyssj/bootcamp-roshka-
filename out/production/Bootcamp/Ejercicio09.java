package out.production.Bootcamp;

import java.util.Scanner;

public class Ejercicio09 {

    private static final String randomPass = "bootcampRoshka@";
    private static boolean acertado = false;

    public static void main(String[] args) {

        int contadorIntentos = 1;

        System.out.println("Ingrese la contraseña (" + contadorIntentos + "/3 intentos)");
        String userPass = pedirConstraseña();
        do {

            comprobarContraseña(userPass);

            if (acertado)
                break;

            if (!acertado) {
                contadorIntentos++;
                System.out.println("Intente otra vez (" + (contadorIntentos) + " / 3 intentos) ");
                userPass = pedirConstraseña();
            }

        } while (contadorIntentos < 3);

        if (contadorIntentos == 3) {
            System.out.println("Fallaste jaja!!");
        }
    }

    private static String pedirConstraseña() {
        Scanner scanner = new Scanner(System.in);

        String contraseña = scanner.nextLine();

        return contraseña;
    }

    private static void comprobarContraseña(String contraseña) {
        if (contraseña.equals(randomPass)) {
            acertado = true;
        }
    }
}
