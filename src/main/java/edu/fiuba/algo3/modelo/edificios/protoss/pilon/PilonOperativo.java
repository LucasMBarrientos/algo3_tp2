package edu.fiuba.algo3.modelo.edificios.protoss.pilon;

import java.net.CookieHandler;
import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class PilonOperativo implements EstadoPilon{
    private Pilon pilon;
    
    @Override
    public boolean generaTerrenoEnergizado() {
        return true;
    }

    @Override
    public Pilon terminarConstruccion() {return pilon;}

    @Override
    public Pilon deshacerConstruccion() {
      pilon.establecerEstado(new PilonEnConstruccion());
      return pilon;
    }

    @Override
    public void setPilon(Pilon pilon) {
      this.pilon = pilon;
    }

    @Override
    public void actualizar() {
      this.pilon.escudo.regenerar();
    }

    @Override
    public void actualizarListaDeCoordenadasConPilonesOperativos(Coordenada coordenada, List<Coordenada> coordenadasConPilones) {
        coordenadasConPilones.add(coordenada);
    }

    @Override
    public void recibirGolpe(Danio danio) {
      if(this.pilon.vida.recibirDanio(new Danio(this.pilon.escudo.recibirDanio(danio) * (-1)))){
        this.pilon.establecerEstado(new PilonDestruido());
      }

    }

}
