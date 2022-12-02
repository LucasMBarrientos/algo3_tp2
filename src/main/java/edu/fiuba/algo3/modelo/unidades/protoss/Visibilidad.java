package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadDestruida;

public interface Visibilidad {

    void ejecutarDanio(Danio danioTerrestre, Vida vida, Escudo escudo, Unidad unidad) ;
}
