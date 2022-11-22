package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class Criadero extends EdificioZerg {

    Terreno terreno;
    private int larvas = 3;

    public Criadero() {
        this.costoEnMinerales = new Mineral(200);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 4;
        this.vida = new Vida(500);
        this.nombre = new Nombre("Criadero");
        establecerEstado(this.estadoConstruccion);
    }

    @Override
    public boolean consumirLarva() {
      if (larvas <= 0) {
        return false;
      }else{
        this.larvas--;
        return true;
      }
    }

   // @Override
   // public Unidad consumirLarvasYGenerarUnidad(Unidad unidad) {
   //     return estado.generarUnidad(unidad);
   // }

    /*public Criadero(Coordenada coordenada) {
        this.coordenada = coordenada;
    }*/
    
    /*
    @Override
    public Unidad generarUnidad(Unidad unidad) throws NoHayLarvasDisponibles {
        return estado.generarUnidad(unidad);
    }
    */

    /*@Override
    public void actualizarListaDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        estado.actualizarListaDeCoordenadasConCriaderosOperativos(coordenada, coordenadasConCriaderos);
    }*/

    /*@Override
    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
    }*/


    /*public void ocupar(Casilla casilla, Terreno terreno){

        terreno.ocuparPorEdificio(this, casilla);
    }*/

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }


    public void validarCorrelativasDeConstruccion(Inventario inventario) {
    }

    public Unidad generarUnidad(Zangano unidad,Inventario inventario){
        return estadoActual.generarUnidad(unidad,inventario);
    }
    public Unidad generarUnidad(Hidralisco unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zerling unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Mutalisco unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Scout unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zealot unidad,Inventario inventario) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Dragon unidad,Inventario inventario)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
      regenerar();
      
      // regenerar larvas?
      if (larvas < 3) {
        this.larvas++;
    }
    }

}
