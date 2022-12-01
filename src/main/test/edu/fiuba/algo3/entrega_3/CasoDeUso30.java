package edu.fiuba.algo3.entrega_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.NoHaySuministrosSuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class CasoDeUso30 {

    @Test        
    public void independientementeDeCuantosCriaderosTengaElJugadorZergNuncaTendraSuministrosSuficientesParaConstruirMasDe200Zanganos() {
        Mapa mapa = new Mapa(new Coordenada(20, 210));
        AlgoStar algoStar = new AlgoStar(mapa);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000",100000,100000,0);
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();
        
        // Se trata de construir la mayor cantidadDePilonesPosibles
        for (int y=208; y > 3; y -= 3) {
            jugadorZerg.construirEdificio(new Coordenada(18,y), new Criadero());
            for (int i=0; i< 6; i++) {
                algoStar.pasarTurno();
            }
            jugadorZerg.generarUnidad(new Coordenada(18,y), new Zangano());
            algoStar.pasarTurno();
            jugadorZerg.moverUnidad(new Coordenada(18,y-1), new Arriba());
            algoStar.pasarTurno();
            jugadorZerg.moverUnidad(new Coordenada(18,y-2), new Arriba());
        }

        // Se regenera las larvas en los criaderos
        for (int i=0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        // El jugador protoss deberia tener 199 suministros en este momento (Porque hay un zangano todavia activo que no fue usado para construir otro criadero)

        Coordenada coordenada;
        int unidadesGeneradas = 1;
        int y = 208;
        do {
            coordenada = new Coordenada(18,y);
            for (int i=0; i<4; i++) {
                if (unidadesGeneradas < 200) {
                    unidadesGeneradas++;
                    jugadorZerg.generarUnidad(coordenada, new Zangano());
                }
            }
            y -= 3;
        } while (unidadesGeneradas < 200);

        Assertions.assertThrows(NoHaySuministrosSuficientes.class, ()->{
            jugadorZerg.generarUnidad(new Coordenada(18,4), new Zangano());
        });
    }

    @Test        
    public void independientementeDeCuantosPilonesTengaElJugadorProtossNuncaTendraSuministrosSuficientesParaConstruirMasDe66Dragones() {
        Mapa mapa = new Mapa(new Coordenada(150, 20));
        AlgoStar algoStar = new AlgoStar(mapa);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff", 100000, 100000);
        algoStar.agregarJugador(jugadorProtoss);
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
        algoStar.agregarJugador(jugadorZerg);
        algoStar.empezarJuego();
        
        // Se trata de construir la mayor cantidadDePilonesPosibles
        for (int x=1; x < 149; x += 3) {
            jugadorProtoss.construirEdificio(new Coordenada(x, 1), new Pilon());
        }

        // Se termina de construir los pilones
        for (int i=0; i < 6; i++) {
            algoStar.pasarTurno();
        }

        // El jugador protoss deberia tener 200 suministros

        // Se construyen 17 accesos en las coordenadas entre todos los pilones
        for (int x=2; x < 149; x += 3) {
            jugadorProtoss.construirEdificio(new Coordenada(x,2), new Acceso());
        }

        // Se termina de construir los accesos
        for (int i=0; i < 10; i++) {
            algoStar.pasarTurno();
        }

        Coordenada coordenada;
        int unidadesGeneradas = 0;
        int x = 2;
        do {
            coordenada = new Coordenada(x,2);
            for (int i=0; i<4; i++) {
                if (unidadesGeneradas < 66) {
                    unidadesGeneradas++;
                    jugadorProtoss.generarUnidad(coordenada, new Dragon());
                }
            }
            x += 3;
        } while (unidadesGeneradas < 66);

        Assertions.assertThrows(NoHaySuministrosSuficientes.class, ()->{
            jugadorProtoss.generarUnidad(new Coordenada(146,2), new Dragon());
        });
    }
























  /*@Test
  public void teniendo40CriaderosY50MutaliscoNoPuedoCrearOtraUnidad() {
      

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    });
  }

  @Test
  public void teniendo40PilonesY50ScoutMutaliscoNoPuedoCrearOtraUnidad() {
      

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    });
  }*/
}
