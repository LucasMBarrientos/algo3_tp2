package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.zerg.CriaderoOperativo;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;
import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class PuertoEstelar extends EdificioProtoss {

    private EstadoPuertoEstelar estado = new PuertoEstelarEnConstruccion();
    private int tiempoDeConstruccion = 10;
    private Recursos costoEnGas= new GasVespeno(150);

    private final Vida vida = new Vida(600);
    private final Escudo escudo = new Escudo(600);

    public PuertoEstelar(){
        this.costoEnMinerales = new Minerales(150);
    }

    @Override
    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }

    public void actualizar(Inventario inventario) {
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new PuertoEstelarOperativo();
        }
        escudo.regenerar();
    }

    public Unidad generarUnidad(Unidad unidad) {
        return estado.generarUnidad(unidad);
    }


/*
    public PuertoEstelar() {
        this.tiempoConstruccion = 10;
        this.requerimientosGas = 150;
        this.requerimientosMinerales = 150;
        this.vida = 600;
        this.escudo = 600;
        this.vidaMax = 600;
        this.escudoMax = 600;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return casilla.devolverTerreno() instanceof TerrenoEnergizado;
    }

    public void actualizar() {
        regenerarEscudo();
    }*/
}
