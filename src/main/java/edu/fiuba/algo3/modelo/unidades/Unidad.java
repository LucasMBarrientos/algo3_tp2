package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class Unidad {

    protected Recurso costoEnMinerales;
    protected Recurso costoEnGas;
    protected int tiempoConstruccion = 1;
    protected Coordenada coordenada;
    protected Danio danioAereo = new Danio(0);
    protected Danio danioTerrestre = new Danio(0);
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
            estado = new UnidadOperativa(danioAereo, danioTerrestre, rango, coordenada);
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

    public void intentarOcuparAlMoverse(Terreno terreno){    }

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo) {
        this.estado.recibirDanio(danioTerrestre, danioAereo, this);
    }
    
    public void ejecutarDanio(Danio danioTerrestre, Danio danioAereo) {
        if (aerea) {
            if (this.vida.recibirDanio(danioAereo)) {
                throw new UnidadEstaDestruida();
            }
        } else {
            if (this.vida.recibirDanio(danioTerrestre)) {
                throw new UnidadEstaDestruida();
            }
        }
    }


    public void recolectarRecursos(Terreno terreno, Inventario inventario){    }

    public abstract Unidad generarse(Edificio edificio, Inventario inventario);

    public abstract boolean ocupar(Terreno terreno);

    public Nombre devolverNombre(){
        return nombre;
    }

    public abstract void consumirRecursosParaGenerarse(Inventario inventario);

    public void restaurarRecursosParaConstruccion(Inventario inventario){
        inventario.devolverMinerales(costoEnMinerales);
        inventario.devolverGasVespeno(costoEnGas);
    }
}
