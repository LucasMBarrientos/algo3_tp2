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
        return poderActual;
    }

    public void regenerar() {
        poderActual += Math.min(poderMaximo - poderActual, poderMaximo * tasaDeRegeneracion);
    }

}
