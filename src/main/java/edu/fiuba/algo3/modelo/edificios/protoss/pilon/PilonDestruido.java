package edu.fiuba.algo3.modelo.edificios.protoss.pilon;

import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class PilonDestruido implements EstadoPilon{
    private Pilon pilon;

    @Override
    public boolean generaTerrenoEnergizado() {
        return false;
    }

    @Override
    public Pilon terminarConstruccion() {
      return pilon;
    }

    @Override
    public void setPilon(Pilon pilon) {
      this.pilon = pilon;
    }

    @Override
    public Pilon deshacerConstruccion() {
      return pilon;
    }

    @Override
    public void actualizar() {}

    @Override
    public void actualizarListaDeCoordenadasConPilonesOperativos(Coordenada coordenada, List<Coordenada> coordenadasConPilones) {
        return;
    }

    @Override
    public void recibirGolpe(Danio danio) throws EdificioDestruido {
      throw new EdificioDestruido();
    }
}
