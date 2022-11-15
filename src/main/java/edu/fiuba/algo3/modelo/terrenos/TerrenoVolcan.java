package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class TerrenoVolcan implements EstadoTerreno {
  private Terreno terreno;

  @Override
  public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
    if(this.validarEstado(edificio.posiblesEstados())){
      casilla.ocupar(edificio);
    }
  }

  @Override
  public void energizarTerreno() {
    terreno.setState(new TerrenoEnergizado());
  }

  @Override
  public void cubrirTerrenoDeMoho() {}

  @Override
  public void setTerreno(Terreno terreno) {
    this.terreno = terreno;
  }

  @Override
  public boolean validarEstado(List<EstadoTerreno> listaDePosiblesTerrenos) {
    for (int i = 0; i < listaDePosiblesTerrenos.size(); i++) {
      if(listaDePosiblesTerrenos.get(i) instanceof TerrenoVolcan){
        return true;
      }
    }
    return false;
  }

  @Override
  public void vaciarTerreno(){}

  @Override
  public void generarVolcan() {}

  @Override
  public void generarMina() {
    terreno.setState(new TerrenoMineral());
  }

/*
    public GasVespeno gasVespeno = new GasVespeno(5000);

    public Recursos obtenerRecursos(){
        return gasVespeno;
    }

    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla){
        casilla.establecerEdificio(asimilador);
    }

    public void ocuparPorEdificio(Extractor extractor, Casilla casilla){
        casilla.establecerEdificio(extractor);
    }

    public void ocuparPorEdificio(Criadero criadero, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
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

    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }


    public boolean validarTransitable(Unidad unidad){
        return true;
        /*
        if (unidad == null || unidad instanceof ConstruccionProtoss) {
            return true;
        }
        return  (unidad instanceof Zangano);
        */
/*
    }

    public boolean esReemplazable(){
        return false;
    }
*/
}
