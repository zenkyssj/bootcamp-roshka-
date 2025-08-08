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
            System.out.println("Es escaleras color,");
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
        //TODO: GUARDAR CUANTOS CARTAS REPETIDAS HAY, SI HAY 2 QUE SE REPITEN 3 VECES Y 2 VECES, RETORNAR TRUE.
        List<String> cartasString = new ArrayList<>();

        int maxCart = 0;
        int maxCartValue = 0;

        for (Carta carta : cartas){
            cartasString.add(carta.valorPalo());
        }
        Map<String, Integer> conteo = contarCartasRepetidas(cartasString);

        for (Map.Entry<String, Integer> entrada : conteo.entrySet()) {
            System.out.println("Elemento: " + entrada.getKey() + ", Repeticiones: " + entrada.getValue());
            maxCart = entrada.getKey();
            maxCartValue = entrada.getValue();
        }
        return false;
    }

    private Map<String, Integer> contarCartasRepetidas(List<String> lista) {
        Map<String, Integer> conteo = new HashMap<>();
        HashSet<String> elementosUnicos = new HashSet<>(lista);

        for (String elemento : elementosUnicos) {
            int contador = 0;
            for (String elementoLista : lista) {
                if (elemento.equals(elementoLista)) {
                    contador++;
                }
            }
            conteo.put(elemento, contador);
        }
        return conteo;
    }
}

