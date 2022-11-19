package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Edificio> edificios = new ArrayList<Edificio>();
    private List<Unidad> unidades = new ArrayList<Unidad>();
    public GasVespeno gasVespeno;
    public Mineral mineral;

    public Inventario(GasVespeno gasVespeno, Mineral mineral) {
        this.gasVespeno = gasVespeno;
        this.mineral = mineral;
    }

    public boolean tieneEdificio(Nombre nombreDeEdifico){
        for(Edificio edificio : edificios){
           return nombreDeEdifico.esIgual(edificio.devolverNombre());
        }
        return false;
    }


    public void agregarEdificio(Edificio edificioNuevo) {
        edificios.add(edificioNuevo);
    }
    public void agregarUnidad(Unidad unidadNueva){
        unidades.add(unidadNueva);
    }

    public void actualizarGasVespeno(Recurso gasVespeno) {
        this.gasVespeno.agregarUnidades(gasVespeno);
    }
    public void actualizarMinerales(Recurso minerales){
        this.mineral.agregarUnidades(minerales);
    }

    public Unidad generarUnidad(Casilla casillaConEdifico) {
        Edificio edificioConLarvas = this.devolverEdificioConLarvas();
        Unidad unidadNueva = casillaConEdifico.generarUnidad(edificioConLarvas, gasVespeno, mineral, casillaConEdifico.devolverCoordendas());
        return unidadNueva;
        //casillaConEdifico.generarUnidad(edificioConLarvas);
    }


    public void consumirMinerales(Recurso recursoRequerido){
        mineral.gastar(recursoRequerido);
    }

    public void consumirGasVespeno(Recurso recursoRequerido){
        gasVespeno.gastar(recursoRequerido);
    }

    public void devolverMinerales(Recurso recursoUtilizado){
        mineral.agregarUnidades(recursoUtilizado);
    }

    public void devolverGasVespeno(Recurso recursoUtilizado){
        gasVespeno.agregarUnidades(recursoUtilizado);
    }



    public int contarLarvas() {
        int larvasTotales = 0;
        for (Edificio edificio : edificios) {
            larvasTotales += edificio.contarLarvas();
        }
        return larvasTotales;
    }

    public void consumirLarva() {
        for (Edificio edificio : edificios) {
            if (edificio.contarLarvas() > 0) {
                edificio.consumirLarva();
            }
        }
    }

    public Edificio devolverEdificioConLarvas() {
        Edificio edificioConLarvas = null;
        for (Edificio edificio : edificios) {
            if (edificio.contarLarvas() > 0) {
                edificioConLarvas = edificio;
            }
        }
        return edificioConLarvas;
    }

  /*  public boolean faltanEdificios(List<Edificio> edificiosAComprobar){
        boolean faltanEdificios = false;
        for (int i = 0; i < edificiosAComprobar.size(); i++) {
            if(edificios.isEmpty()) {
                return true;
            } else {
                faltanEdificios = true;
                for (int j = 0; j < edificios.size(); j++) {
                    if (edificiosAComprobar.get(i).compararCon(edificios.get(j))) {
                        faltanEdificios = false;
                    }
                }
                if (faltanEdificios) {
                    return true;
                }
            }
        }
        return faltanEdificios;
    }*/

    public void actualizar() {
        for(Edificio edificio : edificios){
            //TODO: ACTUALIZAR LOS EDIFICIOS INDIVIDUALMENTE
            //edificio.actualizar(this);
        }
    }

}
