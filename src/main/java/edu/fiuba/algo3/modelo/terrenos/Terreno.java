package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public class Terreno {
 
  private EstadoTerreno estado;

  public Terreno(){
    setState(new TerrenoVacio());
  }

  public void setState(EstadoTerreno estado){
    this.estado = estado;
    this.estado.setTerreno(this);
  }

  public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
    this.estado.ocuparPorEdificio(edificio,casilla);
  }

  public void vaciarTerreno(){
    this.estado.vaciarTerreno();
  }

  public void energizarTerreno(){
    this.estado.energizarTerreno();
  }

  public void cubrirTerrenoDeMoho() {
    this.estado.cubrirTerrenoDeMoho();
  }

  public void generarVolcan() {
    this.estado.generarVolcan();
  }


  public void generarMina() {
    this.estado.generarMina();
  }
    /*public Recursos obtenerRecursos() {
        return null;
    }

    public abstract void ocuparPorEdificio(Pilon pilon, Casilla casilla);

    public abstract void ocuparPorEdificio(Acceso acceso, Casilla casilla);

    public abstract void ocuparPorEdificio(Asimilador asimilador, Casilla casilla);

    public abstract void ocuparPorEdificio(NexoMineral nexoMineral, Casilla casilla);

    public abstract void ocuparPorEdificio(PuertoEstelar puertoEstelar, Casilla casilla);

    public abstract void ocuparPorEdificio(Criadero criadero, Casilla casilla);

    public abstract void ocuparPorEdificio(Espiral espiral, Casilla casilla);

    public abstract void ocuparPorEdificio(Extractor extractor, Casilla casilla);

    public abstract void ocuparPorEdificio(Guarida guarida, Casilla casilla);

    public abstract void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion, Casilla casilla);

    public void actualizarListaDeCoordenadasConMoho(List<Coordenada> cooordenadasDeCasillasConMoho, Coordenada coordenada) {
        return;
    }

    public boolean esReemplazable() {
        return false;
    }

    public boolean repeleMoho() {
        return true;
    }
*/

}
