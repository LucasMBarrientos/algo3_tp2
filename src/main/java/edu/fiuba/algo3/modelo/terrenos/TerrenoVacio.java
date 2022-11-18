package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public class TerrenoVacio implements EstadoTerreno {
  private Terreno terreno;

  @Override
  public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
    if(this.validarEstado(edificio.posiblesEstados())){
      casilla.ocupar(edificio);
    }else{
      throw new TerrenoNoAptoParaConstruirTalEdificio();
    }
  }

  @Override
  public void setTerreno(Terreno terreno) {
    this.terreno = terreno;    
  }

  @Override
  public void energizarTerreno() {
    terreno.establecerEstado(new TerrenoEnergizado());
  }

  @Override
  public void cubrirTerrenoDeMoho() {
    terreno.establecerEstado(new TerrenoMoho());    
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
    terreno.establecerEstado(new TerrenoVolcan());
  }
  
  @Override
  public void generarMina() {
    terreno.establecerEstado(new TerrenoMineral());
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
