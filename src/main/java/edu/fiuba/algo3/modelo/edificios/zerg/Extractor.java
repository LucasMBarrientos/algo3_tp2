package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Zangano;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.TieneRecursos;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

import java.util.ArrayList;
import java.util.List;

public class Extractor extends EdificioZerg {

    private EstadoExtractor estado = new ExtractorEnConstruccion();

    private int tiempoDeConstruccion = 6;
    private Coordenada coordenada;

    public Extractor(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void ingresarUnidad(Zangano zangano) {
        estado.ingresarUnidad(zangano);
    }

    public void actualizar() {
        estado.actualizar();
        tiempoDeConstruccion--;
        if(tiempoDeConstruccion == 0){
            estado = new ExtractorOperativo();
        }
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
