package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.lang.ArchRule.Assertions;

public class CasoDeUso26 {

    /*

    @Test
    public void verificarQueUnCriaderoPuedaSuministrarHasta5Zanganos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        // TODO: jugadorZerg.moverUnidad(new Coordenada(2, 1), new Arriba()); 
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        // TODO: jugadorZerg.moverUnidad(new Coordenada(2, 1), new Abajo()); 
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        // TODO: jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha()); 

        // No deberia haber ninguna unidad en la coordenada (2,1)

        Assertions.assertThrows(NoHaySuministrosSuficientes.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        });
    }

    @Test
    public void verificarQueUnCriaderoPuedaSuministrarAUnMutalizacoYAUnZanganoQueNoSeConvirtioEnEdificio() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 700, 700);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        // Construir una reserva de reproduccion
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(2, 1), new ReservaDeReproduccion()); // TODO: Suponiendo que el zangano de antes se genere en la coordenada (2,1)
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        // construir una guarida
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Abajo()); // TODO: Suponiendo que el zangano de antes se genere en la coordenada (1,2)
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(1, 3), new Guarida());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        // construir una espiral
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Derecha());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(2,2), new Derecha());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(3, 2), new Espiral());
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        // generar un zangano y un mutalisco
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(1,2), new Derecha());
        jugadorZerg.generarUnidad(new Coordenada(3,2), new Mutalisco());

        Assertions.assertThrows(NoHaySuministrosSuficientes.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(1,1), new Zangano());
        });
    }

    */

}
