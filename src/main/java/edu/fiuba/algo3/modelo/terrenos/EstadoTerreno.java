package edu.fiuba.algo3.modelo.terrenos;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public abstract interface EstadoTerreno {

    void ocuparPorEdificio(Pilon pilon);

    void ocuparPorEdificio(Acceso acceso);

    void ocuparPorEdificio(Asimilador asimilador);

    void ocuparPorEdificio(NexoMineral nexoMineral);

    void ocuparPorEdificio(PuertoEstelar puertoEstelar);

    void ocuparPorEdificio(Criadero criadero);

    void ocuparPorEdificio(Espiral espiral);

    void ocuparPorEdificio(Extractor extractor);

    void ocuparPorEdificio(Guarida guarida);

    void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion);

    void ocuparPorUnidad(Dragon unidad);

    void ocuparPorUnidad(Zealot unidad);

    void ocuparPorUnidad(Scout unidad);

    void ocuparPorUnidad(Zangano unidad);

    void ocuparPorUnidad(Zerling unidad);

    void ocuparPorUnidad(Hidralisco unidad);

    void ocuparPorUnidad(Mutalisco unidad);

    void ocuparPorUnidad(Guardian unidad);

    void ocuparPorUnidad(Devorador unidad);

    void ocuparPorUnidad(AmoSupremo unidad);

    void energizarTerreno();

    void desenergizarTerreno();

    void cubrirTerrenoDeMoho();

    public ObjectNode toData();

    ObjectNode toDataOcupantes();

}
