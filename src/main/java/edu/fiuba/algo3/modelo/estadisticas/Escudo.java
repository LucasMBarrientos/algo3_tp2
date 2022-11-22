package edu.fiuba.algo3.modelo.estadisticas;

public class Escudo extends Estadistica {

    private final double tasaDeRegeneracion = 0.05;
    private final int poderMaximo;
    private int poderActual;

    public Escudo(int poderMaximo){
        this.poderMaximo = poderMaximo;
        this.poderActual = poderMaximo;
    }

    public int recibirDanio(Danio danio) {
        poderActual = danio.aplicarDanio(poderActual);
        return Math.min(poderActual, 0);
    }

    public void regenerar() {
        poderActual = Math.max(poderActual, 0);
        poderActual += Math.min(poderMaximo - poderActual, poderMaximo * tasaDeRegeneracion);
    }

}
