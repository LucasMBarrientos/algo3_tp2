package edu.fiuba.algo3.modelo.edificios.zerg.guarida;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

public class GuaridaOperativa implements EstadoGuarida{
    private Guarida guarida;

    public Unidad generarUnidad(Edificio edificioConLarvas, GasVespeno gasVespeno, Minerales minerales, Coordenada coordenada) {
        return edificioConLarvas.consumirLarvasYGenerarUnidad(new Hidralisco(gasVespeno, minerales, coordenada));
    }
    @Override
    public Guarida terminarConstruccion() {return guarida;}

    @Override
    public Guarida deshacerConstruccion() {
      guarida.setState(new GuaridaEnConstruccion());
      return guarida;
    }

    @Override
    public void setGuarida(Guarida guarida) {
      this.guarida = guarida;
    }

    @Override
    public void actualizar() {
      this.guarida.vida.regenerar();
    }
}
