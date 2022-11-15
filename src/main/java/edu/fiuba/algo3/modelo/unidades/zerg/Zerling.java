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

    public Zerling() {
        this.costoEnMinerales = new Minerales(25);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoConstruccion = 2;
        this.danioTerrestre = new Danio(4);
        this.rango = 1;
        this.vida = new Vida(35);
        this.estado = new UnidadEnConstruccion();
    }

    public void actualizar(Inventario inventario){
        tiempoConstruccion--;
        if(tiempoConstruccion == 0){
            estado = new UnidadOperativa(new Danio(0), new Danio(4), 1);
        }
        this.estado.actualizar();
    }




}
