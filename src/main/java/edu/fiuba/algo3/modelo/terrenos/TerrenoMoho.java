package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.*;

import java.util.List;

public class TerrenoMoho implements EstadoTerreno {
        
    private Terreno terreno;

    @Override
    public void ocuparPorEdificio(Edificio edificio, Casilla casilla) {
        if(this.validarEstado(edificio.posiblesEstados())){
        casilla.ocupar(edificio);
        } else {
        throw new TerrenoNoAptoParaConstruirTalEdificio();
        }
    }

    @Override
    public void energizarTerreno() {
        
    }

    @Override
    public void cubrirTerrenoDeMoho() {

    }

    @Override
    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    @Override
    public boolean validarEstado(List<EstadoTerreno> listaDePosiblesTerrenos) {
        for (int i = 0; i < listaDePosiblesTerrenos.size(); i++) {
        if (listaDePosiblesTerrenos.get(i) instanceof TerrenoMoho) {
            return true;
        }
        }
        return false;
    }

    @Override
    public void vaciarTerreno() {

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