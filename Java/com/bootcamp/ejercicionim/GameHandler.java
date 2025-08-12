package com.bootcamp.ejercicionim;

public class GameHandler {
    private int pilaA = 0;
    private int pilaB = 0;
    private int pilaC = 0;

    public GameHandler() {
        pilaA = 3;
        pilaB = 4;
        pilaC = 5;
    }

    public void deletePila(String opc, int amount) {

        switch (opc) {
            case "A":
                pilaA = amountChecker(pilaA, amount);
                break;
            case "B":
                pilaB = amountChecker(pilaB, amount);
                break;
            case "C":
                pilaC = amountChecker(pilaC, amount);
                break;
            default:
                break;
        }

    }

    public void showPilas() {

        System.out.println("\nA: " + pilaA + "\tB: " + pilaB + "\tC: " + pilaC);
    }

    public boolean isWinner() {

        return pilaA == 0 && pilaB == 0 && pilaC == 0;
    }

    private int amountChecker(int pila, int amount) {
        if (pila < amount) {
            System.out.println("Cantidad invalida, saltando turno...");
            return pila;
        }

        return pila - amount;

    }
}
