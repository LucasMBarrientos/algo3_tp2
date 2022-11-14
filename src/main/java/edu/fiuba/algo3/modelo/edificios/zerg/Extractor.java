package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

import java.util.ArrayList;
import java.util.List;

public class Extractor extends EdificioZerg {

    private EstadoExtractor estado = new ExtractorEnConstruccion();

    private Terreno terreno;

    private final Vida vida = new Vida(750);

    private int tiempoDeConstruccion = 6;

    private Coordenada coordenada;

    public Extractor() {
        this.costoEnMinerales = new GasVespeno(50);
    }
    public Extractor(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void ingresarUnidad(Zangano zangano) {
        estado.ingresarUnidad(zangano);
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
        this.terreno = terreno;
    }


    public void actualizar(Inventario inventario){
        tiempoDeConstruccion--;
        if(tiempoDeConstruccion == 0){
            estado = new ExtractorOperativo();
        }
        recolectarRecursos(inventario);
        vida.regenerar();
    }

    public void recolectarRecursos(Inventario inventario) {
        estado.recolectarRecursos(terreno, inventario);
    }


/*
    public List<Unidad> zanganosTrabajando = new ArrayList<Unidad>();

    private Boolean recursosRecolectados = false;

    public int recursosRestantes = 5000;
        
    public Extractor() {
        this.tiempoConstruccion = 6;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 100;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return (casilla.devolverTerreno() instanceof TerrenoVolcan);
    }

    public void actualizar() {
        recursosRecolectados = false;
        regenerarVida();
    }

    public boolean ingresarUnidad(Unidad unidad) {
        if(zanganosTrabajando.size() < 3){
            zanganosTrabajando.add(unidad);
            return true;
        }
        return false;
    }

    @Override
    public Recursos recolectarRecursos() {
        recursosRecolectados = true;
        if(recursosRestantes > 0){
            recursosRestantes -= (10 * zanganosTrabajando.size());
            return new GasVespeno(10 * zanganosTrabajando.size());
        }
        return new GasVespeno(0);
    }

    @Override
    public boolean tieneRecursos() {
        return !(recursosRecolectados);
    }*/
}
