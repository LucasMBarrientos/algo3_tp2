package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificiosConRecursos;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;

import java.util.ArrayList;
import java.util.List;

public class Extractor extends Edificio implements EdificiosConRecursos {

    public List<Unidad> zanganosTrabajando = new ArrayList<Unidad>();

    private Recursos recursosExtraidos;
    
    public Extractor() {
        this.tiempoConstruccion = 6;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return (casilla.devolverTerreno() instanceof TerrenoVolcan);
    }

    public void actualizar() {
        
    }

    public boolean ingresarUnidad(Unidad unidad) {
        if(zanganosTrabajando.size() < 3){
            zanganosTrabajando.add(unidad);
            return true;
        }
        return false;
    }



    @Override
    public void recolectarRecursos() {
        return recursosExtraidos.extraer();
    }

    @Override
    public boolean tieneRecursos() {
        return false;
    }
}
