package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class AmoSupremo extends UnidadZerg  {
  public AmoSupremo() {
    this.costoEnGas = new GasVespeno(0);
    this.costoEnMinerales = new Mineral(150);
    this.costoSuministro = new Suministro(0);
    this.tiempoConstruccion = 5;
    this.danioAereo = new Danio(0);
    this.danioTerrestre = new Danio(0);
    this.rango = 0;
    this.vida = new Vida(200);
    this.nombre = new Nombre("AmoSupremo");
    this.aerea = true;
    establecerEstado(new UnidadEnConstruccion());
  }

  @Override
  public boolean ocupar(Terreno terreno) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void actualizarUnidad(Inventario inventario) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ejecutarAtaque(Coordenada objetivo, Mapa mapa) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Unidad generarse(Edificio edificio, Inventario inventario) {
    // TODO Auto-generated method stub
    return null;
  }



}
