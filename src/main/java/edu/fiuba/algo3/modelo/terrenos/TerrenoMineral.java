package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class TerrenoMineral implements EstadoTerreno{
  private Terreno terreno;

  @Override
  public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
    if(this.validarEstado(edificio.posiblesEstados())){
      casilla.ocupar(edificio);
    }
  }

  @Override
  public void energizarTerreno() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void cubrirTerrenoDeMoho() {
    // TODO Auto-generated method stub
    
  }

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
  /* 
    public Minerales minerales = new Minerales(2000);

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        casilla.establecerEdificio(nexoMineral);
    }

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Acceso acceso, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
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
    public boolean esReemplazable(){
        return false;
    }

    public boolean validarTransitable(Unidad unidad) {
        return true;
    }
    */

}
