package edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoEnergizado;
import java.util.List;


import edu.fiuba.algo3.modelo.unidades.Unidad;

public class PuertoEstelar extends EdificioProtoss {

    private EstadoPuertoEstelar estado = new PuertoEstelarEnConstruccion();

    public PuertoEstelar(){
        this.costoEnMinerales = new Mineral(150);
        this.costoEnGas = new GasVespeno(150);
        this.tiempoDeConstruccion = 10;
        this.vida = new Vida(600);
        this.escudo = new Escudo(600);
        this.nombre = new Nombre("PuertoEstelar");
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
    }

    public void actualizar() {
      this.estado.actualizar();
    }

    @Override
    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) {
        return null;
    }

    public void establecerEstado(EstadoPuertoEstelar estado){
      this.estado = estado;
      this.estado.setPuertoEstelar(this);
    }

    public PuertoEstelar terminarConstruccion(){
      return this.estado.terminarConstruccion();
    }

    public PuertoEstelar deshacerConstruccion(){
      return this.estado.deshacerConstruccion();
    }

    public Unidad generarUnidad(Unidad unidad) {
      return estado.generarUnidad(unidad);
    }


    public void validarCorrelativasDeConstruccion(Inventario inventario) throws ConstruccionRequiereDeOtroEdificio{
        if(!inventario.tieneEdificio(new Nombre("Acceso"))){
            throw new ConstruccionRequiereDeOtroEdificio();
        }
    }
}
