package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.EstadoTerreno;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class EdificioZerg extends Edificio {

    public Terreno terreno;
    public Recurso costoEnMinerales;
    public Recurso costoEnGas;
    public Vida vida;
    protected Nombre nombre;
    public int tiempoDeConstruccion;

    public void consumirRecursosParaConstruccion(Inventario inventario) {
        inventario.consumirMinerales(costoEnMinerales);
    }

    public abstract void validarCorrelativasDeConstruccion(Inventario inventario);

    public abstract void ocupar(Terreno terreno);

    public void establecerTerreno(Terreno terreno) {
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

    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }

}
