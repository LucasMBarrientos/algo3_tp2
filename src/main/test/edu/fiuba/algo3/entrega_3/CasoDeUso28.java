package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso28 {


    @Test
    public void unZealotHace3KillsSeVuelveInvisibleYNoPuedeRecibirDañoDeUnidadesEnemigas() {

        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 1200, 1200, 200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff", 1200, 1200, 200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        //construyo un criadero
        jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
        algoStar.pasarTurno();

        //construyo un pilon
        jugadorProtoss.construirEdificio(new Coordenada(30, 2), new Pilon());
        for (int i = 0; i < 7; i++) {
            algoStar.pasarTurno();
        }

        //construyo un acceso
        algoStar.pasarTurno();
        jugadorProtoss.construirEdificio(new Coordenada(29, 2), new Acceso());
        for (int i = 0; i < 9; i++) {
            algoStar.pasarTurno();
        }

        // Genero un zealot en el acceso
        jugadorProtoss.generarUnidad(new Coordenada(29,2), new Zealot());
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        // Construyo una reserva de reproduccion
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha());
        jugadorZerg.construirEdificio(new Coordenada(3, 1), new ReservaDeReproduccion());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        //genero un zerling
        jugadorZerg.generarUnidad(new Coordenada(3,1), new Zerling());
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        //genero otro zerling
        jugadorZerg.generarUnidad(new Coordenada(3,1), new Zerling());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(4,1), new Derecha());

        //genero un ultimo zerling
        jugadorZerg.generarUnidad(new Coordenada(3,1), new Zerling());
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        //Acerco el zealot a los zerlings
        for (int x = 29; x > 6; x--) {
            jugadorProtoss.moverUnidad(new Coordenada(x,1), new Izquierda());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }

        //zealot mata a un zerling
        for (int i = 0; i < 5; i++) {
            try{
                jugadorProtoss.atacar(new Coordenada(6,1), new Coordenada(5,1));
            } catch (UnidadEstaDestruida e){}
        }
        algoStar.pasarTurno();

        //zealot mata a otro zerling
        jugadorProtoss.moverUnidad(new Coordenada(6,1), new Izquierda());
        for (int i = 0; i < 5; i++) {
            try{
                jugadorProtoss.atacar(new Coordenada(5,1), new Coordenada(4,1));
            } catch (UnidadEstaDestruida e){}
        }
        algoStar.pasarTurno();

        //zealot destruye la reserva de reproduccion y se vuelve el heroe de las eras
        jugadorProtoss.moverUnidad(new Coordenada(5,1), new Izquierda());
        for (int i = 0; i < 125; i++) {
            try{
                jugadorProtoss.atacar(new Coordenada(4,1), new Coordenada(3,1));
            } catch (EdificioEstaDestruido e){}
        }
        algoStar.pasarTurno();

        //el ultimo zerling trata vengar a sus amigos y no puede *pathetic*
        jugadorZerg.moverUnidad(new Coordenada(2,1), new Derecha());
        for (int i = 0; i < 125; i++) {
            jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(4,1));
        }

        //zealot termina el trabajo y mata al ultimo zerling
        for (int i = 0; i < 4; i++) {
            jugadorProtoss.atacar(new Coordenada(4,1), new Coordenada(3,1));
        }

        Assertions.assertThrows(UnidadEstaDestruida.class, ()->{
            jugadorProtoss.atacar(new Coordenada(4,1), new Coordenada(3,1));
        });
    }

    @Test
    public void sePuedeAtacarUnZealotCuandoSeEncuentraDentroDelRangoDeUnAmoSupremo() {

        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 1200, 1200, 200);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff", 1200, 1200, 200);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        //construyo un criadero
        jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
        algoStar.pasarTurno();

        //construyo un pilon
        jugadorProtoss.construirEdificio(new Coordenada(30, 2), new Pilon());
        for (int i = 0; i < 7; i++) {
            algoStar.pasarTurno();
        }

        //construyo un acceso
        algoStar.pasarTurno();
        jugadorProtoss.construirEdificio(new Coordenada(29, 2), new Acceso());
        for (int i = 0; i < 9; i++) {
            algoStar.pasarTurno();
        }

        // Genero un zealot en el acceso
        jugadorProtoss.generarUnidad(new Coordenada(29,2), new Zealot());
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        // Construyo una reserva de reproduccion
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha());
        jugadorZerg.construirEdificio(new Coordenada(3, 1), new ReservaDeReproduccion());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        //genero un zerling
        jugadorZerg.generarUnidad(new Coordenada(3,1), new Zerling());
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        //genero otro zerling
        jugadorZerg.generarUnidad(new Coordenada(3,1), new Zerling());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(4,1), new Derecha());

        //genero un ultimo zerling
        jugadorZerg.generarUnidad(new Coordenada(3,1), new Zerling());
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        //Acerco el zealot a los zerlings
        for (int x = 29; x > 6; x--) {
            jugadorProtoss.moverUnidad(new Coordenada(x,1), new Izquierda());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }

        //zealot mata a un zerling
        for (int i = 0; i < 5; i++) {
            try{
                jugadorProtoss.atacar(new Coordenada(6,1), new Coordenada(5,1));
            } catch (UnidadEstaDestruida e){}
        }
        algoStar.pasarTurno();

        //zealot mata a otro zerling
        jugadorProtoss.moverUnidad(new Coordenada(6,1), new Izquierda());
        for (int i = 0; i < 5; i++) {
            try{
                jugadorProtoss.atacar(new Coordenada(5,1), new Coordenada(4,1));
            } catch (UnidadEstaDestruida e){}
        }
        algoStar.pasarTurno();

        //zealot destruye la reserva de reproduccion y se vuelve invisible
        jugadorProtoss.moverUnidad(new Coordenada(5,1), new Izquierda());
        for (int i = 0; i < 125; i++) {
            try{
                jugadorProtoss.atacar(new Coordenada(4,1), new Coordenada(3,1));
            } catch (EdificioEstaDestruido e){}
        }
        algoStar.pasarTurno();

        //zealot no recibe daño
        jugadorZerg.moverUnidad(new Coordenada(2,1), new Derecha());
        for (int i = 0; i < 125; i++) {
            jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(4,1));
        }

        //genero un amo supremo y este detecta al zealot
        jugadorZerg.generarUnidad(new Coordenada(1, 1), new AmoSupremo());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        //el zerling ahora si puede atacar al zealot
        for (int i = 0; i < 39; i++) {
            jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(4,1));
        }

        Assertions.assertThrows(UnidadEstaDestruida.class, ()->{
            jugadorZerg.atacar(new Coordenada(3,1), new Coordenada(4,1));
        });
    }
  
}
