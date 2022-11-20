package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;

public class EspiralEnConstruccion implements EstadoEspiral {
    private Espiral espiral;

    public Unidad generarUnidad(Mutalisco unidad) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public Espiral terminarConstruccion() {
        espiral.establecerEstado(new EspiralOperativa());
        return espiral;
    }

    @Override
    public Espiral deshacerConstruccion() {
        return espiral;
    }

    @Override
    public void setEspiral(Espiral espiral) {
        this.espiral = espiral;
    }

    @Override
    public void actualizar() {
        if(this.espiral.reducirTiempoConstruccion(1)){
            this.terminarConstruccion();
        }
    }

}
