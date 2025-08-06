package com.bootcamp.ejercicionim;

import java.util.Scanner;

public class Nim {

    private static GameHandler gameHandler = new GameHandler();
    private static boolean isWinner = false;
    private static int cont = 0;

    public static void main(String[] args) {

        String player1, player2, activePlayer, inactivePlayer = "";
        System.out.print("Jugador 1, ingrese su nombre: ");
        player1 = getNombreJugador();

        System.out.print("\nJugador 2, ingrese su nombre: ");
        player2 = getNombreJugador();

        gameHandler.showPilas();

        while (!isWinner) {
            cont++;
            if (cont % 2 == 0) {
                activePlayer = player1;
                inactivePlayer = player2;
                manageTurns(activePlayer);
            } else {
                activePlayer = player2;
                inactivePlayer = player1;
                manageTurns(activePlayer);
            }
        }

        System.out.println(inactivePlayer + ", ya no quedan contadores, asi que.... Ganaste!");

    }

    private static String getNombreJugador() {
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();

        return playerName;
    }

    private static void manageTurns(String player) {
        System.out.print("\n" + player + ", elija una pila: ");
        String pila = selectPila();

        System.out.print("Cuantos quitara de la pila '" + pila + "': ");
        int amountToDecrease = selectAmount();

        gameHandler.deletePila(pila, amountToDecrease);

        isWinner = gameHandler.isWinner();

        gameHandler.showPilas();

    }

    private static String selectPila() {
        Scanner scanner = new Scanner(System.in);

        String pilaSelected = scanner.nextLine();

        return pilaSelected;
    }

    private static int selectAmount() {
        Scanner scanner = new Scanner(System.in);

        int amount = scanner.nextInt();

        return amount;
    }

}
