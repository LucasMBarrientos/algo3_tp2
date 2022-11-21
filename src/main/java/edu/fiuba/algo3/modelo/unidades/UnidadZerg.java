package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class UnidadZerg extends Unidad {

    public abstract Unidad generarse(Edificio edificio);

    public abstract boolean ocupar(Terreno terreno);

}
