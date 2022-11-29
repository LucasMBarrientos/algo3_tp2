package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
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
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
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
    public void unZanganoNoTerminoDeConstruirseAntesDe1Turno() {
        Zangano zanganoInicial = new Zangano();
        zanganoInicial.establecerCoordenada(new Coordenada(2,2));

        Mapa mapa = new Mapa(new Coordenada(30,30));
        mapa.establecerUnidad(new Coordenada(2,2), zanganoInicial);

        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(400));
        inventario.agregarUnidad(zanganoInicial);

        JugadorZerg jugador = new JugadorZerg(inventario);
        jugador.establecerMapa(mapa);

        jugador.construirEdificio(new Coordenada(2,2), new Criadero());

        for (int i = 0; i < 8; i++) {
            inventario.actualizar();
        }

        Zangano zangano = new Zangano();
        jugador.generarUnidad(new Coordenada(2, 2), zangano);

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
           zangano.atacar(new Coordenada(2,2), mapa);
        });
    }*/
/*
    @Test
    public void unZerlingNoPuedeGenerarseSinUnaReservaDeReproduccion() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(200));
        JugadorZerg jugador = new JugadorZerg(inventario);
        Mapa mapa = new Mapa(new Coordenada(30,30));
        jugador.establecerMapa(mapa);


        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugador.generarUnidad(new Coordenada(2, 2), new Zerling());
        });
    }*/

    @Test
    public void unZerlingNoTerminoDeGenerarseAntesDe2Turnos() {
        Zerling zerling = new Zerling();
        Mapa mapa = new Mapa(new Coordenada(30,30));

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            zerling.atacar(new Coordenada(2,3), mapa);
        });
    }
/*
    @Test
    public void unHidralicoNoPuedeGenerarseSinUnaGuarida() {
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(200));
        JugadorZerg jugador = new JugadorZerg(inventario);
        Mapa mapa = new Mapa(new Coordenada(30,30));
        jugador.establecerMapa(mapa);


        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugador.generarUnidad(new Coordenada(2, 2), new Hidralisco());
        });
    }
*/
    @Test
    public void unHidraliscoNoTerminoDeGenerarseAntesDe4Turnos() {
        Hidralisco hidralisco = new Hidralisco();
        Mapa mapa = new Mapa(new Coordenada(30,30));

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            hidralisco.atacar(new Coordenada(2,3), mapa);
        });
    }







}


