package edu.fiuba.algo3.modelo.edificios.zerg.extractor;

import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class ExtractorEnConstruccion  implements EstadoExtractor{
    private Extractor extractor;

    public void ingresarUnidad(Zangano zangano) {
        throw new EdificioNoTerminoDeConstruirse();
    }

    public void recolectarRecursos(Terreno terreno, Inventario inventario) { }

    @Override
    public Extractor terminarConstruccion() {
      extractor.establecerEstado(new ExtractorOperativo());
      return extractor;
    }

    @Override
    public Extractor deshacerConstruccion() {
      return extractor;
    }

    @Override
    public void setExtractor(Extractor extractor) {
      this.extractor = extractor;
    }

    @Override
    public void actualizar() {
      if(this.extractor.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}

