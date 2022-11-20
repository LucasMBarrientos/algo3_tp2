package edu.fiuba.algo3.modelo.edificios.protoss.asimilador;

import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class AsimiladorOperativo implements EstadoAsimilador{
    private Asimilador asimilador;
    

    @Override
    public Asimilador terminarConstruccion() {return asimilador;}

    @Override
    public Asimilador deshacerConstruccion() {
      asimilador.establecerEstado(new AsimiladorEnConstruccion());
      return asimilador;
    }

    @Override
    public void setAsimilador(Asimilador asimilador) {
      this.asimilador = asimilador;
    }

    @Override
    public void actualizar() {
      this.asimilador.escudo.regenerar();

      // recolectar recursos

    }

    public void recolectarRecursos(Terreno terreno, Inventario inventario){ 
      terreno.extraerGasVespeno(new GasVespeno(20));
      inventario.agregarGasVespeno(new GasVespeno(20));
    }
}
