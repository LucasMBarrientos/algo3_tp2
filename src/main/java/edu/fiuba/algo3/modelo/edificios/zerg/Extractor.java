package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.edificios.estados.EdificioInoperativo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.excepciones.NoHayEspacioDisponible;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

import java.util.ArrayList;
import java.util.List;

public class Extractor extends EdificioZerg {

    private List<Unidad> zanganosTrabajando = new ArrayList<Unidad>();

    public Extractor() {
        this.costoEnMinerales = new Mineral(100);
        this.costoEnGas = new GasVespeno(0);
        this.vida = new Vida(750);
        this.tiempoDeConstruccion = 6;
        this.nombre = new Nombre("Extractor");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
        extraerRecursos(inventario);
    }

    @Override
    public void ingresarUnidadTrabajadora(Unidad unidad) throws NoHayEspacioDisponible, EdificioNoConoceEstaUnidad {
        if (!(unidad.devolverNombre().esIgual(new Nombre("Zangano")))) {
            throw new EdificioNoConoceEstaUnidad();
        }
        if (zanganosTrabajando.size() < 3) {
            zanganosTrabajando.add(unidad);
        } else {
            throw new NoHayEspacioDisponible();
        }
    }

    public void ocupar(Terreno terreno) {
        terreno.ocuparPorEdificio(this);
        this.terreno = terreno;
    }

    public void extraerRecursos(Inventario inventario) {
        try {
            terreno.extraerGasVespeno(new GasVespeno(10* zanganosTrabajando.size()));
            inventario.agregarGasVespeno(new GasVespeno(10* zanganosTrabajando.size()));
        } catch (RecursosInsuficientes terrenoSinGasVespeno) {
            establecerEstado(new EdificioInoperativo());
            throw terrenoSinGasVespeno;
        }
    }

}
