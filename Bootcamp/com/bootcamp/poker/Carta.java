package com.bootcamp.poker;

public class Carta {
    private final String valor;
    private final String palo;

    public Carta(String carta){
        this.valor = String.valueOf(carta.charAt(0));
        this.palo = String.valueOf(carta.charAt(1));
    }

    public String valorPalo(){
        return this.valor + this.palo;
    }
}
