package edu.fiuba.algo3.modelo.geometria;

import java.util.ArrayList;
import java.util.List;

public class Coordenada {

    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calcularDiferenciaEnX(int x) {
        return x - this.x;
    }

    // Retorna el resultado de la cuenta: (this.x - coordenada.x)
    public int calcularDiferenciaEnX(Coordenada coordenada) {
        return coordenada.calcularDiferenciaEnX(this.x);
    }

    public int calcularDiferenciaEnY(int y) {
        return y - this.y;
    }

    // Retorna el resultado de la cuenta: (this.y - coordenada.y)
    public int calcularDiferenciaEnY(Coordenada coordenada) {
        return coordenada.calcularDiferenciaEnY(this.y);
    }

    public boolean esIgual(Coordenada coordenada) {
        return (coordenada.calcularDiferenciaEnX(this.x) == 0 && coordenada.calcularDiferenciaEnY(this.y) == 0);
    }

    // Devuelve una lista con las coordendas inmediatamente adyacentes
    public List<Coordenada> hallarCoordenadasAdyacentes() {
        List<Coordenada> coordendas = new ArrayList<Coordenada>();
        coordendas.add(new Coordenada(x,y-1));
        coordendas.add(new Coordenada(x-1,y));
        coordendas.add(new Coordenada(x+1,y));
        coordendas.add(new Coordenada(x,y+1));
        return coordendas;
    }

    // Devuelve una lista con las coordendas adyacentes en cierto rango
    public List<Coordenada> hallarCoordenadasAdyacentes(int rango) {
        List<Coordenada> coordenadasAdyacentesTotales = new ArrayList<Coordenada>();
        List<Coordenada> nuevasCoordenadasAdyacentes = new ArrayList<Coordenada>();
        coordenadasAdyacentesTotales.add(this);
        for (int i = 0; i < rango; i++) {
            for (Coordenada coordenada : coordenadasAdyacentesTotales) {
                nuevasCoordenadasAdyacentes.addAll(coordenada.hallarCoordenadasAdyacentes());
            }
            coordenadasAdyacentesTotales.addAll(nuevasCoordenadasAdyacentes);
        }
        return coordenadasAdyacentesTotales;
    }

    public boolean seEncuentraEnListaDeCoordenadas(List<Coordenada> coordenadas) {
        boolean seEncontro = false;
        for (Coordenada coordenada : coordenadas) {
            seEncontro = (seEncontro || coordenada.esIgual(this));
        }
        return seEncontro;
    }

    public boolean seEncuentraACiertoRangoDeOtraCoordenada(Coordenada coordenadaCentral, int rango) {
        List<Coordenada> coordenadasEnTalRango = coordenadaCentral.hallarCoordenadasAdyacentes(rango);
        return this.seEncuentraEnListaDeCoordenadas(coordenadasEnTalRango);
    }

    public Coordenada devolverCoordenadaRelativa(int distanciaX, int distanciaY) {
        int x = this.x + distanciaX;
        int y = this.y + distanciaY;
        return new Coordenada(x,y);
    }
    
}
