package edu.fiuba.algo3.modelo.unidades.edificios.protoss.pilon;

public class PilonEnConstruccion implements EstadoPilon{
    private Pilon pilon;

    @Override
    public boolean generaTerrenoEnergizado() {
        return false;
    }

    @Override
    public Pilon terminarConstruccion() {
      pilon.setState(new PilonOperativo());
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
    public void actualizar() {
      if(this.pilon.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
