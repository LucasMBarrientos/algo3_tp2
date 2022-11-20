package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import java.util.List;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Espiral extends EdificioZerg {
    private EstadoEspiral estado;
    Terreno terreno;

    public Espiral() {
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(100);
        this.vida = new Vida(300);
        this.tiempoDeConstruccion = 10;
        this.nombre = new Nombre("Espiral");
        establecerEstado(new EspiralEnConstruccion());
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }
    
    public void actualizar() {
      this.estado.actualizar();
    }


    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenada) {
        return estado.generarUnidad(edificioConLarvas , gasVespenoDelJugador, mineralDelJugador, coordenada);
    }

    public void establecerEstado(EstadoEspiral estado){
      this.estado = estado;
      this.estado.setEspiral(this);
    }
  
    public Espiral terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }
  
    public Espiral deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }

    public void validarCorrelativasDeConstruccion(Inventario inventario) throws ConstruccionRequiereDeOtroEdificio {
        if(!inventario.tieneEdificio(new Nombre("Guarida"))){
            throw new ConstruccionRequiereDeOtroEdificio();
        }
    }

    @Override
    public void recibirGolpe(Danio danioTerestre, Danio danioAereo) {}


}
