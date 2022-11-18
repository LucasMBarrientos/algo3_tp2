package edu.fiuba.algo3.modelo.edificios.zerg.extractor;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

import java.util.List;

public class Extractor extends EdificioZerg {
    private EstadoExtractor estado;
    Terreno terreno;

    public Extractor() {
      this.costoEnMinerales = new GasVespeno(50);
      this.posiblesTerrenos = List.of(new TerrenoVolcan());
      this.edificiosNecesarios = List.of();
      this.vida = new Vida(750);
      this.tiempoDeConstruccion = 6;
      establecerEstado(new ExtractorEnConstruccion());
    }

    public void ocupar(Casilla casilla, Terreno terreno){
      terreno.ocuparPorEdificio(this, casilla);
      this.terreno = terreno;
    }
    
    public void actualizar() {
      this.estado.actualizar();
    }

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador, Coordenada coordenada) {
        return null;
    }

    public void establecerEstado(EstadoExtractor estado){
      this.estado = estado;
      this.estado.setExtractor(this);
    }
  
    public Extractor terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }
  
    public Extractor deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }

    public void ingresarUnidad(Zangano zangano) {
      estado.ingresarUnidad(zangano);
    }

    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {

    }
}
