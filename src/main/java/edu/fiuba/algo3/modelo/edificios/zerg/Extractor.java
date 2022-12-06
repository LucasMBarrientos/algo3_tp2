package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.excepciones.NoHayEspacioDisponible;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

import java.util.ArrayList;
import java.util.List;

public class Extractor extends EdificioZerg {

    Terreno terreno;
    private List<Unidad> zanganosTrabajando = new ArrayList<Unidad>();

    public Extractor() {
        this.costoEnMinerales = new Mineral(100);
        this.costoEnGas = new GasVespeno(0);
        this.vida = new Vida(750);
        this.tiempoDeConstruccion = 6;
        this.nombre = new Nombre("Extractor");
        establecerEstado(this.estadoConstruccion);
    }

    public void ocupar(Terreno terreno) {
      terreno.ocuparPorEdificio(this);
      this.terreno = terreno;
    }

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

    public void extraerRecursos(Inventario inventario) {
      terreno.extraerGasVespeno(new GasVespeno(10* zanganosTrabajando.size()));
      inventario.agregarGasVespeno(new GasVespeno(10* zanganosTrabajando.size()));
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
      regenerar();
      extraerRecursos(inventario);
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) {
        return;
    }

    public Unidad generarUnidad(Zerling unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Zangano unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Hidralisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Mutalisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Scout unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Zealot unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(Dragon unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public Unidad generarUnidad(AmoSupremo unidad, Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

}
