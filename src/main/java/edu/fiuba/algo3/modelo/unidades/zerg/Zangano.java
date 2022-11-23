package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class Zangano extends UnidadZerg {
    private Terreno terreno;

    public Zangano() {
        this.costoEnGas = new GasVespeno(0);
        this.costoEnMinerales = new Mineral(25);
        this.tiempoConstruccion = 1;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(0);
        this.rango = 0;
        this.vida = new Vida(25);
        this.nombre = new Nombre("Zangano");
        establecerEstado(new UnidadEnConstruccion());
    }

    public void construirEdificio(EdificioZerg edificio, Coordenada coordenada) {
        // TODO: Implementar esto
    }

    /*public void consumirRecursosParaGenerarse(Inventario inventario){

    }*/
    public Unidad generarse(Edificio edificio, Inventario inventario){
        return edificio.generarUnidad(this, inventario);
    }

    public boolean ocupar(Terreno terreno){
        boolean sePudoOcupar = true;

        try {
            terreno.ocuparPorUnidad(this);
            this.terreno = terreno;
        } catch (RuntimeException e){
            sePudoOcupar = false;
        }


        return sePudoOcupar;
    }

    @Override
    public void intentarOcuparAlMoverse(Terreno terreno) throws TerrenoNoAptoParaTalUnidad {
        terreno.ocuparPorUnidad(this);
    }

    public void extraerRecursos(Inventario inventario){
        inventario.agregarMinerales(this.terreno.extraerMinerales(new Mineral(10)));
    }

    @Override
    public void actualizarUnidad(Inventario inventario) {
      regenerar();
      extraerRecursos(inventario);
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
