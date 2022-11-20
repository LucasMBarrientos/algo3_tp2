package edu.fiuba.algo3.modelo.edificios.protoss.asimilador;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Asimilador extends EdificioProtoss {

    private EstadoAsimilador estado;

    public Asimilador() {
        this.costoEnMinerales = new Mineral(100);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 6;
        this.vida = new Vida(450);
        this.escudo = new Escudo(450);
        establecerEstado(new AsimiladorEnConstruccion());
    }

    public void ocupar(Terreno terreno) {
        terreno.ocuparPorEdificio(this);
        this.terreno = terreno;
    }

    //TODO: REVISAR
    public void recolectarRecursos(Inventario inventario) {
        estado.recolectarRecursos(terreno, inventario);
    }

    public void actualizar() {
        this.estado.actualizar();
    }

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) {
        return null;
    }


    public void establecerEstado(EstadoAsimilador estado) {
        this.estado = estado;
        this.estado.setAsimilador(this);
    }

    public Asimilador terminarConstruccion() {
        return this.estado.terminarConstruccion();
    }

    public Asimilador deshacerConstruccion() {
        return this.estado.deshacerConstruccion();
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) {
    }

    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {
        int escudoRestante;
        escudoRestante = escudo.recibirDanio(danioTerestre);
        if (escudoRestante < 0) {
            vida.recibirDanio(new Danio(escudoRestante * (-1)));
        }
    }
}
