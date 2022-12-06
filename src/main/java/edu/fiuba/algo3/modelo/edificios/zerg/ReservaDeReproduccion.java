package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class ReservaDeReproduccion extends EdificioZerg {

    public ReservaDeReproduccion() {
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(0);
        this.vida = new Vida(1000);
        this.tiempoDeConstruccion = 12;
        this.nombre = new Nombre("ReservaDeReproduccion");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
    }

    @Override
    public Unidad generarUnidad(Zerling unidad, Inventario inventario) {
        return estadoActual.generarUnidad(unidad,inventario);
    }

    public void ocupar(Terreno terreno) {
        terreno.ocuparPorEdificio(this);
    }

}
