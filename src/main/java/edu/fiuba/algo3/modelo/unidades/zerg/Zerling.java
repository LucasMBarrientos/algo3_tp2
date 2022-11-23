package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

public class Zerling extends UnidadZerg {

    public Zerling() {
        this.costoEnGas = new GasVespeno(0);
        this.costoEnMinerales = new Mineral(25);
        this.tiempoConstruccion = 2;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(4);
        this.rango = 1;
        this.vida = new Vida(35);
        this.nombre = new Nombre("Zerling");
        establecerEstado(new UnidadEnConstruccion());
    }

    public Unidad generarse(Edificio edificio, Inventario inventario){
        return edificio.generarUnidad(this, inventario);
    }

    public boolean ocupar(Terreno terreno){
        boolean sePudoOcupar = true;

        try {
            terreno.ocuparPorUnidad(this);
        } catch (RuntimeException e){
            sePudoOcupar = false;
        }

        return sePudoOcupar;
    }

    @Override
    public void actualizarUnidad(Inventario inventario) {
      regenerar();
    }
    
    @Override
    public void ejecutarAtaque(Coordenada objetivo, Mapa mapa) {
      if (this.coordenada.seEncuentraACiertoRangoDeOtraCoordenada(objetivo, rango)) {
        mapa.buscarTerreno(objetivo).recibirDanio(danioTerrestre,danioAereo); //la logica seria pasarle ambos daños, q despues la unidad objetivo se encargue de ver cual
      } else {
          throw new AtaqueImposibleDeRealizarse(); // TODO: posiblemente implementar una excepcion "AtaqueFueraDeRango"
      }
    }
}
