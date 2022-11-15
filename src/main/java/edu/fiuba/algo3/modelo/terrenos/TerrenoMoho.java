package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.*;

import java.util.List;

public class TerrenoMoho implements EstadoTerreno {
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
      if(listaDePosiblesTerrenos.get(i) instanceof TerrenoMoho){
        return true;
      }
    }
    return false;
  }

  @Override
  public void vaciarTerreno(){}
/*
    public TerrenoMoho() {

    }

    public void ocuparPorEdificio(Pilon pilon, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Acceso acceso, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(Asimilador asimilador, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    @Override
    public void ocuparPorEdificio(PuertoEstelar puertoEstelar, Casilla casilla) {
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    public void ocuparPorEdificio(Criadero criadero, Casilla casilla){
        casilla.establecerEdificio(criadero);
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reserva, Casilla casilla){
        casilla.establecerEdificio(reserva);
    }

    public void ocuparPorEdificio(Guarida guarida, Casilla casilla){
        casilla.establecerEdificio(guarida);
    }

    public void ocuparPorEdificio(Espiral espiral, Casilla casilla){
        casilla.establecerEdificio(espiral);
    }

    public void ocuparPorEdificio(Extractor extractor, Casilla casilla){
        throw new TerrenoNoAptoParaConstruirEsteEdificio();
    }

    /*
    public void expandirMoho(Mapa mapa){
        List<Casilla> listaAdyacentes = mapa.buscarCasillasAdyacentes(coordenada);
        for(Casilla casilla : listaAdyacentes){
            if(casilla.terrenoRepeleMoho()){
                casilla.establecerTerreno(new TerrenoMoho());
            }
        }
    }
    */
/*
    @Override
    public void actualizarListaDeCoordenadasConMoho(List<Coordenada> cooordenadasDeCasillasConMoho, Coordenada coordenadaActual) {
        List<Coordenada> coordenadasAdyacentes = coordenadaActual.hallarCoordenadasAdyacentes();
        cooordenadasDeCasillasConMoho.addAll(coordenadasAdyacentes);
    }


    public void actualizar() {

    }
*/
}