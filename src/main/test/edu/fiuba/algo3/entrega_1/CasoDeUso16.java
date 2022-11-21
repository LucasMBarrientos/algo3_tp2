package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso16 {

    @Test
    public void noSePuedeConstruirUnEdificioSobreOtro() {
        JugadorZerg jugadorZerg = (new JugadorZerg("nombre", "rosita", 500));
        Mapa mapa = new Mapa(new Coordenada(100, 100));
        jugadorZerg.establecerMapa(mapa);

        Criadero c1 = new Criadero();
        Criadero c2 = new Criadero();

        jugadorZerg.construirEdificio(new Coordenada(1,1), c1);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(1,1), c2);
        });
    }

}
