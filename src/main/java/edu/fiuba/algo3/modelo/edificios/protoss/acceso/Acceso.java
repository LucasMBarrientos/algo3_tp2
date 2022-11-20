package edu.fiuba.algo3.modelo.edificios.protoss.acceso;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;

import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class Acceso extends EdificioProtoss {
    private EstadoAcceso estado;
    public Acceso(){
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 8;
        this.vida = new Vida(500);
        this.escudo = new Escudo(500);
        establecerEstado(new AccesoEnConstruccion());
    }

    public void ocupar(Terreno terreno){

        terreno.ocuparPorEdificio(this);
    }

    public void establecerEstado(EstadoAcceso estado){
      this.estado = estado;
      this.estado.setAcceso(this);
    }

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) {
        return estado.generarUnidad( edificioConLarvas,  gasVespeno, mineral,  coordenada);
    }

    public Unidad generarUnidad(Zealot unidad)  {
        return unidad;
    }
    public Unidad generarUnidad(Dragon unidad){
        return unidad;
    }

    public Unidad generarUnidad(Zerling unidad) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Zangano unidad) throws EdificioNoConoceEstaUnidad {
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Hidralisco unidad)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Mutalisco unidad)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }
    public Unidad generarUnidad(Scout unidad)  throws EdificioNoConoceEstaUnidad{
        throw new  EdificioNoConoceEstaUnidad();
    }

    public void actualizar() {
      this.estado.actualizar();
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario){ }

    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {
        int escudoRestante;
        escudoRestante = escudo.recibirDanio(danioTerestre);
        if(escudoRestante < 0){
            vida.recibirDanio(new Danio(escudoRestante * (-1)));
        }
    }

}
