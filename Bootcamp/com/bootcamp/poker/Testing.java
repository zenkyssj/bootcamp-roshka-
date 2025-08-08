package com.bootcamp.poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Testing {


    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("a");
        lista.add("b");
        lista.add("a");
        lista.add("c");
        lista.add("b");
        lista.add("a");

        Map<String, Integer> conteo = contarElementosRepetidos(lista);

        for (Map.Entry<String, Integer> entrada : conteo.entrySet()) {
            System.out.println("Elemento: " + entrada.getKey() + ", Repeticiones: " + entrada.getValue());
        }
    }

    public static Map<String, Integer> contarElementosRepetidos(List<String> lista) {
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


