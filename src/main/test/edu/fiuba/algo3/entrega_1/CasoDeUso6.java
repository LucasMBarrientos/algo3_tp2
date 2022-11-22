package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.Abajo;
import edu.fiuba.algo3.modelo.geometria.direcciones.Derecha;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso6 {

    @Test
    public void elRadioDelMohoDelCriaderoEsIgualA5cuandoSeTerminaDeConstruir() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 0, 500);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff",0,250);
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        // Se construye un criadero a partir de 4 pasarTurno
        // El moho Se expande de 1,1 a 6,1 y de crea a apartir del 5 pasarTurno()

        jugadorZerg.construirEdificio(new Coordenada(1,1), new Criadero());
        jugadorProtoss.construirEdificio(new Coordenada(6,2), new Pilon());
        for (int i = 0; i < 5; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(6,1), new Acceso());
        });
    }
       /*
    @Test
    public void elRadioDelMohoDelCriaderoInicialNoEsMayorA5EnElPrimerTurno() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();

        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());

        jugadorZerg.construirEdificio(new Coordenada(8,2), reservaDeReproduccion);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(8,2), reservaDeReproduccion);
        });
    }

    @Test
    public void mohoSeExpande1CasillaCada2Turnos() {
        AlgoStar a = new AlgoStar();  //Me di cuenta que en esta prueba en especíufico es necesario testear desde arriba,
        a.empezarJuego();               // pq la prueba es "probar q crece bien" osea, probar q pase cada dos turnos
        JugadorZerg jugadorZerg = new JugadorZerg();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();

        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());
        a.pasarTurno();
        a.pasarTurno();

        jugadorZerg.construirEdificio(new Coordenada(9,2), reservaDeReproduccion);

        for(int i=0; i<40; i++){
            reservaDeReproduccion.actualizar();
        }

        Assertions.assertNotNull(reservaDeReproduccion.generarUnidad(new Zerling()));
    }

*/
}
