package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class AsimiladorOperativo implements EstadoAsimilador{

    private Recursos recursosAExtraer;


    public void recolectarRecursos(Terreno terreno, Inventario inventario){
        recursosAExtraer = new GasVespeno(20);
        Recursos gasDelVolcan = terreno.obtenerRecursos();
        gasDelVolcan.gastar(recursosAExtraer);
        inventario.actualizarGasVespeno(recursosAExtraer);
    }
}
