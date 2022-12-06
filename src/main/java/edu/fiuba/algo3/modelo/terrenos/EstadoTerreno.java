package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.Recurso;
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

    boolean tieneMoho();
    
    void cubrirTerrenoDeMoho();

    public String toData();

    ObjectNode toDataOcupantes();

}