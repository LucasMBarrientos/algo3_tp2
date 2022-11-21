package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class Unidad {

    protected Recurso costoEnMinerales;
    protected Recurso costoEnGas;
    protected int tiempoConstruccion = 1;
    protected Coordenada coordenada;
    protected Danio danioAereo;
    protected Danio danioTerrestre;
    protected int rango = 0;
    protected Vida vida;
    protected EstadoUnidad estado = new UnidadEnConstruccion();
    protected Nombre nombre;
    protected boolean aerea = false;

    public boolean compararCoordenadas(Coordenada coordenadaAComparar) {
        return coordenada.esIgual(coordenadaAComparar);
    }

    public void actualizar() {
        tiempoConstruccion--;
        if(tiempoConstruccion == 0){
            estado = new UnidadOperativa(danioAereo, danioTerrestre, rango);
        }
        vida.regenerar();
    }

    public void establecerCoordenada(Coordenada coordenada){
        this.coordenada = coordenada;
    }

    public void moverse(Direccion direccion, Mapa mapa) {
        estado.moverse(direccion,mapa, coordenada, this);
    }

    public void atacar(Coordenada objetivo, Mapa mapa) {
        estado.atacar(objetivo, mapa);
    }

    public abstract Unidad generarse(Edificio edificio);

    public abstract boolean ocupar(Terreno terreno);

    public Nombre devolverNombre(){
        return nombre;
    }

    public void consumirRecursosParaGenerarse(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        inventario.consumirGasVespeno(costoEnGas);
    }

    public void restaurarRecursosParaConstruccion(Inventario inventario){
        inventario.devolverMinerales(costoEnMinerales);
        inventario.devolverGasVespeno(costoEnGas);
    }
}
