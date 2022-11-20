package edu.fiuba.algo3.modelo.edificios.zerg.criadero;

import java.util.List;

import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class CriaderoEnConstruccion implements EstadoCriadero {

    private Criadero criadero;

    public Zangano generarZangano() throws EdificioNoTerminoDeConstruirse {
        throw new EdificioNoTerminoDeConstruirse();
    }

    public Unidad generarUnidad(Zangano unidad) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }
    public int contarLarvas() {
        return 0;
    }

    public void consumirLarva() {
        return;
    }

    @Override
    public Criadero terminarConstruccion() {
        criadero.establecerEstado(new CriaderoOperativo());
        return criadero;
    }

    @Override
    public Criadero deshacerConstruccion() {
        return criadero;
    }

    @Override
    public void setCriadero(Criadero criadero) {
        this.criadero = criadero;
    }

    @Override
    public void actualizar() {
        if(this.criadero.reducirTiempoConstruccion(1)){
            this.terminarConstruccion();
        }
    }

    @Override
    public void actualizarListaDeCoordenadasConCriaderosOperativos(Coordenada coordenada, List<Coordenada> coordenadasConCriaderos) {
        return;
    }


}
