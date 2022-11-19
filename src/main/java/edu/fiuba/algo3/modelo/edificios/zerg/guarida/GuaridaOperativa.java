package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;

public class GuaridaOperativa implements EstadoGuarida{
    private Guarida guarida;

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Mineral mineral, Coordenada coordenada) {
        return edificioConLarvas.consumirLarvasYGenerarUnidad(new Hidralisco(gasVespeno, mineral, coordenada));
    }

    @Override
    public Guarida terminarConstruccion() {
        return guarida;
    }

    @Override
    public Guarida deshacerConstruccion() {
        guarida.establecerEstado(new GuaridaEnConstruccion());
        return guarida;
    }

    @Override
    public void establecerGuarida(Guarida guarida) {
        this.guarida = guarida;
    }

    @Override
    public void actualizar() {
        this.guarida.vida.regenerar();
    }
    
}
