package edu.fiuba.algo3.modelo.edificios.protoss;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Pilon extends EdificioProtoss {

    private Recurso suministroAAgregar = new Suministro(5);

    public Pilon() {
        this.costoEnMinerales = new Mineral(100);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 5;
        this.vida = new Vida(300);
        this.escudo = new Escudo(300);
        this.nombre = new Nombre("Pilon");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
    }

    @Override
    public void actualizarListasDeCoordenadasSegunEdificio(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        coordenadasConPilones.add(coordenada);
    }
    
    @Override
    public void agregarSuministro(Inventario inventario) {
        inventario.agregarSuministro(suministroAAgregar);
    }

    @Override
    public void restarSuministros(Inventario inventario) {
        inventario.restarSuministro(suministroAAgregar);
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
        this.terreno = terreno;
    }
    

}
