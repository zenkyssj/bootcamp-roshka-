package com.bootcamp.poker;

import java.util.ArrayList;

public class JuegoPoker {
    public static void main(String[] args) {

        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta("2C"));
        cartas.add(new Carta("2C"));
        cartas.add(new Carta("2C"));
        cartas.add(new Carta("3C"));
        cartas.add(new Carta("3C"));

        Poker poker = new Poker(cartas);
        poker.combinationManager();

    }
}
