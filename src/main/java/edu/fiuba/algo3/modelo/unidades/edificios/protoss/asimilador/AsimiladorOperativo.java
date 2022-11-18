package edu.fiuba.algo3.modelo.unidades.edificios.protoss.asimilador;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class AsimiladorOperativo implements EstadoAsimilador{
    private Asimilador asimilador;
    public void recolectarRecursos(Terreno terreno, Inventario inventario){ }

    @Override
    public Asimilador terminarConstruccion() {return asimilador;}

    @Override
    public Asimilador deshacerConstruccion() {
      asimilador.setState(new AsimiladorEnConstruccion());
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

    /*public void recolectarRecursos(Terreno terreno, Inventario inventario){
        recursosAExtraer = new GasVespeno(20);
        Recursos gasDelVolcan = terreno.obtenerRecursos();
        gasDelVolcan.gastar(recursosAExtraer);
        inventario.actualizarGasVespeno(recursosAExtraer);
    }*/
}
