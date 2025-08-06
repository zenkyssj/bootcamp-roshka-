package out.production.Bootcamp;

public class Ejercicio01 {

    public static void main(String[] args) {
        int n1 = 11, n2 = 5;

        System.out.println("La suma de los numeros es: " + suma(n1, n2));
        System.out.println("La resta de los numeros es: " + resta(n1, n2));
        System.out.println("El producto de los numeros es: " + mult(n1, n2));
        System.out.println("La division de los numeros es: " + div(n1, n2));
        System.out.println("El modulo de la division es: " + mod(n1, n2));
    }

    private static int suma(int a, int b) {
        return a + b;
    }

    private static int resta(int a, int b) {
        return a - b;
    }

    private static int mult(int a, int b) {
        return a * b;
    }

    private static int div(int a, int b) {
        return a / b;
    }

    private static int mod(int a, int b) {
        return a % b;
    }
}
