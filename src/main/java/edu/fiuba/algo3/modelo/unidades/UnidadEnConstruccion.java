package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;

public class UnidadEnConstruccion implements EstadoUnidad {
    protected Unidad unidad;
    
    public void moverse(Direccion direccion, Mapa mapa, Coordenada coordenada) {
        throw new UnidadNoTerminoDeConstruirse();
    }

    @Override
    public void atacar(Coordenada objetivo, Mapa mapa) {
      throw new UnidadNoTerminoDeConstruirse();
    }

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
      this.unidad.ejecutarDanio(danioTerrestre, danioAereo);
    }

    @Override
    public void actualizar(Inventario inventario) {
      if(this.unidad.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }

    @Override
    public void setUnidad(Unidad unidad) {
      this.unidad = unidad;      
    }

    @Override
    public void terminarConstruccion() {
      unidad.establecerEstado(new UnidadOperativa());      
    }

    @Override
    public void deshacerConstruccion() {
      // TODO Auto-generated method stub
      
    }
}
