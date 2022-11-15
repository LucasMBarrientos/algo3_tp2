package edu.fiuba.algo3.modelo.edificios.protoss.pilon;

public interface EstadoPilon {
  boolean generaTerrenoEnergizado();

  Pilon terminarConstruccion();

  Pilon deshacerConstruccion();

  void setPilon(Pilon pilon);

  void actualizar();
}
