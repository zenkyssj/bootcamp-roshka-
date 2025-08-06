package com.bootcamp.ejercicioreloj;

public class Reloj {
    private int hora = 0;
    private int minutos = 0;
    private int segundos = 0;

    public Reloj() {
        this.hora = 12;
        this.minutos = 00;
        this.segundos = 00;
    }

    public Reloj(int hora, int minutes, int seconds) {
        this.hora = hora;
        this.minutos = minutes;
        this.segundos = seconds;
    }

    public Reloj(int seconds) {
        setReloj(seconds);
    }

    public void setReloj(int seconds) {
        this.hora = seconds / 3600;
        this.minutos = (seconds % 3600) / 60;
        this.segundos = seconds % 60;
    }

    public int getHoras() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setHoras(int hora) {
        this.hora = hora;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void tick() {

        if (this.segundos < 60) {
            this.segundos++;
        } else if (this.minutos < 60 && this.segundos == 60) {
            this.minutos++;
            this.segundos = 0;
        } else if (this.minutos == 60) {
            this.hora++;
            this.minutos = 0;
            this.segundos = 0;
        }
    }

    public void tickDrecrement() {
        if (this.segundos > 0) {
            this.segundos--;
        } else if (this.minutos > 0 && this.segundos == 0) {
            this.minutos--;
            this.segundos = 59;
        } else if (this.minutos == 0) {
            this.hora--;
            this.minutos = 59;
            this.segundos = 59;
        }
    }

    public void addReloj(Reloj reloj) {
        this.hora = reloj.hora;
        this.minutos = reloj.minutos;
        this.segundos = reloj.minutos;
    }

    public String toString() {

        String horasString = String.valueOf(hora);
        String mintutosString = String.valueOf(minutos);
        String segundosString = String.valueOf(segundos);

        String relojFormateado = "[" + horasString + ":" + mintutosString + ":" + segundosString + "]";
        // Retornar la hora en formato "[hh:mm:ss]"
        return relojFormateado;
    }

    public Reloj restaReloj(Reloj relojResta) {

        int diferencia = this.toSegundos() - relojResta.toSegundos();

        if (diferencia < 0) {
            diferencia += 86400;
        }

        return new Reloj(diferencia);

    }

    private int toSegundos() {
        return ((hora * 3600) + (minutos * 60) + segundos);
    }
}
