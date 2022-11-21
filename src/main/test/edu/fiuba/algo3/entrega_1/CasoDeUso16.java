package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoEncontrada;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso16 {

    @Test
    public void noSePuedeConstruirUnEdificioSobreOtro() {
        JugadorProtoss jugador = (new JugadorProtoss("nombre", "rosita", 500));
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugador.establecerMapa(mapa);

        Pilon p1 = new Pilon();
        Pilon p2 = new Pilon();

        jugador.construirEdificio(new Coordenada(1,1), p1);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugador.construirEdificio(new Coordenada(1,1), p2);
        });
    }

    @Test
    public void noSePuedeConstruirSobreUnVolcanConUnAsimiladorYaConstruido() {
        JugadorZerg jugadorZerg = (new JugadorZerg("nombre", "rosita", 500));
        JugadorProtoss jugadorProtoss = (new JugadorProtoss("Alan Brito", "verde", 500));
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugadorZerg.establecerMapa(mapa);
        jugadorProtoss.establecerMapa(mapa);

        Asimilador asimilador = new Asimilador();
        Extractor extractor = new Extractor();

        jugadorProtoss.construirEdificio(new Coordenada(6,6), asimilador);

        Assertions.assertThrows(UnidadNoEncontrada.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(6,6), extractor);
        });
    }

    @Test //necesito algoStar para probar esto o bien pasar por parametro un inventario con un zangano ya posicionado
    public void noSePuedeConstruirSobreUnVolcanConUnExtractorYaConstruido() {
       /* JugadorZerg jugadorZerg = (new JugadorZerg("nombre", "rosita", 500));
        JugadorProtoss jugadorProtoss = (new JugadorProtoss("Alan Brito", "verde", 500));
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugadorZerg.establecerMapa(mapa);
        jugadorProtoss.establecerMapa(mapa);

        Coordenada coordenadaDelVolcan = new Coordenada(6,6);
        Unidad zanganoConstructor = new Zangano();
        zanganoConstructor.establecerCoordenada(coordenadaDelVolcan);

        mapa.establecerUnidadDelMapa(coordenadaDelVolcan, new Zangano());


        Asimilador asimilador = new Asimilador();
        Extractor extractor = new Extractor();

        jugadorZerg.construirEdificio(coordenadaDelVolcan, extractor);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorProtoss.construirEdificio(coordenadaDelVolcan, asimilador);
        });

        */
    }

}
