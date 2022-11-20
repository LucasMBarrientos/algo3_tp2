package edu.fiuba.algo3.modelo.geometria;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SuperficieRectangular {

    private Coordenada coordenadaInicial;
    private Coordenada coordenadaFinal;
    
    public SuperficieRectangular(Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
        this.coordenadaInicial = coordenadaInicial;
        this.coordenadaFinal = coordenadaFinal;
    }

    public int calcularLongitudX() {
        return coordenadaFinal.calcularDiferenciaEnX(coordenadaInicial);
    }
    
    public int calcularLongitudY() {
        return coordenadaFinal.calcularDiferenciaEnY(coordenadaInicial);
    }

    // Devuelve el promedio entre la longitud de ambos lados
    public int calcularLongitudPromedio() {
        return (calcularLongitudX() + calcularLongitudY()) / 2;
    }

    public boolean contieneCoordenadaEnX(Coordenada coordenada) {
        return (coordenadaInicial.calcularDiferenciaEnX(coordenada) <= 0) && (coordenadaFinal.calcularDiferenciaEnX(coordenada) > 0);
    }

    public boolean contieneCoordenadaEnY(Coordenada coordenada) {
        return (coordenadaInicial.calcularDiferenciaEnY(coordenada) <= 0) && (coordenadaFinal.calcularDiferenciaEnY(coordenada) > 0);
    }

    public boolean contieneCoordenada(Coordenada coordenada) {
        return (this.contieneCoordenadaEnX(coordenada) && this.contieneCoordenadaEnY(coordenada));
    }

    public List<Coordenada> filtrarListaDeCoordenadas(List<Coordenada> coordenadas) {
        List<Coordenada> coordenadasFiltradas = new ArrayList<Coordenada>();
        for (Coordenada coordenada : coordenadas) {
            if (this.contieneCoordenada(coordenada)) {
                coordenadasFiltradas.add(coordenada);
            }
        }
        return coordenadasFiltradas;
    }

    public List<Coordenada> devolverCoordenadasAdyacentes(Coordenada coordenadaCentral) {
        List<Coordenada> coordenadasPosibles = coordenadaCentral.hallarCoordenadasAdyacentes();
        return this.filtrarListaDeCoordenadas(coordenadasPosibles);
    }
    public List<Coordenada> devolverCoordenadasAdyacentes(Coordenada coordenadaCentral, int rango) {
        List<Coordenada> coordenadasPosibles = coordenadaCentral.hallarCoordenadasAdyacentes(rango);
        return this.filtrarListaDeCoordenadas(coordenadasPosibles);
    }

    public Coordenada hallarCoordenadaCentral() {
        int x = calcularLongitudX() / 2;
        int y = calcularLongitudY() / 2;
        return coordenadaInicial.devolverCoordenadaRelativa(x,y);
    }

    public Coordenada buscarCoordenadaAlAzar() {
        int x = ThreadLocalRandom.current().nextInt(calcularLongitudX());
        int y = ThreadLocalRandom.current().nextInt(calcularLongitudY());
        return coordenadaInicial.devolverCoordenadaRelativa(x,y);
    }

    public Coordenada devolverCoordenadaAlAzarEvitando(List<Coordenada> coordenasEvitadas) {
        boolean coordenadaValida;
        Coordenada coordenada;
        do {
            coordenadaValida = true;
            coordenada = this.buscarCoordenadaAlAzar();
            for (Coordenada coordenadaEvitada : coordenasEvitadas) {
                coordenadaValida = !((!coordenadaValida) || coordenada.esIgual(coordenadaEvitada));
            }
        } while (!coordenadaValida);
        return coordenada;
    }

    public int calcularSuperficie() {
        return calcularLongitudX() * calcularLongitudY();
    }

}
