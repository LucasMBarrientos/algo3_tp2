package edu.fiuba.algo3.modelo.edificios.protoss.pilon;

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
}
