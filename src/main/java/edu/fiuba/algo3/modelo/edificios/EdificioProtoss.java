package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

import java.util.List;

public abstract class EdificioProtoss extends Edificio {

    public Terreno terreno;
    public Recurso costoEnMinerales;
    public Recurso costoEnGas;
    public Vida vida;
    public Escudo escudo;
    protected Nombre nombre;
    public int tiempoDeConstruccion;


    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
        //TODO: Revisar consumo de gas
    }

    public abstract void validarCorrelativasDeConstruccion(Inventario inventario);

    public abstract void ocupar(Terreno terreno);
    
    public void establecerTerreno(Terreno terreno){
        this.terreno = terreno;
    }


    public Nombre devolverNombre(){
        return nombre;
    }

    public boolean reducirTiempoConstruccion(int tiempoAReducir) {
        if (this.tiempoDeConstruccion-tiempoAReducir > 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion-tiempoAReducir;
            return false;
        } else {
            return true;
        }
    }
    public void recibirGolpe(Danio danioTerrestre, Danio danioAereo) throws EdificioDestruido {
        int escudoRestante;
        escudoRestante = escudo.recibirDanio(danioTerrestre);
        if (escudoRestante < 0) {
            vida.recibirDanio(new Danio(escudoRestante * (-1)));
        }
    }

}
