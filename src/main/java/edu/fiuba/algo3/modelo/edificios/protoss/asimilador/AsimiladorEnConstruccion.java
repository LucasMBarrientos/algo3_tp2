package edu.fiuba.algo3.modelo.edificios.protoss.asimilador;

import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class AsimiladorEnConstruccion implements EstadoAsimilador{
    private Asimilador asimilador;

    public void recolectarRecursos(Terreno terreno, Inventario inventario)throws EdificioNoTerminoDeConstruirse{ 
      throw new EdificioNoTerminoDeConstruirse();
    }
    
    @Override
    public Asimilador terminarConstruccion() {
      asimilador.establecerEstado(new AsimiladorOperativo());
      return asimilador;
    }

    @Override
    public Asimilador deshacerConstruccion() {
      return asimilador;
    }

    @Override
    public void setAsimilador(Asimilador asimilador) {
      this.asimilador = asimilador;
    }

    @Override
    public void actualizar() {
      if(this.asimilador.reducirTiempoConstruccion(1)){
        this.terminarConstruccion();
      }
    }
}
