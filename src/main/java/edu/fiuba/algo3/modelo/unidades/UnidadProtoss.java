package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;

public abstract class UnidadProtoss extends Unidad {

    protected Escudo escudo;
    public abstract Unidad generarse(Edificio edificio);
    public Escudo devolverEscudo() {
        return escudo;
    }
    
}
