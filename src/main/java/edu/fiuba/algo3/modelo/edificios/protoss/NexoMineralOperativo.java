package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import java.util.ArrayList;
import java.util.List;

public class NexoMineralOperativo implements EstadoNexoMineral{

    private Recursos recursosAExtraer;

    @Override
    public void recolectarRecursos(Terreno terreno, Inventario inventario) {
      // TODO Auto-generated method stub
      
    }


    /*public void recolectarRecursos(Terreno terreno, Inventario inventario){
        recursosAExtraer = new Minerales(10);
        Recursos gasDelVolcan = terreno.obtenerRecursos();
        gasDelVolcan.gastar(recursosAExtraer);
        inventario.actualizarMinerales(recursosAExtraer);
    }*/
}
