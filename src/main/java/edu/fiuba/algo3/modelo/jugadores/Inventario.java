package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Edificio> edificios = new ArrayList<Edificio>();
    private List<Unidad> unidades = new ArrayList<Unidad>();
    public GasVespeno gasVespeno;
    public Minerales minerales;

    public Inventario(GasVespeno gasVespeno, Minerales minerales) {
        this.gasVespeno = gasVespeno;
        this.minerales = minerales;
    }

    public void agregarEdificio(Edificio edificioNuevo) {
        edificios.add(edificioNuevo);
    }

    public void agregarPilon(Pilon pilon) {
        edificios.add(pilon);
    }

    public void actualizarGasVespeno(Recursos gasVespeno) {
        this.gasVespeno.agregarUnidades(gasVespeno);
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

    public Unidad generarUnidad(Casilla casillaConEdifico) {
        Edificio edificioConLarvas = this.devolverEdificioConLarvas();
        Unidad unidadNueva = casillaConEdifico.generarUnidad(edificioConLarvas, gasVespeno, minerales, casillaConEdifico.devolverCoordendas());
        return unidadNueva;
        //casillaConEdifico.generarUnidad(edificioConLarvas);
    }

    public void actualizarMinerales(Recursos minerales){
        this.minerales.agregarUnidades(minerales);
    }

    public void agregarUnidad(Unidad unidadNueva){
        unidades.add(unidadNueva);
    }

    public void consumirMinerales(Recursos RecursoRequerido){
        minerales.gastar(RecursoRequerido);
    }

    public void consumirGasVespeno(Recursos RecursoRequerido){
        gasVespeno.gastar(RecursoRequerido);
    }

    public boolean faltanEdificios(List<Edificio> edificiosAComprobar){
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
    }

    public void actualizar() {
        for(Edificio edificio : edificios){
            //TODO: ACTUALIZAR LOS EDIFICIOS INDIVIDUALMENTE
            //edificio.actualizar(this);
        }
    }

}
