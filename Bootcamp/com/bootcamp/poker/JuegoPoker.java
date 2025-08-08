package com.bootcamp.poker;

import java.util.ArrayList;

public class JuegoPoker {
    public static void main(String[] args) {

        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta("AS"));
        cartas.add(new Carta("2S"));
        cartas.add(new Carta("3S"));
        cartas.add(new Carta("4S"));
        cartas.add(new Carta("5S"));

        Poker poker = new Poker(cartas);


        poker.combinationManager();

    }
}
