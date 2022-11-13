package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;

public abstract class EdificioZerg extends Edificio {

    public Recursos costoEnMinerales;

    public void actualizar() { }

    public void construirse(Casilla casilla, Inventario inventario){
        //TODO Leti: verificar que exista un zangano parado en esa casilla, sino lanzar exepcion

        casilla.ocuparPorEdificio(this);

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

/*
    protected void regenerarVida() {
        if (vida < vidaMax) {
            vida += (0.1 * vidaMax);
        }
        if (vida > vidaMax) {
            vida = vidaMax;
        }
    }

    public boolean recibirDanio(int unidades) {
        reducirVida(unidades);
        return (vida <= 0);
    }
*/
}