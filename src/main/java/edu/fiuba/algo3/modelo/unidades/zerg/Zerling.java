package edu.fiuba.algo3.modelo.unidades.zerg;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.unidades.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.UnidadOperativa;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;

public class Zerling extends UnidadZerg {

    public Zerling(GasVespeno gasVespenoDelJugador, Minerales mineralesDelJugador) {
        gasVespenoDelJugador.gastar(new GasVespeno(0));
        mineralesDelJugador.gastar(new Minerales(25));
        this.tiempoConstruccion = 2;
        this.danioAereo = new Danio(0);
        this.danioTerrestre = new Danio(4);
        this.rango = 1;
        this.vida = new Vida(35);
    }




}
