package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioInoperativo;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Asimilador extends EdificioProtoss {

    public Asimilador() {
        this.costoEnMinerales = new Mineral(100);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 6;
        this.vida = new Vida(450);
        this.escudo = new Escudo(450);
        this.nombre = new Nombre("Asimilador");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
        extraerRecursos(inventario);
    }

    public void ocupar(Terreno terreno) {
        terreno.ocuparPorEdificio(this);
        this.terreno = terreno;
    }

    public void extraerRecursos(Inventario inventario) {
        try {
            terreno.extraerGasVespeno(new GasVespeno(20));
            inventario.agregarGasVespeno(new GasVespeno(20));
        } catch (RecursosInsuficientes terrenoSinGasVespeno) {
            establecerEstado(new EdificioInoperativo());
            throw terrenoSinGasVespeno;
        }
    }


}
