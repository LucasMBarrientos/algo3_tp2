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
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso16 {

    @Test
    public void noSePuedeConstruirUnEdificioSobreOtro() {
        JugadorProtoss jugador = (new JugadorProtoss("nombre", "rosita", 500, 500,200));
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
        JugadorZerg jugadorZerg = (new JugadorZerg("nombre", "rosita", 500, 500,200));
        JugadorProtoss jugadorProtoss = (new JugadorProtoss("Alan Brito", "verde", 500, 500,200));
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugadorZerg.establecerMapa(mapa);
        jugadorProtoss.establecerMapa(mapa);

        Asimilador asimilador = new Asimilador();
        Extractor extractor = new Extractor();

        jugadorProtoss.construirEdificio(new Coordenada(4,4), asimilador);

        Assertions.assertThrows(UnidadNoEncontrada.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(4,4), extractor);
        });
    }

    @Test
    public void noSePuedeConstruirSobreUnVolcanConUnExtractorYaConstruido() {
        Coordenada coordenadaDelVolcan = new Coordenada(4,4);
        Unidad zanganoConstructor = new Zangano();
        zanganoConstructor.establecerCoordenada(coordenadaDelVolcan);

        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(500), new Suministro(200));
        inventario.agregarUnidad(zanganoConstructor);

        JugadorZerg jugadorZerg = new JugadorZerg(inventario);
        JugadorProtoss jugadorProtoss = (new JugadorProtoss("Alan Brito", "verde", 500, 500,200));

        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugadorZerg.establecerMapa(mapa);
        jugadorProtoss.establecerMapa(mapa);

        mapa.establecerUnidadDelMapa(coordenadaDelVolcan, new Zangano());

        Asimilador asimilador = new Asimilador();
        Extractor extractor = new Extractor();

        jugadorZerg.construirEdificio(coordenadaDelVolcan, extractor);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorProtoss.construirEdificio(coordenadaDelVolcan, asimilador);
        });

    }

}
