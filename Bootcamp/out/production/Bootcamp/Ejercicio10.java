package out.production.Bootcamp;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        System.out.println("Seleccione un dia laboral: ");
        System.out.println(" 1) Lunes\n 2)Martes\n 3)Miercoles\n 4)Jueves\n 5)Viernes\n 6)Sabado\n 7)Domingo");

        Scanner scanner = new Scanner(System.in);

        int dia = scanner.nextInt();

        switch (dia) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Es un dia laboral.");
                break;
            case 6:
            case 7:
                System.out.println("No es un dia laboral.");
                break;
            default:
                System.out.println("Opcion incorrecta.");
                break;
        }

        scanner.close();
    }
}
