package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
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