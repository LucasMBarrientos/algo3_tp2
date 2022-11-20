package edu.fiuba.algo3.modelo.edificios.zerg.espiral;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;

public class EspiralOperativa implements EstadoEspiral {

    private Espiral espiral;

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespenoDelJugador, Mineral mineralDelJugador, Coordenada coordenada) {
        return edificioConLarvas.consumirLarvasYGenerarUnidad(new Mutalisco(gasVespenoDelJugador, mineralDelJugador, coordenada));
    }

    @Override
    public Espiral terminarConstruccion() {
        return espiral;
    }

    @Override
    public Espiral deshacerConstruccion() {
        espiral.establecerEstado(new EspiralEnConstruccion());
        return espiral;
    }

    @Override
    public void setEspiral(Espiral espiral) {
        this.espiral = espiral;
    }

    @Override
    public void actualizar() {
        this.espiral.vida.regenerar();
    }
}
