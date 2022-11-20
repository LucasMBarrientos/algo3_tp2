package edu.fiuba.algo3.modelo.edificios.protoss.pilon;

import java.util.List;

import edu.fiuba.algo3.modelo.geometria.Coordenada;

public interface EstadoPilon {

    boolean generaTerrenoEnergizado();

    Pilon terminarConstruccion();

    Pilon deshacerConstruccion();

    void setPilon(Pilon pilon);

    void actualizar();

    void actualizarListaDeCoordenadasConPilonesOperativos(Coordenada coordenada, List<Coordenada> coordenadasConPilones);

}
