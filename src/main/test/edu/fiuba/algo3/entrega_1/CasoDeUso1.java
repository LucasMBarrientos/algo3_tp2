package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class CasoDeUso1 {

	@Test
    public void criaderoGeneraTresZanganosYNoPuedeGenerarMasEnEseTurno() {
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100), new Suministro(200));
        
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar(inv);
        }
        
        inv.agregarEdificio(criadero);
        
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);

        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano(),inv);
        });
    }

	@Test
    public void criaderoGeneraTresZanganosYTrasUnTurnoDeberiaPoderGenerarHastaUnZanganoMas() {
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100), new Suministro(200));
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar(inv);
        }
        inv.agregarEdificio(criadero);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.actualizar(inv); // Criadero regenera 1 larva mas
        criadero.generarUnidad(new Zangano(),inv);
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano(),inv);
        });
    }

	@Test
    public void unCriaderoNuncaVaATenerMasDe3LarvasALaVez() {
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100), new Suministro(200));
        Criadero criadero = new Criadero();
        for (int i = 0; i < 10; i++) { // Se finaliza la construccion del criadero y se pasan varios turnos intentando generar mas zanganos
            criadero.actualizar(inv);
        }
        inv.agregarEdificio(criadero);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano(),inv);
        });
    }
    
}
