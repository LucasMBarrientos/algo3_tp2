package edu.fiuba.algo3.modelo.terrenos;

import java.util.List;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class TerrenoEnergizado implements EstadoTerreno {

    private Terreno terreno;

    @Override
    public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
        if (this.validarEstado(edificio.posiblesEstados())) {
            casilla.ocupar(edificio);
        }
    }

    @Override
    public void energizarTerreno() {

    }

    @Override
    public void cubrirTerrenoDeMoho() {
        terreno.establecerEstado(new TerrenoMoho());
    }

    @Override
    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    @Override
    public boolean validarEstado(List<EstadoTerreno> listaDePosiblesTerrenos) {
        for (int i = 0; i < listaDePosiblesTerrenos.size(); i++) {
            if (listaDePosiblesTerrenos.get(i) instanceof TerrenoEnergizado) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void vaciarTerreno() {
        terreno.establecerEstado(new TerrenoVacio());
    }

    @Override
    public void generarVolcan() {
        terreno.establecerEstado(new TerrenoVolcan());
    }

    @Override
    public void generarMina() {
        terreno.establecerEstado(new TerrenoMineral());
    }

    @Override
    public void consumirMinerales(Recursos recursoRequerido) {

    }

    @Override
    public void consumirGasVespeno(Recursos recursoRequerido) {

    }

}
