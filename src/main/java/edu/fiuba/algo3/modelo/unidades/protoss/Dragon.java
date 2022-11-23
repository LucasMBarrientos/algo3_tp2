package edu.fiuba.algo3.modelo.unidades.protoss;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.UnidadProtoss;

public class Dragon extends UnidadProtoss {

    public Dragon() {
        this.costoEnMinerales = new Mineral(125);
        this.costoEnGas = new GasVespeno(50);
        this.costoSuministro = new Suministro(3);
        this.tiempoConstruccion = 6;
        this.danioAereo = new Danio(20);
        this.danioTerrestre = new Danio(20);
        this.rango = 4;
        this.vida = new Vida(100);
        this.escudo = new Escudo(80);
        this.nombre = new Nombre("Dragon");
        establecerEstado(new UnidadEnConstruccion());
    }
    
    public Unidad generarse(Edificio edificio, Inventario inventario){
        return edificio.generarUnidad(this,inventario);
    }

    public boolean ocupar(Terreno terreno){
        boolean sePudoOcupar = true;

        try {
            terreno.ocuparPorUnidad(this);
        } catch (RuntimeException e){ //ver que esto ande, porque puede lanzar excepciones diferentes
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
