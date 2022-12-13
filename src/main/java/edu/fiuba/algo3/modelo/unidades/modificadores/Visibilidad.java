package edu.fiuba.algo3.modelo.unidades.modificadores;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface Visibilidad {

    void visibilizarUnidad(Unidad unidad, int cantidadKills);

    void ejecutarDanio(Danio danioTerrestre, Vida vida, Escudo escudo, Unidad unidad);

    ObjectNode toData();

}
