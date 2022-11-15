package edu.fiuba.algo3.modelo.edificios.protoss;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.edificios.zerg.CriaderoEnConstruccion;
import edu.fiuba.algo3.modelo.edificios.zerg.EstadoCriadero;
import edu.fiuba.algo3.modelo.edificios.zerg.ExtractorOperativo;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;

public class NexoMineral extends EdificioProtoss {
    private int tiempoDeConstruccion = 4;

    private Terreno terreno;
    private final Vida vida = new Vida(300);

    private final Escudo escudo = new Escudo(300);
    private EstadoNexoMineral estado = new NexoMineralEnConstruccion();

    public NexoMineral(){
        this.costoEnMinerales = new Minerales(50);
        this.posiblesTerrenos = List.of(new TerrenoMineral());
        this.edificiosNecesarios = List.of();
    }

    public void actualizar() {}
    public void actualizar(Inventario inventario) {
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new NexoMineralOperativo();
        }
        escudo.regenerar();
        recolectarRecursos(inventario);
    }
    public void recolectarRecursos(Inventario inventario) {
        estado.recolectarRecursos(terreno, inventario);
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
        this.terreno= terreno;
    }

/*
    private Boolean recursosRecolectados = false;

    public NexoMineral() {
        this.tiempoConstruccion = 4;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 50;
    }
    @Override
    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return false;
    }

    @Override
    public void actualizar() {
        recursosRecolectados = false;
        regenerarEscudo();
    }

    public Recursos recolectarRecursos() {
        recursosRecolectados = true;
        return new Minerales(10);
    }


    public boolean tieneRecursos() {
        return !(recursosRecolectados);
    }*/
}
