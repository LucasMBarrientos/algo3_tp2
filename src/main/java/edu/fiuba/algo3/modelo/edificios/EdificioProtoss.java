package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;

public abstract class EdificioProtoss extends Edificio {

    public Recursos costoEnMinerales;

    public void actualizar() {
        
    }

    public void construirse(Casilla casilla, Inventario inventario){
        if(casilla.devolverEdificio() != null){
            throw new CasillaOcupadaPorEdificio();
        }
        this.ocupar(casilla, casilla.devolverTerreno());

        try {
            this.consumirRecursosParaConstruccion(inventario);
        } catch(RecursosInsuficientes e) {
            casilla.establecerEdificio(null);  //sino habian recursos, saco el edificio de la casilla
            throw new RecursosInsuficientes(); //y vuelvo a lanzar la excepcion
        }
    }

    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
    }

    public abstract void ocupar(Casilla casilla, Terreno terreno);




    /*
    protected int escudo;
    protected int escudoMax;

    protected boolean operativo;

    protected void regenerarEscudo() {
        if (escudo < escudoMax) {
            escudo += (0.2 * escudoMax);
        }
        if (escudo > escudoMax) {
            escudo = escudoMax;
        }
    }

    protected void reducirEscudo(int unidades) {
        escudo -= unidades;
    }

    public boolean recibirDanio(int unidades) {
        if (unidades < escudo) {
            reducirEscudo(unidades);
        } else {
            reducirVida(unidades - escudo);
            escudo = 0;
        }
        return (vida <= 0);
    }

    public void establecerOperatividad(boolean operativo) {
        this.operativo = operativo;
    }

    public boolean devolverOperatividad() {
        return operativo;
    }

    public int devolverEscudo(){
        return escudo;
    }
    
*/
}
