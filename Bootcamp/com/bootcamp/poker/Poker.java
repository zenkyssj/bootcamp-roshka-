package com.bootcamp.poker;

import java.util.*;

public class Poker {
    private final ArrayList<Carta> cartas;
    private final ArrayList<Carta> cartas2;

    public Poker(ArrayList<Carta> cartas, ArrayList<Carta> cartas2) {
        this.cartas = cartas;
        this.cartas2 = cartas2;
    }

    private enum HandRank {
        CARTA_ALTA,
        PAR,
        DOBLE_PAR,
        TRIO,
        ESCALERA,
        COLOR,
        FULL,
        POKER,
        ESCALERA_COLOR
    }

    private List<Integer> buildNumericValues(int aceValue, List<Carta> hand) {
        Map<String, Integer> numericValues = new HashMap<>();
        numericValues.put("A", aceValue);
        numericValues.put("K", 13);
        numericValues.put("Q", 12);
        numericValues.put("J", 11);
        numericValues.put("T", 10);
        numericValues.put("10", 10);
        numericValues.put("9", 9);
        numericValues.put("8", 8);
        numericValues.put("7", 7);
        numericValues.put("6", 6);
        numericValues.put("5", 5);
        numericValues.put("4", 4);
        numericValues.put("3", 3);
        numericValues.put("2", 2);

        List<Integer> valores = new ArrayList<>();
        for (Carta carta : hand) {
            String vp = carta.valorPalo();
            String valor = vp.substring(0, vp.length() - 1);
            Integer num = numericValues.get(valor);
            if (num != null) {
                valores.add(num);
            }
        }
        Collections.sort(valores);
        return valores;
    }

    private HandRank evaluar(ArrayList<Carta> c) {
        if (isEscalerasColor(c)) {
            return HandRank.ESCALERA_COLOR;
        } else if (isPoker(c)) {
            return HandRank.POKER;
        } else if (isFull(c)) {
            return HandRank.FULL;
        } else if (isColor(c)) {
            return HandRank.COLOR;
        } else if (checkOrder(c) == 5) {
            return HandRank.ESCALERA;
        } else {
            switch (isTrioParDobleParCartaAlta(c)) {
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
        HandRank rank1 = evaluar(this.cartas);
        HandRank rank2 = evaluar(this.cartas2);

        int cmp = rank1.compareTo(rank2);
        if (cmp > 0) {
            System.out.println("Gana la mano 1: " + rank1);
        } else if (cmp < 0) {
            System.out.println("Gana la mano 2: " + rank2);
        } else {
            System.out.println("Empate: " + rank1);
        }
    }

    private boolean isEscalerasColor(ArrayList<Carta> c) {
        if (c.isEmpty()) return false;

        char firstSuit = c.get(0).valorPalo().charAt(c.get(0).valorPalo().length() - 1);
        for (Carta carta : c) {
            String vp = carta.valorPalo();
            char suit = vp.charAt(vp.length() - 1);
            if (suit != firstSuit) return false;
        }
        return checkOrder(c) == 5;
    }

    private int checkOrder(List<Carta> hand) {
        List<Integer> valoresConAsBajo = buildNumericValues(1, hand);
        if (isSequential(valoresConAsBajo)) return 5;

        List<Integer> valoresConAsAlto = buildNumericValues(14, hand);
        if (isSequential(valoresConAsAlto)) return 5;

        return 0;
    }

    private boolean isSequential(List<Integer> valores) {
        if (valores.size() < 5) return false;
        for (int i = 1; i < valores.size(); i++) {
            if (!Objects.equals(valores.get(i), valores.get(i - 1) + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPoker(ArrayList<Carta> c) {
        Map<String, Integer> contador = new HashMap<>();
        for (Carta carta : c) {
            String vp = carta.valorPalo();
            String valor = vp.substring(0, vp.length() - 1);
            contador.put(valor, contador.getOrDefault(valor, 0) + 1);
        }
        for (int count : contador.values()) {
            if (count == 4) return true;
        }
        return false;
    }

    private boolean isFull(ArrayList<Carta> c) {
        Map<String, Integer> contador = new HashMap<>();
        for (Carta carta : c) {
            String vp = carta.valorPalo();
            String valor = vp.substring(0, vp.length() - 1);
            contador.put(valor, contador.getOrDefault(valor, 0) + 1);
        }
        boolean hayTrio = false;
        boolean hayPar = false;
        for (int repeticiones : contador.values()) {
            if (repeticiones == 3) hayTrio = true;
            else if (repeticiones == 2) hayPar = true;
        }
        return hayTrio && hayPar;
    }

    private Map<String, Integer> contarCartasRepetidas(List<String> lista) {
        Map<String, Integer> conteo = new HashMap<>();
        for (String elemento : lista) {
            conteo.put(elemento, conteo.getOrDefault(elemento, 0) + 1);
        }
        return conteo;
    }

    private boolean isColor(ArrayList<Carta> c) {
        if (c.isEmpty()) return false;
        List<Character> palos = new ArrayList<>();
        for (Carta carta : c) {
            String vp = carta.valorPalo();
            palos.add(vp.charAt(vp.length() - 1));
        }
        return isAllPalosEquals(palos);
    }

    private boolean isAllPalosEquals(List<Character> lista) {
        if (lista.isEmpty()) return false;
        char primerPalo = lista.get(0);
        for (char palo : lista) {
            if (palo != primerPalo) return false;
        }
        return true;
    }

    private int isTrioParDobleParCartaAlta(ArrayList<Carta> c) {
        Map<String, Integer> contador = new HashMap<>();
        for (Carta carta : c) {
            String vp = carta.valorPalo();
            String valor = vp.substring(0, vp.length() - 1);
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
