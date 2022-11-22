package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class UnidadProtoss extends Unidad {

    protected Escudo escudo;
    
    public Escudo devolverEscudo() {
        return escudo;
    }

    public abstract boolean ocupar(Terreno terreno);
    
}
