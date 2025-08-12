package com.bootcamp.generala;

import java.lang.reflect.Array;
import java.util.*;
import java.io.File;

public class Generala
{
    // ESTA ES LA FUNCIÓN QUE HAY QUE IMPLEMENTAR
    // TAMBIÉN PUEDEN AGREGAR OTRAS FUNCIONES y/o CLASES
    // QUE NECESITEN PARA RESOLVER EL EJERCICIO DE LA
    // MANERA MÁS ORDENADA POSIBLE
    String jugada(String dados)
    {
        String resultado = "";
        if(checkGenerala(dados)){
            resultado = "GENERALA";
        } else if (checkEscalera(dados)){
            resultado = "ESCALERA";
        } else if (!checkEscalera(dados)){
            resultado = switch (checkCombinations(dados)) {
                case 3 -> "FULL";
                case 2 -> "NADA";
                case 4 -> "POKER";
                default -> "INVALIDO";
            };
        }

        return resultado ;
    }

    boolean checkGenerala(String dados){
        char firstDado = dados.charAt(0);

        //System.out.println(firstDado);

        for (int i = 0; i < dados.length(); i++){
            if (firstDado != dados.charAt(i))
                return false;
        }

        return true;
    }

    int checkCombinations(String dados) {
        if (dados == null || dados.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : dados.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        int maxCount = 0;
        for (int count : charCounts.values()) {
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    boolean checkEscalera(String dados){
        ArrayList<Character> listaCharacters = new ArrayList<>();
        for (char dado : dados.toCharArray()) {
            listaCharacters.add(dado);
        }

        List<Character> a1 = Arrays.asList('1', '2', '3', '4', '5');
        List<Character> a2 = Arrays.asList('2', '3', '4', '5', '6');
        List<Character> a3 = Arrays.asList('3', '4', '5', '6', '1');

        return listaCharacters.containsAll(a1) ||
                listaCharacters.containsAll(a2) ||
                listaCharacters.containsAll(a3);
    }

    // Ustedes pueden ignorar esto
    String[] jugadas(String[] losdados)
    {String[] ret = new String[losdados.length];
        int i = 0;
        for (String dados : losdados)
        {
            ret[i] = this.jugada(dados);
            i++;
        }
        return ret;
    }

    // Ustedes pueden ignorar esto
    static String[] processBatch(String fileName)
            throws Exception
    {
        Scanner sc = new Scanner(new File(fileName));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        return lines.toArray(new String[0]);
    }

    public static void main(String[] args)
            throws Exception
    {
        Generala g = new Generala();

        /* IGNORAR PORQUE ESTO NO SE VA A EJECUTAR PARA USTEDES */
        if (args.length > 0) {
            String[] jugadas = processBatch(args[0]);
            String resultados[] = g.jugadas(jugadas);
            for(String res : resultados) {
                System.out.println(res);
            }
            return;
        }

        // ESTO SI SE EJECUTA PARA USTEDES
        System.out.println(g.jugada("55544"));

        System.out.println("Probabilidad de sacar Generala: 0.077%");
        System.out.println("Probabilidad de sacar Poker 1 vez es: 1.928%");
        System.out.println("Probabilidad de sacar Full 1 vez es: 3.86%");
        System.out.println("Probabilidad de sacar Escalera 1 vez es: 3.09%");
        System.out.println("La probabilidad de sacar nada es: 91.04%");
        System.out.println("Probabilidad de sacar 2 veces es: 0.077%");
    }
}

