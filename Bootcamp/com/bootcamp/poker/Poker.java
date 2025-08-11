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

    private static final class HandValue implements Comparable<HandValue> {
        final HandRank rank;
        final List<Integer> tiebreakers; // ordenados de mayor a menor importancia

        HandValue(HandRank rank, List<Integer> tiebreakers) {
            this.rank = rank;
            this.tiebreakers = List.copyOf(tiebreakers);
        }

        @Override
        public int compareTo(HandValue o) {
            int byRank = this.rank.compareTo(o.rank);
            if (byRank != 0) return byRank;
            int n = Math.min(this.tiebreakers.size(), o.tiebreakers.size());
            for (int i = 0; i < n; i++) {
                int a = this.tiebreakers.get(i);
                int b = o.tiebreakers.get(i);
                if (a != b) return Integer.compare(a, b);
            }
            return Integer.compare(this.tiebreakers.size(), o.tiebreakers.size());
        }

        @Override
        public String toString() {
            return rank + " " + tiebreakers;
        }
    }

    // Mapeo de valores soportando "T" y "10". As puede ser 14 o 1 según se pase.
    private int mapValor(String valor, int aceValue) {
        return switch (valor) {
            case "A" -> aceValue;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> 11;
            case "T", "10" -> 10;
            case "9" -> 9;
            case "8" -> 8;
            case "7" -> 7;
            case "6" -> 6;
            case "5" -> 5;
            case "4" -> 4;
            case "3" -> 3;
            case "2" -> 2;
            default -> throw new IllegalArgumentException("Valor de carta inválido: " + valor);
        };
    }

    private String getValorStr(Carta c) {
        String vp = c.valorPalo();
        return vp.substring(0, vp.length() - 1);
    }

    private char getPalo(Carta c) {
        String vp = c.valorPalo();
        return vp.charAt(vp.length() - 1);
    }

    private List<Integer> valuesDesc(List<Carta> hand, int aceValue) {
        List<Integer> vals = new ArrayList<>(5);
        for (Carta c : hand) vals.add(mapValor(getValorStr(c), aceValue));
        vals.sort(Comparator.reverseOrder());
        return vals;
    }

    private boolean isFlush(List<Carta> hand) {
        char s = getPalo(hand.get(0));
        for (Carta c : hand) if (getPalo(c) != s) return false;
        return true;
    }

    // Devuelve: [esEscalera, cartaAlta] considerando As alto y rueda A-2-3-4-5
    private AbstractMap.SimpleEntry<Boolean, Integer> straightHigh(List<Carta> hand) {
        // Usar set para evitar duplicados
        Set<Integer> uniqHigh = new HashSet<>();
        for (Carta c : hand) uniqHigh.add(mapValor(getValorStr(c), 14));
        if (uniqHigh.size() != 5) return new AbstractMap.SimpleEntry<>(false, 0);

        List<Integer> vHigh = new ArrayList<>(uniqHigh);
        vHigh.sort(Comparator.naturalOrder());
        boolean seqHigh = true;
        for (int i = 1; i < vHigh.size(); i++) {
            if (vHigh.get(i) != vHigh.get(i - 1) + 1) {
                seqHigh = false;
                break;
            }
        }
        if (seqHigh) return new AbstractMap.SimpleEntry<>(true, vHigh.get(4)); // carta alta

        // rueda: A(14) -> tratar As como 1 y volver a comprobar
        Set<Integer> uniqLow = new HashSet<>();
        for (Carta c : hand) uniqLow.add(mapValor(getValorStr(c), 1));
        List<Integer> vLow = new ArrayList<>(uniqLow);
        vLow.sort(Comparator.naturalOrder());
        if (vLow.size() == 5) {
            boolean seqLow = true;
            for (int i = 1; i < vLow.size(); i++) {
                if (vLow.get(i) != vLow.get(i - 1) + 1) {
                    seqLow = false;
                    break;
                }
            }
            if (seqLow && vLow.get(0) == 1 && vLow.get(4) == 5) {
                return new AbstractMap.SimpleEntry<>(true, 5); // rueda -> carta alta 5
            }
        }
        return new AbstractMap.SimpleEntry<>(false, 0);
    }

    private Map<Integer, Integer> countsByValue(List<Carta> hand) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Carta c : hand) {
            int v = mapValor(getValorStr(c), 14); // para conteos el As es 14
            counts.put(v, counts.getOrDefault(v, 0) + 1);
        }
        return counts;
    }

    // Construye tiebreakers para patrones por grupos: ordena por (size desc, valor desc)
    private List<Integer> groupsTieBreakers(Map<Integer, Integer> counts, int... groupSizesDesc) {
        // agrupar por tamaño
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> bySize = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            bySize.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }
        for (int size : groupSizesDesc) {
            List<Integer> vals = bySize.getOrDefault(size, Collections.emptyList());
            vals.sort(Comparator.reverseOrder());
            result.addAll(vals);
        }
        // añadir kickers restantes (size 1)
        if (!bySize.isEmpty()) {
            List<Integer> singles = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> e : bySize.entrySet()) {
                if (e.getKey() == 1) singles.addAll(e.getValue());
            }
            singles.sort(Comparator.reverseOrder());
            result.addAll(singles);
        }
        return result;
    }

    // Evalúa una mano devolviendo rango y tiebreakers listos para comparar
    private HandValue evaluarConDesempate(ArrayList<Carta> hand) {
        boolean flush = isFlush(hand);
        var straightInfo = straightHigh(hand);
        boolean straight = straightInfo.getKey();
        int straightHighCard = straightInfo.getValue();

        Map<Integer, Integer> counts = countsByValue(hand);

        if (straight && flush) {
            return new HandValue(HandRank.ESCALERA_COLOR, List.of(straightHighCard));
        }

        // Póker: 4 + kicker
        if (counts.containsValue(4)) {
            List<Integer> tbs = groupsTieBreakers(counts, 4);
            return new HandValue(HandRank.POKER, tbs);
        }

        // Full: 3 + 2
        if (counts.containsValue(3) && counts.containsValue(2)) {
            List<Integer> tbs = new ArrayList<>();
            // primero el trío, luego el par
            List<Integer> trio = new ArrayList<>();
            List<Integer> par = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
                if (e.getValue() == 3) trio.add(e.getKey());
                else if (e.getValue() == 2) par.add(e.getKey());
            }
            trio.sort(Comparator.reverseOrder());
            par.sort(Comparator.reverseOrder());
            tbs.addAll(trio);
            tbs.addAll(par);
            return new HandValue(HandRank.FULL, tbs);
        }

        if (flush) {
            // 5 cartas desc
            return new HandValue(HandRank.COLOR, valuesDesc(hand, 14));
        }

        if (straight) {
            return new HandValue(HandRank.ESCALERA, List.of(straightHighCard));
        }

        // Trío: 3 + dos kickers
        if (counts.containsValue(3)) {
            List<Integer> tbs = groupsTieBreakers(counts, 3);
            return new HandValue(HandRank.TRIO, tbs);
        }

        // Doble par: par alto, par bajo, kicker
        int pairs = 0;
        for (int v : counts.values()) if (v == 2) pairs++;
        if (pairs >= 2) {
            // ordenar pares desc y luego kicker
            List<Integer> paresVals = new ArrayList<>();
            List<Integer> singles = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
                if (e.getValue() == 2) paresVals.add(e.getKey());
                else if (e.getValue() == 1) singles.add(e.getKey());
            }
            paresVals.sort(Comparator.reverseOrder());
            singles.sort(Comparator.reverseOrder());
            List<Integer> tbs = new ArrayList<>(paresVals);
            tbs.addAll(singles); // solo habrá 1 kicker
            return new HandValue(HandRank.DOBLE_PAR, tbs);
        }

        // Par: par + 3 kickers
        if (counts.containsValue(2)) {
            List<Integer> tbs = groupsTieBreakers(counts, 2);
            return new HandValue(HandRank.PAR, tbs);
        }

        // Carta alta
        return new HandValue(HandRank.CARTA_ALTA, valuesDesc(hand, 14));
    }

    public void combinationManager() {
        HandValue hv1 = evaluarConDesempate(this.cartas);
        HandValue hv2 = evaluarConDesempate(this.cartas2);

        int cmp = hv1.compareTo(hv2);
        if (cmp > 0) {
            System.out.println("Gana la mano 1: " + hv1.rank);
        } else if (cmp < 0) {
            System.out.println("Gana la mano 2: " + hv2.rank);
        } else {
            System.out.println("Empate: " + hv1.rank);
        }
    }
}
