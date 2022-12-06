package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;

public class PuertoEstelar extends EdificioProtoss {

    public PuertoEstelar(){
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(150);
        this.tiempoDeConstruccion = 10;
        this.vida = new Vida(600);
        this.escudo = new Escudo(600);
        this.nombre = new Nombre("PuertoEstelar");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
    }

    public void ocupar(Terreno terreno) {
        terreno.ocuparPorEdificio(this);
    }

    public Unidad generarUnidad(Scout unidad, Inventario inventario)  {
        return estadoActual.generarUnidad(unidad,inventario);
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) throws ConstruccionRequiereDeOtroEdificio {
        if (!(inventario.tieneEdificio(new Nombre("Acceso")))) {
            throw new ConstruccionRequiereDeOtroEdificio();
        }
    }

}
