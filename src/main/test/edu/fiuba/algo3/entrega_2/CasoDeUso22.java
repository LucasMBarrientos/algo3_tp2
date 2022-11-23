package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso22 {

    @Test
    public void unZanganoNoSeConstruyeSinCriadero() {
        Inventario inventario = new Inventario(new GasVespeno(300), new Mineral(500), new Suministro(200));
        JugadorZerg jugador = new JugadorZerg(inventario);
        Mapa mapa = new Mapa(new Coordenada(30,30));
        jugador.establecerMapa(mapa);


        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugador.generarUnidad(new Coordenada(2, 2), new Zangano());
        });
    }
/*


    @Test
    public void unZanganoNoSeConstruyeSinCriadero2() {
        JugadorMock jugadorZerg = new JugadorMock(1000,1000);
        Mapa mapa = new Mapa(new Coordenada(30,30));
        jugadorZerg.establecerMapa(mapa);


        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(2, 2), new Zangano());});

    }/*
    @Test
    public void unZanganoNoSeConstruyeAlInstante() {
        JugadorMock jugadorZerg = new JugadorMock(1000, 1000);
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugadorZerg.establecerMapa(mapa);
        jugadorZerg.construirEdificio(new Coordenada(2, 2), new Criadero());
        for (int i = 0; i < 8; i++) {
            jugadorZerg.actualizar();
        }

        jugadorZerg.generarUnidad(new Coordenada(2, 2), new Zangano());


        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, () -> {
            jugadorZerg.mover(new Abajo(), new Coordenada(2, 1));
        });
    }
    @Test
    public void unZanganoSeConstruyeAlPasoDeUnTurno() {
        JugadorMock jugadorZerg = new JugadorMock(1000, 1000);
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugadorZerg.establecerMapa(mapa);
        jugadorZerg.construirEdificio(new Coordenada(2, 2), new Criadero());
        for (int i = 0; i < 8; i++) {
            jugadorZerg.actualizar();
        }

        jugadorZerg.generarUnidad(new Coordenada(2, 2), new Zangano());

        jugadorZerg.actualizar();
        jugadorZerg.mover(new Arriba(), new Coordenada(2, 1));
        /*Assertions.assertThrows(NoHayTerrenoDisponibleParaGenerarUnidad.class, () -> {
            jugadorZerg.mover(new Abajo(), new Coordenada(2, 1));

        });
        jugadorZerg.actualizar();
    }
    */
}


