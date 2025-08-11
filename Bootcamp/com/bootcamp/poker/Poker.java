package com.bootcamp.poker;

import java.util.*;

public class Poker {
    private final ArrayList<Carta> cartas;
    private final ArrayList<Carta> cartas2;

    public Poker(ArrayList<Carta> cartas, ArrayList<Carta> cartas2)
    {
        this.cartas = cartas;
        this.cartas2 = cartas2;
    }

    private enum HandRank{
        CARTA_ALTA,
        PAR,
        DOBLE_PAR,
        TRIO,
        ESCALERA,
        COLOR,
        FULL,
        POKR,
        ESCALERA_COLOR
    }
    private List<Integer> buildNumericValues(int value){
        Map<String, Integer> numericValues = new HashMap<>();

        numericValues.put("A", value);
        numericValues.put("2", 2);
        numericValues.put("3", 3);
        numericValues.put("4", 4);
        numericValues.put("5", 5);
        numericValues.put("6", 6);
        numericValues.put("7", 7);
        numericValues.put("8", 8);
        numericValues.put("9", 9);
        numericValues.put("10", 10);
        numericValues.put("J", 11);
        numericValues.put("Q", 12);
        numericValues.put("K", 13);

        List<Integer> valores = new ArrayList<>();
        for (Carta carta : cartas) {
            String valor = carta.valorPalo().substring(0, carta.valorPalo().length() - 1);
            Integer num = numericValues.get(valor);
            if (num != null) {
                valores.add(num);
            }
        }

        Collections.sort(valores);
        return valores;
    }

    private HandRank evaluar(ArrayList<Carta> c){

        if (isEscalerasColor(c)){
            return HandRank.ESCALERA_COLOR;
        } else if (isPoker(c)){
            return HandRank.POKR;
        } else if (isFull(c)){
            return HandRank.FULL;
        } else if (isColor(c)){
            return HandRank.COLOR;
        } else if (checkOrder() == 5){
            return HandRank.ESCALERA;
        } else {
            switch (isTrioParDobleParCartaAlta(c)){
                case 1 -> {
                    return HandRank.TRIO;
                }
                case 2 -> {
                    return HandRank.DOBLE_PAR;
                }
                case 3 -> {
                    return HandRank.PAR;
                }
                case 4 -> {
                    return HandRank.CARTA_ALTA;
                }
            }
        }

        return HandRank.CARTA_ALTA;
    }

    public void combinationManager() {
        HandRank rank_carta1 = evaluar(this.cartas);
        HandRank rank_carta2 = evaluar(this.cartas2);

        int cmp = rank_carta2.compareTo(rank_carta1);

        if (cmp < 0) {
            System.out.println("Gana la carta 1: ");
        } else if (cmp > 0) {
            System.out.println("Gana la carta 2: ");
        } else {
            System.out.println("Empate");
        }
    }

    private boolean isEscalerasColor(ArrayList<Carta> c) {

        String firstPalo = String.valueOf(cartas.getFirst().valorPalo().charAt(1));
        for (Carta carta : c) {
            if (!firstPalo.equals(String.valueOf(carta.valorPalo().charAt(1))))
                return false;
        }

        return checkOrder() == 5;
    }

    private int checkOrder(){

        List<Integer> valoresConAsBajo = buildNumericValues(1);
        if (isSequential(valoresConAsBajo)) return 5;

        List<Integer> valoresConAsAlto = buildNumericValues(14);
        if (isSequential(valoresConAsAlto)) return 5;

        return 0;
    }

    private boolean isSequential(List<Integer> valores){
        for (int i = 1; i < valores.size(); i++) {
            if (valores.get(i) != valores.get(i - 1) + 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isPoker(ArrayList<Carta> c) {
        int maxCart = 0;
        Map<String, Integer> contador = new HashMap<>();

        for (Carta carta : c) {
            contador.put(carta.valorPalo(), contador.getOrDefault(carta.valorPalo(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > 1) {
                maxCart = entry.getValue();
            }
        }
        return maxCart == 4;
    }


    private boolean isFull(ArrayList<Carta> c) {
        List<String> cartasString = new ArrayList<>();

        for (Carta carta : c){
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

    private boolean isColor(ArrayList<Carta> c){
        List<String> palos = new ArrayList<>();

        for (Carta carta : c) {
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

    private int isTrioParDobleParCartaAlta(ArrayList<Carta> c) {
        Map<String, Integer> contador = new HashMap<>();

        for (Carta carta : c) {
            String valor = carta.valorPalo().substring(0, carta.valorPalo().length() - 1); //
            contador.put(valor, contador.getOrDefault(valor, 0) + 1);
        }

        int pares = 0;
        boolean trio = false;

        for (int cantidad : contador.values()) {
            if (cantidad == 3) {
                trio = true;
            } else if (cantidad == 2) {
                pares++;
            }
        }
        if (trio) {
            return 1;
        } else if (pares == 2) {
            return 2;
        } else if (pares == 1) {
            return 3;
        } else {
            return 4;
        }
    }
}


