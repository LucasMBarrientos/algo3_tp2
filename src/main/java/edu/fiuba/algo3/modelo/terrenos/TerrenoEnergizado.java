package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class TerrenoEnergizado implements EstadoTerreno {
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
  public void cubrirTerrenoDeMoho() {
    terreno.setState(new TerrenoMoho());
  }

  @Override
  public void setTerreno(Terreno terreno) {
    this.terreno = terreno;
  }

  @Override
  public boolean validarEstado(List<EstadoTerreno> listaDePosiblesTerrenos) {
    for (int i = 0; i < listaDePosiblesTerrenos.size(); i++) {
      if(listaDePosiblesTerrenos.get(i) instanceof TerrenoEnergizado){
        return true;
      }
    }
    return false;
  }

  @Override
  public void vaciarTerreno() {
    terreno.setState(new TerrenoVacio());
  }

/* 
    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        casilla.establecerEdificio(pilon);
    }

    public void ocuparPorEdificio(Acceso acceso, Casilla casilla){
        casilla.establecerEdificio(acceso);
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar, Casilla casilla){
        casilla.establecerEdificio(puertoEstelar);
    }

    @Override
    public void ocuparPorEdificio(Criadero criadero, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Espiral espiral, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Extractor extractor, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Guarida guarida, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public boolean esTerrenoEnergizado() {
        return true;
    }

    public boolean esReemplazable(){
        return true;
    }

    public boolean repeleMoho() {
        return true;
    }*/
}
