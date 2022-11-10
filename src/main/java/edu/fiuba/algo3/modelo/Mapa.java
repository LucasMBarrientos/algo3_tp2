package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.*;

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
        buscarCasilla(1,1).establecerTerreno(new TerrenoMoho());
        buscarCasilla(9,9).establecerTerreno(new TerrenoEnergizado());
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
    public void generarTerrenoEnergizadoEnLosPilones() {
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverTerreno() instanceof TerrenoEnergizado) {
                casillaCentral.establecerTerreno(new TerrenoVacio());
            }
            if (casillaCentral.devolverEdificio() instanceof Pilon) {
                casillaCentral.establecerTerreno(new TerrenoEnergizado());
            }
        }
        generarTerrenoEnergizado();
        generarTerrenoEnergizado();
        generarTerrenoEnergizado();
    }

    private void generarTerrenoEnergizado() {
        List<Casilla> casillasConEnergia = new ArrayList<Casilla>();
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverTerreno() instanceof TerrenoEnergizado) {
                casillasConEnergia.add(casillaCentral);
            }
        }
        for (Casilla casillaConEnergia : casillasConEnergia){
            expandirEnergia(casillaConEnergia);
        }

    }

    public void generarMoho() {
        List<Casilla> casillasConMoho = new ArrayList<Casilla>();
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverTerreno() instanceof TerrenoMoho) {
                casillasConMoho.add(casillaCentral);

            }
        }
        for(Casilla casillaConMoho : casillasConMoho){
            expandirMoho(casillaConMoho);
        }
    }

    public void generarMoho(int radio) {
        for (int i = 0; i < radio; i++) {
            List<Casilla> casillasConMoho = new ArrayList<Casilla>();
            for (Casilla casillaCentral : this.casillas) {
                if (casillaCentral.devolverTerreno() instanceof TerrenoMoho) {
                    casillasConMoho.add(casillaCentral);
                }
            }
            for (Casilla casillaConMoho : casillasConMoho) {
                expandirMoho(casillaConMoho);
            }
        }
    }

    public void expandirMoho(Casilla casillaInicial){
        int x = casillaInicial.devolverX();
        int y = casillaInicial.devolverY();

        if(validarCasillaDentroDeLimites(x-1,y)){
            if (buscarCasilla(x-1,y).devolverTerreno() instanceof TerrenoVacio){
                buscarCasilla(x-1,y).establecerTerreno(new TerrenoMoho());
            }
        }
        if(validarCasillaDentroDeLimites(x+1,y)){
            if (buscarCasilla(x+1,y).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x + 1, y).establecerTerreno(new TerrenoMoho());
            }
        }
        if(validarCasillaDentroDeLimites(x,y+1)){
            if (buscarCasilla(x,y+1).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x, y + 1).establecerTerreno(new TerrenoMoho());
            }
        }
        if(validarCasillaDentroDeLimites(x,y-1)){
            if (buscarCasilla(x,y-1).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x, y - 1).establecerTerreno(new TerrenoMoho());
            }
        }
    }

    public boolean validarCasillaDentroDeLimites(int x,int y){
        return (x >= 0 && x < dimensionX) && (y >= 0 && y < dimensionY);
    }

    public void generarEnergizadosIniciales() {
        List<Casilla> casillasEnergizadas = new ArrayList<Casilla>();
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverTerreno() instanceof TerrenoEnergizado) {
                casillasEnergizadas.add(casillaCentral);

            }
        }
        for(Casilla casillaEnergia : casillasEnergizadas){
            expandirEnergia(casillaEnergia);
        }
    }

    public void expandirEnergia(Casilla casillaInicial){
        int x = casillaInicial.devolverX();
        int y = casillaInicial.devolverY();

        if(validarCasillaDentroDeLimites(x-1,y)){
            if (buscarCasilla(x-1,y).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x - 1, y).establecerTerreno(new TerrenoEnergizado());
            }
        }
        if(validarCasillaDentroDeLimites(x+1,y)){
            if (buscarCasilla(x+1,y).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x + 1, y).establecerTerreno(new TerrenoEnergizado());
            }
        }
        if(validarCasillaDentroDeLimites(x,y+1)){
            if (buscarCasilla(x,y+1).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x, y + 1).establecerTerreno(new TerrenoEnergizado());
            }
        }
        if(validarCasillaDentroDeLimites(x,y-1)){
            if (buscarCasilla(x,y-1).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x, y - 1).establecerTerreno(new TerrenoEnergizado());
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

    public void actualizar(int ronda) {
        if(ronda % 2 == 0){
            generarMoho();
        }
        for (Casilla casilla : casillas) {
            casilla.actualizar();
            generarTerrenoEnergizadoEnLosPilones();
            if (casilla.devolverEdificio() instanceof EdificioProtoss) {
                if (casilla.devolverTerreno() instanceof TerrenoEnergizado || casilla.devolverEdificio() instanceof NexoMineral || casilla.devolverEdificio() instanceof Asimilador) {
                    // TODO: Implementar interface "NecesitaEnergia" para simplificar esto
                    ((EdificioProtoss) casilla.devolverEdificio()).establecerOperatividad(true);
                } else {
                    ((EdificioProtoss) casilla.devolverEdificio()).establecerOperatividad(false);
                }
            }
        }
    }

    public TieneRecursos buscarEdificiosConRecursos(){
        for(Casilla casilla : casillas) {
            // Recorre todas las casillas del mapa
            if(casilla.devolverEdificio() instanceof TieneRecursos) {
                // Se halla un edificio que extrae recursos
                if (((TieneRecursos) casilla.devolverEdificio()).tieneRecursos()) {
                    // El edificio ademas tiene recursos extraidos
                    return (TieneRecursos) casilla.devolverEdificio();
                }
            }
        }
        return null;
    }

    public TieneRecursos buscarMineralesConZanganos(){
        for(Casilla casilla : casillas) {
            // Recorre todas las casillas del mapa
            if(casilla.devolverTerreno() instanceof TerrenoMineral && casilla.devolverUnidad() instanceof Zangano) {
                // Se halla un mineral con un zangano arriba
                if (((TieneRecursos) casilla.devolverUnidad()).tieneRecursos()) {
                    // El edificio ademas tiene recursos extraidos
                    return (TieneRecursos) casilla.devolverUnidad();
                }
            }
        }
        return null;
    }
    


}
