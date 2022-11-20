package edu.fiuba.algo3.modelo.estadisticas;

import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;

public class Vida extends Estadistica {

    private final double tasaDeRegeneracion = 0.05;
    private final int valorMaximo;
    private int valorActual;

    public Vida(int valorMaximo) {
        this.valorMaximo = valorMaximo;
        this.valorActual = valorMaximo;
    }

    public void recibirDanio(Danio danio) throws EdificioDestruido {
        valorActual = danio.aplicarDanio(valorActual);
        if (valorActual <= 0) {
            throw new EdificioDestruido();
        }
    }

    public void regenerar() {
        valorActual += Math.min(valorMaximo - valorActual, valorMaximo * tasaDeRegeneracion);
    }

}
