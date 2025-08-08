package com.bootcamp.poker;

import java.util.*;

public class Poker {
    private final ArrayList<Carta> cartas;
    ;
    List<Integer> valores = new ArrayList<>();


    public Poker(ArrayList<Carta> cartas) {
        this.cartas = cartas;

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
            String valor = carta.valorPalo().substring(0, carta.valorPalo().length() - 1); // Quitar el último char (palo)
            Integer num = numericValues.get(valor);
            if (num != null) {
                valores.add(num);
            }
        }

        Collections.sort(valores);
        return valores;
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

    private boolean isEscalerasColor() {

        String firstPalo = String.valueOf(cartas.getFirst().valorPalo().charAt(1));
        for (Carta carta : this.cartas) {
            if (!firstPalo.equals(String.valueOf(carta.valorPalo().charAt(1))))
                return false;
        }

        return checkOrder() == 5;
    }

    private int checkOrder(){

        String firstValue = String.valueOf(cartas.getFirst().valorPalo().charAt(0));
        String lastValue = String.valueOf(cartas.getLast().valorPalo().charAt(0));

        if (!firstValue.equals("A") && !lastValue.equals("A")){
            return checkWithoutA();
        } else if (firstValue.equals("A")){
            return checkWithAFirst();
        }
        return 0;
    }

    private int checkWithoutA() {
        //initializeNumericValues(1);

        int contador = 1;

        for (int i = 1; i < valores.size(); i++) {
            if (valores.get(i) == valores.get(i - 1) + 1) {
                contador++;
            } else {
                break;
            }
        }

        return contador;
    }

    private int checkWithAFirst(){
        //initializeNumericValues(1);
        int contador = 1;

        //numericValues.put("A", 1);

        if (valores.get(0) < valores.get(1)){
            return 0;
        }

        for (int i = 1; i < valores.size(); i++) {
            if (valores.get(i) == valores.get(i - 1) + 1) {
                contador++;
            } else {
                break;
            }
        }

        return contador;
    }

    private int checkWithALast(){
        //initializeNumericValues(14);

        return 0;
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

