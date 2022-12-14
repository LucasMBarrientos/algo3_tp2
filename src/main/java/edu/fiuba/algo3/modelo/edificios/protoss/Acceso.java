package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.estadisticas.Nombre;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioInoperativo;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;

public class Acceso extends EdificioProtoss {

    public Acceso() {
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 8;
        this.vida = new Vida(500);
        this.escudo = new Escudo(500);
        this.nombre = new Nombre("Acceso");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
    }

    @Override
    public Unidad generarUnidad(Zealot unidad, Inventario inventario) {
        return estadoActual.generarUnidad(unidad, inventario);
    }

    @Override
    public Unidad generarUnidad(Dragon unidad, Inventario inventario) {
        return estadoActual.generarUnidad(unidad, inventario);
    }

    public void ocupar(Terreno terreno) {
        terreno.ocuparPorEdificio(this);
    }

    @Override
    public void volverEdificioInoperativo(){
        establecerEstado(new EdificioInoperativo());
    }

}
