package edu.fiuba.algo3.modelo.geometria;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

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
            // Se buscan las coordenadas adyacentes del total de coordenadas adyacentes
            nuevasCoordenadasAdyacentes = new ArrayList<Coordenada>();
            for (Coordenada coordenada : coordenadasAdyacentesTotales) {
                nuevasCoordenadasAdyacentes.addAll(coordenada.hallarCoordenadasAdyacentes());
            }
            // Se aniaden las nuevas coordenadas que no se encuentren en la lista del total de coordenadas adyacentes 
            for (Coordenada nuevaCoordenada : nuevasCoordenadasAdyacentes) {
                if (!nuevaCoordenada.seEncuentraEnListaDeCoordenadas(coordenadasAdyacentesTotales)) {
                    coordenadasAdyacentesTotales.add(nuevaCoordenada);
                }
            }
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

    public ObjectNode toData(){
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("x",x);
        nodo.put("y",y);
        return nodo;
    }

    public int devolverX() {
        return x;
    }
    public int devolverY() {
        return y;
    }

    public String devolverValorComoString(){
        return "(" + devolverX() + "," + devolverY() + ")";
    }
    
}
