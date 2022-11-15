package edu.fiuba.algo3.modelo.edificios.protoss;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.zerg.CriaderoOperativo;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;

public class Asimilador extends EdificioProtoss {

    private EstadoAsimilador estado = new AsimiladorEnConstruccion();

    Terreno terreno;
    private int tiempoDeConstruccion = 6;
    private final Vida vida = new Vida(450);

    private final Escudo escudo = new Escudo(450);
    public Asimilador(){
        this.costoEnMinerales = new Minerales(100);
        this.posiblesTerrenos = List.of(new TerrenoVolcan());
        this.edificiosNecesarios = List.of();
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
        this.terreno = terreno;
    }

    public void actualizar(Inventario inventario) {
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new AsimiladorOperativo();
        }
        vida.regenerar();
        recolectarRecursos(inventario);
    }
    public void recolectarRecursos(Inventario inventario) {
        estado.recolectarRecursos(terreno, inventario);
    }






/*
    public Asimilador() {
        this.tiempoConstruccion = 6;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 100;
    }

    @Override
    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return false;
    }

    @Override
    public void actualizar() {
        regenerarEscudo();
    }*/
}