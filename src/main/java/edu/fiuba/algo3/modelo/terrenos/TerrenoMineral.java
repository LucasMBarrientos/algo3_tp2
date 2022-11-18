package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.unidades.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.Recursos;

public class TerrenoMineral implements EstadoTerreno{
  private Terreno terreno;

  @Override
  public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
    if(this.validarEstado(edificio.posiblesEstados())){
      casilla.ocupar(edificio);
    }
  }

  @Override
  public void energizarTerreno() {}

  @Override
  public void cubrirTerrenoDeMoho() {}

  @Override
  public void setTerreno(Terreno terreno) {
    this.terreno = terreno;
  }
  
  @Override
  public boolean validarEstado(List<EstadoTerreno> listaDePosiblesTerrenos) {
    for (int i = 0; i < listaDePosiblesTerrenos.size(); i++) {
      if(listaDePosiblesTerrenos.get(i) instanceof TerrenoMineral){
        return true;
      }
    }
    return false;
  }

  @Override
  public void vaciarTerreno(){}

  @Override
  public void generarVolcan() {
    terreno.setState(new TerrenoVolcan());
  }
  @Override
  public void generarMina() {}

  @Override
  public void consumirMinerales(Recursos recursoRequerido) {
    this.terreno.minerales.gastar(recursoRequerido);
  }

  @Override
  public void consumirGasVespeno(Recursos recursoRequerido) {}

}
