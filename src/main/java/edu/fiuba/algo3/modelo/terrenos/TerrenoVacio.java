package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirEsteEdificio;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class TerrenoVacio implements EstadoTerreno {
  private Terreno terreno;

  @Override
  public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
    if(this.validarEstado(edificio.posiblesEstados())){
      casilla.ocupar(edificio);
    }else{
      throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }
  }

  @Override
  public void setTerreno(Terreno terreno) {
    this.terreno = terreno;    
  }

  @Override
  public void energizarTerreno() {
    terreno.setState(new TerrenoEnergizado());
  }

  @Override
  public void cubrirTerrenoDeMoho() {
    terreno.setState(new TerrenoMoho());    
  }

  @Override
  public boolean validarEstado(List<EstadoTerreno> listaDePosiblesTerrenos) {
    for (int i = 0; i < listaDePosiblesTerrenos.size(); i++) {
      if(listaDePosiblesTerrenos.get(i) instanceof TerrenoVacio){
        return true;
      }
    }
    return false;
  }

  @Override
  public void vaciarTerreno() {}

  @Override
  public void generarVolcan() {
    terreno.setState(new TerrenoVolcan());
  }
  
  @Override
  public void generarMina() {
    terreno.setState(new TerrenoMineral());
  }
  
  @Override
  public void consumirMinerales(Recursos recursoRequerido) {}

  @Override
  public void consumirGasVespeno(Recursos recursoRequerido) {}
    //TODO Leti YO xd: codigo repetido x1000, hace un refactor a esto  plis. Nuevas interfaces o excepciones mas especificas?
    /*
    public void ocuparPorEdificio(Edificio edificio, Casilla casilla){

    }
    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        casilla.establecerEdificio(pilon);
    }
    public void ocuparPorEdificio(Criadero criadero, Casilla casilla){
        casilla.establecerEdificio(criadero);
    }

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla, TerrenoVacio terreno){
        casilla.establecerEdificio(pilon);
    }

    public void ocuparPorEdificio(Extractor extractor, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reserva, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Guarida guarida, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Espiral espiral, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }


    public void ocuparPorEdificio(Acceso acceso, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public Recursos obtenerRecursos(){return null;}

    public boolean esReemplazable(){
        return true;
    }
    public boolean repeleMoho() {
        return false;
    }


    protected boolean validarTransitable(Unidad unidad){
        return true;
    }
    */
}
