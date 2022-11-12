package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeTerreno {

    public List<Casilla> buscarCasillasConMoho(List<Casilla> casillasTotales) {
        List<Casilla> casillasConMoho = new ArrayList<Casilla>();
        for (Casilla casilla : casillasTotales) {
            if (casilla.devolverTerreno().esTerrenoMoho()) {
                casillasConMoho.add(casilla);
            }
        }
        return casillasConMoho;
    }


    // generarTerrenoEnergizadoEnPilon(Casilla casilla, Edificio edificio)
    // Si "edificio" es un objeto "Pilon" entonces establece en su terreno un nuevo objeto "TerrenoEnergizado".
    // Si "edificio" no es un objeto "Pilon" y su terreno es del tipo "TerrenoEnergizado" entonces lo reemplaza por un nuevo objeto "TerrenoVacio"
    // Si "edificio" no es un objeto "Pilon" y su terreno es de otro tipo que "TerrenoEnergizado" entonces lo deja como esta.

    /*
    public boolean generarTerrenoEnergizadoEnPilon(Casilla casilla, Boolean esUnPilon) {
        if (esUnPilon) {

        } else {
            vaciarTerrenoEnergizado(casilla, casilla.devolverTerreno().estaEnergizado());
        }
        return esUnPilon;
    }



    public boolean generarTerrenoEnergizadoEnPilon(Casilla casilla) {
        casilla.establecerTerreno(new TerrenoEnergizado());
        return true;   
    }

    public boolean generarTerrenoEnergizadoEnPilon(Casilla casilla) {
        vaciarTerrenoEnergizado(casilla, casilla.devolverTerreno());
        return false;
    }

    private void vaciarTerrenoEnergizado(Casilla casilla, TerrenoEnergizado terrenoEnergizado) {
        casilla.establecerTerreno(new TerrenoVacio());
    }

    private void vaciarTerrenoEnergizado(Casilla casilla, Terreno terreno) {
        // Deja el terreno como esta
        return;
    }




/*
    public void actualizarListaDeCasillasConMoho(List<Casilla> casillasConMoho, Casilla estaCasilla, TerrenoMoho terrenoMoho) {
        casillasConMoho.add(estaCasilla);
    }











    public void expandirMoho(List<Casilla> casillasAdyacentes, TerrenoMoho terrenoMoho) {
        for (Casilla casillaAdyacente : casillasAdyacentes) {
            casillaAdyacente.establecerTerreno(new TerrenoMoho());
        }
    }

    public void expandirMoho(Terreno terreno) {
        // El terreno no es del tipo "TerrenoMoho"
        return;
    }

    public boolean expandirEnergia(List<Casilla> casillasAdyacentes, TerrenoEnergizado terrenoEnergizado) {
        for (Casilla casillaAdyacente : casillasAdyacentes) {
            casillaAdyacente.establecerTerreno(new TerrenoEnergizado());
        }
        return true;
    }


    */

}
