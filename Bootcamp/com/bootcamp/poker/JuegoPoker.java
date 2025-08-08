package com.bootcamp.poker;

import java.util.ArrayList;

public class JuegoPoker {
    public static void main(String[] args) {

        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta("2C"));
        cartas.add(new Carta("2C"));
        cartas.add(new Carta("2C"));
        cartas.add(new Carta("3A"));
        cartas.add(new Carta("3A"));

        Poker poker = new Poker(cartas);
        poker.combinationManager();

    }
}
