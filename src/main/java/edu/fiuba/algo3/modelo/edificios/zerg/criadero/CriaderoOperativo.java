package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.recursos.*;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class CriaderoOperativo implements EstadoCriadero {
    
    private Criadero criadero;
    private int larvas = 3;

    public Unidad generarUnidad(Zangano unidad) throws NoHayLarvasSuficientes {
        if (larvas <= 0) {
            throw new NoHayLarvasSuficientes();
        }
        this.larvas--;
        return unidad;
    }

    public int contarLarvas() {
        return this.larvas;
    }

    public void consumirLarva() {
        this.larvas--;
    }
    
    @Override
    public Criadero terminarConstruccion() {return criadero;}

    @Override
    public Criadero deshacerConstruccion() {
      criadero.establecerEstado(new CriaderoEnConstruccion());
      return criadero;
    }

    @Override
    public void setCriadero(Criadero criadero) {
      this.criadero = criadero;
    }

    @Override
    public void actualizar() {
        this.criadero.vida.regenerar();
        
        // regenerar larvas?
        if (larvas < 3) {
            this.larvas++;
        }

    }

    public void actualizarListaDeCoordenadasConCriaderosOperativos(Coordenada coordenada, List<Coordenada> coordenadasConCriaderos) {
        coordenadasConCriaderos.add(coordenada);
    }

}
