package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.Recursos;

public interface EstadoTerreno {

  void ocuparPorEdificio(Edificio edificio, Casilla casilla);
  
  void energizarTerreno();

  void vaciarTerreno();
  
  void cubrirTerrenoDeMoho();

  void generarVolcan();

  void generarMina();

  boolean validarEstado(List<EstadoTerreno> listaDePosiblesTerrenos);

  void setTerreno(Terreno terreno);

  void consumirMinerales(Recursos recursoRequerido);

  void consumirGasVespeno(Recursos recursoRequerido);
}