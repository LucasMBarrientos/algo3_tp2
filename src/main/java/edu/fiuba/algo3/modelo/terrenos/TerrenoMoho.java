package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Actualizable;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidad;

public class TerrenoMoho implements Terreno, Actualizable {

    public boolean validarEdificio(Edificio edificio){
        return (edificio instanceof Criadero || edificio instanceof Espiral || edificio instanceof Guarida || edificio == null); //distinto de extractor y protoss
    };

    public boolean validarTransitable(Unidad unidad){
        return true;
    }
    public void actualizar() {
        // Expandir el moho a su alrededor
    }

}