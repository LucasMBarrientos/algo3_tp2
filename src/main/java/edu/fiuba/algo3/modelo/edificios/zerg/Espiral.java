package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Nombre;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.*;

public class Espiral extends EdificioZerg {

    public Espiral() {
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(100);
        this.vida = new Vida(300);
        this.tiempoDeConstruccion = 10;
        this.nombre = new Nombre("Espiral");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
    }

    @Override
    public void validarCorrelativasDeConstruccion(Inventario inventario) throws ConstruccionRequiereDeOtroEdificio {
        if (!(inventario.tieneEdificio(new Nombre("Guarida")))) {
            throw new ConstruccionRequiereDeOtroEdificio();
        }
    }

    public void ocupar(Terreno terreno) {
        terreno.ocuparPorEdificio(this);
    }
    
    @Override
    public Unidad generarUnidad(Mutalisco unidad, Inventario inventario) {
        return estadoActual.generarUnidad(unidad,inventario);
    }

}
