package edu.fiuba.algo3.modelo.edificios.zerg.extractor;

import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public interface EstadoExtractor {

    public void ingresarUnidad(Zangano zangano);

    public void recolectarRecursos(Terreno terreno, Inventario inventario);

    Extractor terminarConstruccion();
  
    Extractor deshacerConstruccion();
  
    void setExtractor(Extractor extractor);
  
    void actualizar();
}
