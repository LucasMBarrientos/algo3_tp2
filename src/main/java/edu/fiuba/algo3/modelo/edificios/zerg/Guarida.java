package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class Guarida extends EdificioZerg {
    
    public Guarida() {
        this.costoEnMinerales = new Mineral(200);
        this.costoEnGas = new GasVespeno(100);
        this.vida = new Vida(1250);
        this.tiempoDeConstruccion = 12;
        this.nombre = new Nombre("Guarida");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
    }

    @Override
    public void validarCorrelativasDeConstruccion(Inventario inventario) throws ConstruccionRequiereDeOtroEdificio {
        if(!inventario.tieneEdificio(new Nombre("ReservaDeReproduccion"))){
            throw new ConstruccionRequiereDeOtroEdificio();
        }
    }

    public void ocupar(Terreno terreno) {
        terreno.ocuparPorEdificio(this);
    }

    public Unidad generarUnidad(Hidralisco unidad, Inventario inventario) {
        return estadoActual.generarUnidad(unidad,inventario);
    }

}
