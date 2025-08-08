package com.bootcamp.poker;

import java.util.*;

public class Poker {
    private final ArrayList<Carta> cartas;

    public Poker(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void combinationManager() {

        if (isPoker()) {
            System.out.println("Es Poker.");
        } else if (isEscalerasColor()) {
            System.out.println("Es Escaleras Color.");
        } else if (isFull()){
            System.out.println("Es Full.");
        } else if (isColor()){
            System.out.println("Es Color");
        }
    }

    private void showCartas() {
        for (Carta carta : this.cartas) {
            System.out.println(String.valueOf(carta.valorPalo()));
        }
    }

    private boolean isEscalerasColor() {

        String firstPalo = String.valueOf(cartas.getFirst().valorPalo().charAt(1));
        for (Carta carta : this.cartas) {
            if (!firstPalo.equals(String.valueOf(carta.valorPalo().charAt(1))))
                return false;
        }

        return true;
    }

    private boolean isPoker() {
        int maxCart = 0;
        Map<String, Integer> contador = new HashMap<>();

        for (Carta carta : this.cartas) {
            contador.put(carta.valorPalo(), contador.getOrDefault(carta.valorPalo(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > 1) {
                maxCart = entry.getValue();
            }
        }

        return maxCart == 4;
    }

    private boolean isFull() {
        List<String> cartasString = new ArrayList<>();

        for (Carta carta : cartas){
            cartasString.add(carta.valorPalo());
        }

        Map<String, Integer> conteo = contarCartasRepetidas(cartasString);

        boolean hayTrio = false;
        boolean hayPar = false;

        for (int repeticiones : conteo.values()) {
            if (repeticiones == 3) {
                hayTrio = true;
            } else if (repeticiones == 2) {
                hayPar = true;
            }
        }

        return hayTrio && hayPar;
    }

    private Map<String, Integer> contarCartasRepetidas(List<String> lista) {
        Map<String, Integer> conteo = new HashMap<>();

        for (String elemento : lista){
            conteo.put(elemento, conteo.getOrDefault(elemento, 0) + 1);
        }


        return conteo;
    }

    private boolean isColor(){
        List<String> palos = new ArrayList<>();

        for (Carta carta : this.cartas) {
            System.out.println();
            palos.add(String.valueOf(carta.valorPalo().charAt(1)));
        }

        return isAllPalosEquals(palos);
    }

    private boolean isAllPalosEquals(List<String> lista) {
        String primerPalo = lista.getFirst();
        for (String palo : lista) {
            if (!palo.equals(primerPalo)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEscalera(){

        return false;
    }
}

