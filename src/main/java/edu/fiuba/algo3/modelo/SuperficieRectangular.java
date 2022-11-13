package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SuperficieRectangular {

    Coordenada coordenadaInicial;
    Coordenada coordenadaFinal;
    
    public SuperficieRectangular(Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
        this.coordenadaInicial = coordenadaInicial;
        this.coordenadaFinal = coordenadaFinal;
    }

    public boolean contieneCoordenada(Coordenada coordenada) {
        return (coordenada.completamenteMenorA(coordenadaInicial) && coordenada.completamenteMayorA(coordenadaFinal));
    }

    public Coordenada devolverCoordenadaCentral() {
        int x = (coordenadaFinal.devolverX() + coordenadaInicial.devolverX()) / 2;
        int y = (coordenadaFinal.devolverY() + coordenadaInicial.devolverY()) / 2;
        return new Coordenada(x, y);
    }

    public Coordenada devolverCoordenadaAlAzar() {
        int x = ThreadLocalRandom.current().nextInt(coordenadaInicial.devolverX(), coordenadaFinal.devolverX());
        int y = ThreadLocalRandom.current().nextInt(coordenadaInicial.devolverY(), coordenadaFinal.devolverY());
        return new Coordenada(x, y);
    }

    public Coordenada devolverCoordenadaAlAzarEvitando(List<Coordenada> coordenasEvitadas) {
        boolean coordenadaValida;
        Coordenada coordenada;
        do {
            coordenadaValida = true;
            coordenada = devolverCoordenadaAlAzar();
            for (Coordenada coordenadaEvitada : coordenasEvitadas) {
                if (coordenada.esIgual(coordenadaEvitada)) {
                    coordenadaValida = false;
                }
            }
        } while (!coordenadaValida);
        return coordenada;

    }

    public int devolverXMax() {
        return coordenadaFinal.devolverX();
    }

    public int devolverYMax() {
        return coordenadaFinal.devolverY();
    }

    public int devolverXMin() {
        return coordenadaInicial.devolverX();
    }

    public int devolverYMin() {
        return coordenadaInicial.devolverY();
    }

    public int calcularSuperficie() {
        int x = coordenadaFinal.devolverX() - coordenadaInicial.devolverX();
        int y = coordenadaFinal.devolverY() - coordenadaInicial.devolverY();
        return x * y;
    }

    public int devolverLongitudPromedio() {
        // Devuelve el promedio entre la longitud de ambos lados
        int x = coordenadaFinal.devolverX() - coordenadaInicial.devolverX();
        int y = coordenadaFinal.devolverY() - coordenadaInicial.devolverY();
        return (x + y) / 2;
    }

}
