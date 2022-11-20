package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso1 {


	@Test
    public void criaderoGeneraTresZanganosYNoPuedeGenerarMasEnEseTurno() {
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }
	@Test
    public void criaderoGeneraTresZanganosYTrasUnTurnoDeberiaPoderGenerarHastaUnZanganoMas() {
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.actualizar(); // Criadero regenera 1 larva mas
        criadero.generarUnidad(new Zangano());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }
	@Test
    public void unCriaderoNuncaVaATenerMasDe3LarvasALaVez() {
        Criadero criadero = new Criadero();
        for (int i = 0; i < 10; i++) { // Se finaliza la construccion del criadero y se pasan varios turnos intentando generar mas zanganos
            criadero.actualizar();
        }
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }

}
