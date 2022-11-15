package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import edu.fiuba.algo3.modelo.NoHayLarvasDisponibles;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class CriaderoOperativo implements EstadoCriadero {
    private Criadero criadero;
    private int larvas = 3; //hacer clase Larva (?

    public Zangano generarZangano() throws NoHayLarvasDisponibles {
        if (larvas <= 0) {
            throw new NoHayLarvasDisponibles();
        }
        this.larvas--;
        return new Zangano();
    }

    public Unidad generarUnidad(Unidad unidad) throws NoHayLarvasDisponibles{
        if (larvas <= 0) {
            throw new NoHayLarvasDisponibles();
        }
        this.larvas--;
        return unidad;
    }
    
    @Override
    public Criadero terminarConstruccion() {return criadero;}

    @Override
    public Criadero deshacerConstruccion() {
      criadero.setState(new CriaderoEnConstruccion());
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

}
