package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.unidades.estados.UnidadEnConstruccion;

public class Devorador extends UnidadZerg {

    public Devorador() {
        this.costoEnGas = new GasVespeno(50);
        this.costoEnMinerales = new Mineral(150);
        this.tiempoConstruccion = 4;
        this.danioAereo = new Danio(15);
        this.rango = 5;
        this.vida = new Vida(200);
        this.nombre = new Nombre("Devorador");
        this.aerea = true;
        establecerEstado(new UnidadEnConstruccion());
    }

    @Override
    public void actualizarUnidad(Inventario inventario) {
        regenerar();
    }

    public boolean ocupar(Terreno terreno) {
        boolean sePudoOcupar = true;

        try {
            terreno.ocuparPorUnidad(this);
        } catch (RuntimeException e){
            sePudoOcupar = false;
        }

        return sePudoOcupar;
    }

    @Override
    public Unidad generarse(Edificio edificio, Inventario inventario) {
        return null;
    }

}
