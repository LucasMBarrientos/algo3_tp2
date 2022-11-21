package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso17 {

    @Test
    public void noSePuedeConstruirUnPuertoEstelarSinUnAcceso() {
        JugadorProtoss jugador = (new JugadorProtoss("Martina", "violeta", 500));
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugador.establecerMapa(mapa);

        PuertoEstelar puertoEstelar = new PuertoEstelar();

        Assertions.assertThrows(ConstruccionRequiereDeOtroEdificio.class, ()->{
            jugador.construirEdificio(new Coordenada(2,2), puertoEstelar);
        });
    }

    /* Idem caso 16, necesito AlgoStar o un inventario con zangano
    @Test
    public void noSePuedeConstruirUnaEspiralSinUnaGuarida() {
        JugadorZerg jugador = (new JugadorZerg("Princesa Leia", "azul", 500));
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugador.establecerMapa(mapa);

        Espiral espiral = new Espiral();

        Assertions.assertThrows(ConstruccionRequiereDeOtroEdificio.class, ()->{
            jugador.construirEdificio(new Coordenada(2,2), espiral);
        });
    }


    @Test
    public void noSePuedeConstruirUnaGuaridaSinUnaReservaDeReproduccion() {
        JugadorZerg jugador = (new JugadorZerg("Goku Supersaiyan", "azul", 500));
        Mapa mapa = new Mapa(new Coordenada(30, 30));
        jugador.establecerMapa(mapa);

        Guarida guarida = new Guarida();

        Assertions.assertThrows(ConstruccionRequiereDeOtroEdificio.class, ()->{
            jugador.construirEdificio(new Coordenada(2,2), guarida);
        });
    }

    */

    
}
