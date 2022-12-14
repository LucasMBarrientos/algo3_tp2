package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.zerg.Devorador;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso21 {

    @Test
    public void unMutaliscoPuedeEvolucionarEnUnGuardianYDestruirUnPilonA10DeDistanciaCon25Golpes(){
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        //construyo un pilon
        jugadorProtoss.construirEdificio(new Coordenada(11,4), new Pilon());

        //muevo el zangano inicial hasta el Mineral en (4, 3)
        jugadorZerg.moverUnidad(new Coordenada(1, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(3, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(4, 1), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(4, 2), new Abajo());

        //Paso los turnos para recolectar minerales
        for (int i = 0; i < 45; i++) {
            algoStar.pasarTurno();
        }

        //Muevo el zangano para quitarlo del terreno mineral y construyo un criadero
        jugadorZerg.moverUnidad(new Coordenada(4, 3), new Arriba());
        jugadorZerg.construirEdificio(new Coordenada(4,2), new Criadero());

        //Termina de construirse el criadero
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        //Genero zanganos para la contruccion
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();

        //muevo un zangano hasta un volcan y construyo un extractor
        jugadorZerg.moverUnidad(new Coordenada(3,2), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(3,3), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(3,4), new Derecha());
        jugadorZerg.construirEdificio(new Coordenada(4,4), new Extractor());

        //Construyo una reserva de reproduccion
        jugadorZerg.construirEdificio(new Coordenada(4,1), new ReservaDeReproduccion());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        //ingreso un zangano al extractor para recolectar gas
        jugadorZerg.ingresarUnidadAUnEdificio(new Coordenada(4,4), new Coordenada(5,2));
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        //construyo una guarida
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(3,2), new Guarida());

        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        //construyo una espiral
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(5,2), new Espiral());

        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        //genero un mutalisco
        jugadorZerg.generarUnidad(new Coordenada(5, 2), new Mutalisco());
        for (int i = 0; i < 7; i++) {
            algoStar.pasarTurno();
        }

        //evoluciono el mutalisco a guardian
        jugadorZerg.evolucionar(new Coordenada(5,1), new Guardian());
        for (int i = 0; i < 4; i++) {
            algoStar.pasarTurno();
        }

        //el guardian ataca al pilon y lo destruye con 25 golpes
        for(int i = 0; i < 23; i++) {
            jugadorZerg.atacar(new Coordenada(5,1), new Coordenada(11,4));
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            jugadorZerg.atacar(new Coordenada(5,1), new Coordenada(11,4));
        });

    }

    @Test
    public void unMutaliscoPuedeEvolucionarEnUnDevoradorYDestruirUnScoutA5DeDistanciaCon10Golpes(){
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("La escaloneta", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        //muevo el zangano inicial hasta el Mineral en (4, 3)
        jugadorZerg.moverUnidad(new Coordenada(1, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(3, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(4, 1), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(4, 2), new Abajo());

        algoStar.pasarTurno();

        //construyo 2 nexos minerales
        jugadorProtoss.construirEdificio(new Coordenada(95,44), new NexoMineral());
        jugadorProtoss.construirEdificio(new Coordenada(95,46), new NexoMineral());

        //construyo un asimilador
        jugadorProtoss.construirEdificio(new Coordenada(95,45), new Asimilador());

        //Paso los turnos para que se terminen de construir y recolecten recursos
        for (int i = 0; i < 26; i++) {
            algoStar.pasarTurno();
        }

        //construyo un pilon para que energice el terreno
        jugadorProtoss.construirEdificio(new Coordenada(11,4), new Pilon());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        //construyo un acceso dentro del terreno energizado
        jugadorProtoss.construirEdificio(new Coordenada(11,5), new Acceso());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        //construyo un puerto estelar dentro del terreno energizado
        jugadorProtoss.construirEdificio(new Coordenada(10,3), new PuertoEstelar());
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        //genero un scout y se pone en la coordenada (10,2)
        jugadorProtoss.generarUnidad(new Coordenada(10, 3), new Scout());


        //Muevo el zangano para quitarlo del terreno mineral y construyo un criadero
        jugadorZerg.moverUnidad(new Coordenada(4, 3), new Arriba());
        jugadorZerg.construirEdificio(new Coordenada(4,2), new Criadero());

        //Termina de construirse el criadero
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        //Genero zanganos para la contruccion
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();

        //muevo un zangano hasta un volcan y construyo un extractor
        jugadorZerg.moverUnidad(new Coordenada(3,2), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(3,3), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(3,4), new Derecha());
        jugadorZerg.construirEdificio(new Coordenada(4,4), new Extractor());

        //Construyo una reserva de reproduccion
        jugadorZerg.construirEdificio(new Coordenada(4,1), new ReservaDeReproduccion());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        //ingreso un zangano al extractor para recolectar gas
        jugadorZerg.ingresarUnidadAUnEdificio(new Coordenada(4,4), new Coordenada(5,2));
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        //construyo una guarida
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(3,2), new Guarida());

        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        //construyo una espiral
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();
        jugadorZerg.construirEdificio(new Coordenada(5,2), new Espiral());

        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        //genero un mutalisco
        jugadorZerg.generarUnidad(new Coordenada(5, 2), new Mutalisco());
        for (int i = 0; i < 7; i++) {
            algoStar.pasarTurno();
        }

        //evoluciono el mutalisco a devorador
        jugadorZerg.evolucionar(new Coordenada(5,1), new Devorador());
        for (int i = 0; i < 4; i++) {
            algoStar.pasarTurno();
        }

        //acerco el devorador al Scout enemigo
        jugadorZerg.moverUnidad(new Coordenada(5,1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(6,1), new Derecha());

        //el devorador mata al scout con 10 golpes
        for(int i = 0; i < 16; i++) {
            jugadorZerg.atacar(new Coordenada(7,1), new Coordenada(10,2));
        }

        Assertions.assertThrows(UnidadEstaDestruida.class, ()->{
            jugadorZerg.atacar(new Coordenada(7,1), new Coordenada(10,2));
        });

    }
}
