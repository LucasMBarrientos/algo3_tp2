package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.Unidad;
import edu.fiuba.algo3.modelo.Zangano;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

import java.util.ArrayList;
import java.util.List;

public class ExtractorOperativo implements EstadoExtractor {

    private Recursos recursosAExtraer;

    private List<Zangano> zanganosTrabajando = new ArrayList<Zangano>();

    public void ingresarUnidad(Zangano zangano) {
        if(zanganosTrabajando.size() < 3){
            zanganosTrabajando.add(zangano);
        }
    }


    public void recolectarRecursos(Terreno terreno, Inventario inventario){
        recursosAExtraer = new GasVespeno(10 * zanganosTrabajando.size());
        Recursos gasDelVolcan = terreno.obtenerRecursos();
        gasDelVolcan.gastar(recursosAExtraer);
        inventario.actualizarGasVespeno(recursosAExtraer);
    }
}
