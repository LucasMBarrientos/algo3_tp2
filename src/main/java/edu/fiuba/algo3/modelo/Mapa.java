package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {

    private List<Casilla> casillas = new ArrayList<Casilla>();

    private int dimensionX;
    private int dimensionY;

    public Mapa(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        for (int x = 0; x < dimensionX; x++) {
            for (int y = 0; y < dimensionY; y++) {
                this.casillas.add(new Casilla(x,y,new TerrenoVacio()));
            }
        }
        buscarCasilla(1,1).establecerTerreno(new Moho());
    }

    private Casilla buscarCasillaAlAzar() {
        int x = ThreadLocalRandom.current().nextInt(0, dimensionY);
        int y = ThreadLocalRandom.current().nextInt(0, dimensionY);
        return this.buscarCasilla(x, y);
    }

/*    private Casilla buscarCasillaDesocupadaAlAzar() {
        Casilla casillaDisponible;
        while (true) {
            casillaDisponible = buscarCasillaAlAzar();
            if (casillaDisponible.devolverOcupante() == null) {
                return casillaDisponible;
            }
        }
    }

    private void generarVolcanes() {
        int cantidadDeVolcanes = ThreadLocalRandom.current().nextInt(5, 11); // En un mapa hay 5~10 volcanes
        for (int i = 0; i < cantidadDeVolcanes; i++) {
            buscarCasillaDesocupadaAlAzar().establecerTerreno(new Volcan());
        }
    }
*/
    public void generarMoho() {
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverEdificio() instanceof Criadero) {
                int x = casillaCentral.devolverX() - 1;
                int y = casillaCentral.devolverY() - 1;
                Casilla casillaPosible;
                for (int i = 0; i < 9; i++) {
                    casillaPosible = new Casilla(x,y);
                    for (Casilla casillaAdyacente : casillas) {
                        if (casillaPosible.compararUbicaciones(casillaCentral)) {
                            // Encontre la casilla del mapa en la misma posicion que casillaPosible
                            if(casillaAdyacente.devolverTerreno() instanceof TerrenoVacio){
                                casillaAdyacente.establecerTerreno(new Moho());
                            }
                        }
                    }
                    x++;
                    if (x == casillaCentral.devolverX() + 1) {
                        x -= 2;
                        y++;
                    }
                }

                //this.hallarCasillaAdyacenteConTerrenoVacio(casilla).establecerTerreno(new Moho());

            }
        }
    }

    public Casilla buscarCasilla(int x, int y) {
        for (Casilla casilla : this.casillas) {
           if (casilla.compararUbicaciones(x,y)){
               return casilla;
           }
        }
        return null;
    }

    public Casilla hallarCasillaAdyacenteDesocupada(Casilla casillaCentral) {
        int x = casillaCentral.devolverX() - 1;
        int y = casillaCentral.devolverY() - 1;
        Casilla casillaPosible;
        for (int i = 0; i < 9; i++) {
            casillaPosible = new Casilla(x,y);
            for (Casilla casilla : casillas) {
                if (casillaPosible.compararUbicaciones(casilla)) {
                    // Encontre la casilla del mapa en la misma posicion que casillaPosible
                    if (!casilla.ocupada()) {
                        return casilla;
                    }
                }
            }
            x++;
            if (x == casillaCentral.devolverX() + 1) {
                x -= 2;
                y++;
            }
        }
        return null;
    }

    private Casilla hallarCasillaAdyacenteConTerrenoVacio(Casilla casillaCentral) {
        int x = casillaCentral.devolverX() - 1;
        int y = casillaCentral.devolverY() - 1;
        Casilla casillaPosible;
        for (int i = 0; i < 9; i++) {
            casillaPosible = new Casilla(x,y);
            for (Casilla casilla : casillas) {
                if (casillaPosible.compararUbicaciones(casilla)) {
                    // Encontre la casilla del mapa en la misma posicion que casillaPosible
                    if (casilla.devolverTerreno() instanceof TerrenoVacio) {
                        return casilla;
                    }
                }
            }
            x++;
            if (x == casillaCentral.devolverX() + 1) {
                x -= 2;
                y++;
            }
        }
        return null;
    }

    public boolean validarMovimiento(Unidad unidad, Casilla nuevaCasilla) {
        if (nuevaCasilla == null) {
            return false;
        }
        return (nuevaCasilla.devolverUnidad() == null && nuevaCasilla.devolverTerreno().validarTransitable(unidad));
    }

    public void actualizar() {
        for (Casilla casilla : casillas) {
            casilla.actualizar();
        }
    }
}
