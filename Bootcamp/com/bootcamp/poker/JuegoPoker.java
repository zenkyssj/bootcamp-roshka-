package com.bootcamp.poker;

import java.util.ArrayList;

public class JuegoPoker {
    public static void main(String[] args) {

        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta("2H"));
        cartas.add(new Carta("5D"));
        cartas.add(new Carta("7S"));
        cartas.add(new Carta("9C"));
        cartas.add(new Carta("QH"));

        Poker poker = new Poker(cartas);

        poker.combinationManager();

        System.out.println("\nProbabilidad de obtener Escalera de Color: 0.00154%");
        System.out.println("Probabilidad de obtener Poker: 0.0240%");
        System.out.println("Probabilidad de obtener Full House: 0.1441%0");
        System.out.println("Probabilidad de obtener Escalera: 0.3925%");
        System.out.println("Probabilidad de obtener: Trio 2.1128%");
        System.out.println("Probabilidad de obtener Doble Par: 4.7539% ");
        System.out.println("Probabilidad de obtener Par: 42.2569%");
        System.out.println("Probabilidad de obtener Carta Alta: 50.1177%");



    }
}
