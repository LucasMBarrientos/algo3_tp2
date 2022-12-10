package edu.fiuba.algo3.entrega_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.direcciones.*;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class CasoDeUso29 {
/*
    @Test        
    public void independientementeDeCuantosCriaderosTengaElJugadorZergNuncaTendraSuministrosSuficientesaParaConstruirMasDe200Zanganos() {
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
    public void independientementeDeCuantosPilonesTengaElJugadorProtossNuncaTendraSuministrosSuficientesaParaConstruirMasDe66Dragones() {
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
*/
}


































/*

@Test        
public void independientementeDeCuantosPilonesTengaElJugadorProtossNuncaTendraSuministrosSuficientesaParaConstruirMasDe66Dragones() {
    Mapa mapa = new Mapa(new Coordenada(50, 50));
    AlgoStar algoStar = new AlgoStar(mapa);
    JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000");
    algoStar.agregarJugador(jugadorZerg);
    JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff", 100000, 100000);
    algoStar.agregarJugador(jugadorProtoss);
    algoStar.empezarJuego();
    
    // Se trata de construir la mayor cantidadDePilonesPosibles
    for (int y=48; y > 1; y -= 3) {
        for (int x=48; x > 1; x -= 3) {
            try {
                jugadorProtoss.construirEdificio(new Coordenada(x, y), new Pilon());
            } catch (TerrenoNoAptoParaConstruirTalEdificio e) { }
            catch (TerrenoOcupadoPorUnaUnidad e) { }
        }
    }

    // Se termina de construir los pilones
    for (int i=0; i < 6; i++) {
        algoStar.pasarTurno();
    }

    // El jugador protoss deberia tener 200 suministros

    // Se construyen 17 accesos en las coordenadas entre todos los pilones
    List<Coordenada> coordenadasConAccesosConstruidos = new ArrayList<Coordenada>();
    for (int y = 47; y > 1; y -= 3) {
        for (int x = 47; x > 1; x -= 3) {
            if (coordenadasConAccesosConstruidos.size() < 17) {
                try {
                    jugadorProtoss.construirEdificio(new Coordenada(x,y), new Acceso());
                    coordenadasConAccesosConstruidos.add(new Coordenada(x,y));
                } catch (TerrenoNoAptoParaConstruirTalEdificio e) {
                } catch (TerrenoOcupadoPorUnaUnidad e) {
                } 
            }
        }
    }

    // Se termina de construir los accesos
    for (int i=0; i < 10; i++) {
        algoStar.pasarTurno();
    }

    Coordenada coordenada;
    for (int i=0; i < 16; i++) {
        coordenada = coordenadasConAccesosConstruidos.get(i);
        jugadorProtoss.generarUnidad(coordenada, new Dragon());
        jugadorProtoss.generarUnidad(coordenada, new Dragon());
        jugadorProtoss.generarUnidad(coordenada, new Dragon());
        jugadorProtoss.generarUnidad(coordenada, new Dragon());
    }
    coordenada = coordenadasConAccesosConstruidos.get(16);
    jugadorProtoss.generarUnidad(coordenada, new Dragon());
    jugadorProtoss.generarUnidad(coordenada, new Dragon());

    Assertions.assertThrows(NoHaySuministrosSuficientes.class, ()->{
        jugadorProtoss.generarUnidad(coordenadasConAccesosConstruidos.get(16), new Dragon());
    });
}
*/





























/*
  @Test
  public void teniendo39CriaderosY50MutaliscoNoPuedoCrearMutaliscoSumandoOtroCriadero() {
    AlgoStar algoStar = new AlgoStar();
    JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 500, 500,0);
    algoStar.agregarJugador(jugadorZerg);
    JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
    algoStar.agregarJugador(jugadorProtoss);
    algoStar.empezarJuego();
    
    jugadorZerg.construirEdificio(new Coordenada(1, 1), new Criadero());
    for (int i = 0; i < 8; i++) {
        algoStar.pasarTurno();
    }

    Assertions.assertThrows(RecursosInsuficientes.class, ()->{
      jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano());
    });
  }
  */





  //public void teniendo40PilonesY50ScoutNoPuedoCrearMutaliscoSumandoOtroCriadero() {

    /* 
        int edificiosConstruidos = 0;
        for (int x=100; x > 0; x -= 2) {
            for (int y=100; y > 0; y -= 2) {
                if (edificiosConstruidos < 40) {
                    edificiosConstruidos++;
                    try {
                        jugadorProtoss.construirEdificio(new Coordenada(x,y), new Pilon());
                    } catch (TerrenoNoAptoParaConstruirTalEdificio e) {
                        edificiosConstruidos--;
                    }
                }
            }
        }

    */



        /*

    //  jugadorProtoss.construirEdificio(new Coordenada(1,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(1,2), new Pilon());
    //  jugadorProtoss.construirEdificio(new Coordenada(1,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(1,3), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(1,4), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(1,5), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(1,6), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(2,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(2,2), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(2,3), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(2,4), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(2,5), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(2,6), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(3,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(3,2), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(3,3), new Pilon());
    //    jugadorProtoss.construirEdificio(new Coordenada(3,4), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(3,5), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(3,6), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(4,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(4,2), new Pilon());
    //    jugadorProtoss.construirEdificio(new Coordenada(4,3), new Pilon());
    //    jugadorProtoss.construirEdificio(new Coordenada(4,4), new Pilon());
    //   jugadorProtoss.construirEdificio(new Coordenada(4,5), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(4,6), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(5,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(5,2), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(5,3), new Pilon());
    //    jugadorProtoss.construirEdificio(new Coordenada(5,4), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(5,5), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(5,6), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(6,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(6,2), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(6,3), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(6,4), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(6,5), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(6,6), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(7,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(7,2), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(7,3), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(7,4), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(7,5), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(7,6), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(8,1), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(8,2), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(8,3), new Pilon());
        jugadorProtoss.construirEdificio(new Coordenada(8,4), new Pilon());

        //JugadorProtoss.generarUnidad(new Coordenada(1, 1), new Zangano());

    */
