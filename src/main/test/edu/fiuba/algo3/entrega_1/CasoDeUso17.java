package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.Guarida;
import edu.fiuba.algo3.modelo.excepciones.ConstruccionRequiereDeOtroEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso17 {

    @Test
    public void noSePuedeConstruirUnPuertoEstelarSinUnAcceso() {
        JugadorProtoss jugador = (new JugadorProtoss("Martina", "violeta", 500, 500,200));
        Mapa.devolverInstancia().establecerDimension(new Coordenada(30, 30));
        jugador.iniciarseEnMapa();

        PuertoEstelar puertoEstelar = new PuertoEstelar();

        Assertions.assertThrows(ConstruccionRequiereDeOtroEdificio.class, ()->{
            jugador.construirEdificio(new Coordenada(2,2), puertoEstelar);
        });
    }

    @Test
    public void noSePuedeConstruirUnaEspiralSinUnaGuarida() {
        Mapa.devolverInstancia().establecerDimension(new Coordenada(30, 30));
        Inventario inventario = new Inventario(new GasVespeno(100), new Mineral(500), new Suministro(200));
        Zangano zangano = new Zangano();
        zangano.establecerCoordenada(new Coordenada(2,2));
        inventario.agregarUnidad(zangano);
        JugadorZerg jugador = new JugadorZerg(inventario);
        jugador.iniciarseEnMapa();

        Assertions.assertThrows(ConstruccionRequiereDeOtroEdificio.class, ()->{
            jugador.construirEdificio(new Coordenada(2,2), new Espiral());
        });
    }


    @Test
    public void noSePuedeConstruirUnaGuaridaSinUnaReservaDeReproduccion() {
        Inventario inventario = new Inventario(new GasVespeno(100), new Mineral(500), new Suministro(200));
        Mapa.devolverInstancia().establecerDimension(new Coordenada(30, 30));

        Zangano zangano = new Zangano();
        zangano.establecerCoordenada(new Coordenada(2,2));
        inventario.agregarUnidad(zangano);
        JugadorZerg jugador = new JugadorZerg(inventario);
        jugador.iniciarseEnMapa();

        Assertions.assertThrows(ConstruccionRequiereDeOtroEdificio.class, ()->{
            jugador.construirEdificio(new Coordenada(2,2), new Guarida());
        });
    }


    
}
