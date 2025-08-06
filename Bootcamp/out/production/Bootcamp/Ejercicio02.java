package out.production.Bootcamp;

public class Ejercicio02 {
    public static void main(String[] args) {
        int n1 = 23, n2 = 8;

        comprobarMayor(n1, n2);
    }

    private static void comprobarMayor(int a, int b) {

        if (a > b) {
            System.out.println("El mayor es: " + a);
        } else if (a < b) {
            System.out.println("El mayor es: " + b);
        } else {
            System.out.println("Los numeros son iguales.");
        }
    }
}
