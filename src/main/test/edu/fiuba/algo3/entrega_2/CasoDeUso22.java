package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.edificios.protoss.*;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoEncontrado;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Arriba;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.geometria.direcciones.Izquierda;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso22 {

    @Test
    public void unZanganoNoSeConstruyeSinCriadero() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(2, 2), new Zangano());
        });
    }

    @Test
    public void unZanganoNoEstaOperativoAntesDe1Turno() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        //muevo el zangano inicial hasta el Mineral en (4, 3)
        jugadorZerg.moverUnidad(new Coordenada(1, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(3, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(4, 1), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(4, 2), new Abajo());

        //Paso los turnos para recolectar minerales
        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }

        //Muevo el zangano para quitarlo del terreno mineral y construyo un criadero
        jugadorZerg.moverUnidad(new Coordenada(4, 3), new Arriba());
        jugadorZerg.construirEdificio(new Coordenada(4,2), new Criadero());

        //termina de construirse el criadero
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        //genero un zangano y este no deberia poder moverse al estar en construccion todavia
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorZerg.moverUnidad(new Coordenada(4,1), new Derecha());
        });
    }

    @Test
    public void unAmoSupremoNoPuedeConstruirseSinCriadero() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(2, 2), new AmoSupremo());
        });
    }

    @Test
    public void unAmoSupremoNoEstaOperativoAntesDe1Turno() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        //muevo el zangano inicial hasta el Mineral en (4, 3)
        jugadorZerg.moverUnidad(new Coordenada(1, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(3, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(4, 1), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(4, 2), new Abajo());

        //Paso los turnos para recolectar minerales
        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }

        //Muevo el zangano para quitarlo del terreno mineral y construyo un criadero
        jugadorZerg.moverUnidad(new Coordenada(4, 3), new Arriba());
        jugadorZerg.construirEdificio(new Coordenada(4,2), new Criadero());

        //Termina de construirse el criadero
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        //Genero un Amo Supremo y este no deberia poder moverse antes de estar en construccion todavia
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new AmoSupremo());
        for (int i = 0; i < 4; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorZerg.moverUnidad(new Coordenada(4,1), new Derecha());
        });
    }

    @Test
    public void unZerlingNoPuedeConstruirseSinUnaReservaDeReproduccion() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(2, 2), new Zerling());
        });
    }


    @Test
    public void unZerlingNoTerminoDeGenerarseAntesDe2Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        //muevo el zangano inicial hasta el Mineral en (4, 3)
        jugadorZerg.moverUnidad(new Coordenada(1, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(2, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(3, 1), new Derecha());
        jugadorZerg.moverUnidad(new Coordenada(4, 1), new Abajo());
        jugadorZerg.moverUnidad(new Coordenada(4, 2), new Abajo());

        //Paso los turnos para recolectar minerales
        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }

        //Muevo el zangano para quitarlo del terreno mineral y construyo un criadero
        jugadorZerg.moverUnidad(new Coordenada(4, 3), new Arriba());
        jugadorZerg.construirEdificio(new Coordenada(4,2), new Criadero());

        //Termina de construirse el criadero
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        //Genero un zangano para la contruccion
        jugadorZerg.generarUnidad(new Coordenada(4, 2), new Zangano());
        algoStar.pasarTurno();

        //Construyo una reserva de reproduccion
        jugadorZerg.construirEdificio(new Coordenada(4,1), new ReservaDeReproduccion());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
        }

        //Genero un zerling y este no deberia poder moverse antes de dos turnos
        jugadorZerg.generarUnidad(new Coordenada(4, 1), new Zerling());

        algoStar.pasarTurno();

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorZerg.moverUnidad(new Coordenada(3,1), new Derecha());
        });
    }

    @Test
    public void unHidraliscoNoSeConstruyeSinUnaGuarida() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(2, 2), new Hidralisco());
        });
    }

    @Test
    public void unHidraliscoNoTerminoDeGenerarseAntesDe4Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

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

        //genero un Hidralisco y este no deberia poder moverse antes de 4 turnos
        jugadorZerg.generarUnidad(new Coordenada(3, 2), new Hidralisco());
        for (int i = 0; i < 3; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorZerg.moverUnidad(new Coordenada(3,1), new Izquierda());
        });
    }

    @Test
    public void unMutaliscoNoSeConstruyeSinUnaEspiral() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(2, 2), new Mutalisco());
        });
    }

    @Test
    public void unMutaliscoNoTerminoDeGenerarseAntesDe7Turnos() {
        Logger.setEnableLog(true);
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("JugadorZerg", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("JugadorProtoss", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

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

        //genero un mutalisco y este no deberia poder moverse antes de 7 turnos
        jugadorZerg.generarUnidad(new Coordenada(5, 2), new Mutalisco());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorZerg.moverUnidad(new Coordenada(5,1), new Derecha());
        });
    }

    @Test
    public void unGuardianNoTerminoDeEvolucionarAntesDe4Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

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

        //evoluciono el mutalisco a guardian y este no deberia poder moverse antes de 4 turnos
        jugadorZerg.evolucionar(new Coordenada(5,1), new Guardian());
        for (int i = 0; i < 3; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorZerg.moverUnidad(new Coordenada(5,1), new Derecha());
        });
    }

    @Test
    public void unDevoradorNoTerminoDeEvolucionarAntesDe4Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

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

        //evoluciono el mutalisco a guardian y este no deberia poder moverse antes de 4 turnos
        jugadorZerg.evolucionar(new Coordenada(5,1), new Devorador());
        for (int i = 0; i < 3; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorZerg.moverUnidad(new Coordenada(5,1), new Derecha());
        });
    }


    @Test
    public void unZealotNoSeConstruyeSinUnAcceso() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("La escaloneta", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorProtoss.generarUnidad(new Coordenada(2, 2), new Zealot());
        });
    }

    @Test
    public void unZealotNoEstaOperativoAntesDe4Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("La escaloneta", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        //construyo 2 nexos minerales
        jugadorProtoss.construirEdificio(new Coordenada(4,3), new NexoMineral());
        jugadorProtoss.construirEdificio(new Coordenada(4,5), new NexoMineral());

        //Paso los turnos para que se terminen de construir y recolecten recursos
        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }

        //construyo un pilon para que energice el terreno
        jugadorProtoss.construirEdificio(new Coordenada(9,4), new Pilon());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        //construyo un acceso dentro del terreno energizado
        jugadorProtoss.construirEdificio(new Coordenada(8,4), new Acceso());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        //genero un zealot y este no deberia poder moverse antes de 4 turnos al estar en construccion todavia
        jugadorProtoss.generarUnidad(new Coordenada(8, 4), new Zealot());
        for (int i = 0; i < 3; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorProtoss.moverUnidad(new Coordenada(8,3), new Izquierda());
        });
    }

    @Test
    public void unDragonNoSeConstruyeSinUnAcceso() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("La escaloneta", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorProtoss.generarUnidad(new Coordenada(2, 2), new Dragon());
        });
    }

    @Test
    public void unDragonNoEstaOperativoAntesDe6Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("La escaloneta", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        //construyo 2 nexos minerales
        jugadorProtoss.construirEdificio(new Coordenada(4,3), new NexoMineral());
        jugadorProtoss.construirEdificio(new Coordenada(4,5), new NexoMineral());

        //construyo un asimilador
        jugadorProtoss.construirEdificio(new Coordenada(4,4), new Asimilador());

        //Paso los turnos para que se terminen de construir y recolecten recursos
        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }

        //construyo un pilon para que energice el terreno
        jugadorProtoss.construirEdificio(new Coordenada(9,4), new Pilon());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        //construyo un acceso dentro del terreno energizado
        jugadorProtoss.construirEdificio(new Coordenada(8,4), new Acceso());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        //genero un dragon y este no deberia poder moverse antes de 6 turnos al estar en construccion todavia
        jugadorProtoss.generarUnidad(new Coordenada(8, 4), new Dragon());
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorProtoss.moverUnidad(new Coordenada(8,3), new Izquierda());
        });
    }

    @Test
    public void unScoutNoSeConstruyeSinUnPuertoEstelar() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("La escaloneta", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        Assertions.assertThrows(EdificioNoEncontrado.class, ()->{
            jugadorProtoss.generarUnidad(new Coordenada(2, 2), new Scout());
        });
    }

    @Test
    public void unScoutNoEstaOperativoAntesDe9Turnos() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("La escaloneta", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("Goku el mejor", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();

        //construyo 2 nexos minerales
        jugadorProtoss.construirEdificio(new Coordenada(4,3), new NexoMineral());
        jugadorProtoss.construirEdificio(new Coordenada(4,5), new NexoMineral());

        //construyo un asimilador
        jugadorProtoss.construirEdificio(new Coordenada(4,4), new Asimilador());

        //Paso los turnos para que se terminen de construir y recolecten recursos
        for (int i = 0; i < 26; i++) {
            algoStar.pasarTurno();
        }

        //construyo un pilon para que energice el terreno
        jugadorProtoss.construirEdificio(new Coordenada(9,4), new Pilon());
        for (int i = 0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        //construyo un acceso dentro del terreno energizado
        jugadorProtoss.construirEdificio(new Coordenada(8,4), new Acceso());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        //construyo un puerto estelar dentro del terreno energizado
        jugadorProtoss.construirEdificio(new Coordenada(7,4), new PuertoEstelar());
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        //genero un scout y este no deberia poder moverse antes de 9 turnos al estar en construccion todavia
        jugadorProtoss.generarUnidad(new Coordenada(7, 4), new Scout());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(UnidadNoTerminoDeConstruirse.class, ()->{
            jugadorProtoss.moverUnidad(new Coordenada(7,3), new Izquierda());
        });
    }




}


