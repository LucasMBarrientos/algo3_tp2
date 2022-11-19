package edu.fiuba.algo3.modelo.edificios.zerg.extractor;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import java.util.ArrayList;
import java.util.List;

public class ExtractorOperativo implements EstadoExtractor {
  private Extractor extractor;
  private List<Zangano> zanganosTrabajando = new ArrayList<Zangano>();

  @Override
  public Extractor terminarConstruccion() {return extractor;}

  @Override
  public Extractor deshacerConstruccion() {
    extractor.setState(new ExtractorEnConstruccion());
    return extractor;
  }

  @Override
  public void setExtractor(Extractor extractor) {
    this.extractor = extractor;
  }

  @Override
  public void actualizar() {
    this.extractor.vida.regenerar();
  }


  //TODO: REVISAR
  public void recolectarRecursos(Terreno terreno, Inventario inventario){ }

  public void ingresarUnidad(Zangano zangano) {
    if(zanganosTrabajando.size() < 3){
      zanganosTrabajando.add(zangano);
    }
  }
}
