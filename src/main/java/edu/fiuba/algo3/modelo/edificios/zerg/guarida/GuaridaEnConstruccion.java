package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoConoceEstaUnidad;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;

public class GuaridaEnConstruccion implements EstadoGuarida {
    private Guarida guarida;

    public Unidad generarUnidad(Hidralisco unidad)throws EdificioNoTerminoDeConstruirse {
        throw new EdificioNoTerminoDeConstruirse();
    }
    @Override
    public Guarida terminarConstruccion() {
        guarida.establecerEstado(new GuaridaOperativa());
        return guarida;
    }

    @Override
    public Guarida deshacerConstruccion() {
        return guarida;
    }

    @Override
    public void establecerGuarida(Guarida guarida) {
        this.guarida = guarida;
    }

    @Override
    public void actualizar() {
        if(this.guarida.reducirTiempoConstruccion(1)){
            this.terminarConstruccion();
        }
    }
}
