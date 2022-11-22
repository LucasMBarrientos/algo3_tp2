package edu.fiuba.algo3.entrega_2;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso24 {
    @Test
    public void jugadoresInicianEnLaEsquilasDelMapa() {
        AlgoStar algoStar = new AlgoStar();
        Mapa mapa = new Mapa(new Coordenada(20, 20));
        JugadorZerg jugadorZerg = new JugadorZerg("LetiAab", "#d3b779");
        jugadorZerg.establecerMapa(mapa);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("agusssss", "#e1d3b4");
        jugadorProtoss.establecerMapa(mapa);
        for (int i = 0; i < 5; i++) { // Se finaliza la construccion del criadero
            jugadorZerg.actualizar();
            jugadorProtoss.actualizar();

        }
        //jugadorProtoss.actualizar();

        //Assertions.assertNotNull( jugadorZerg.generarUnidad(new Coordenada(1, 1), new Zangano()));
        //mover 0,0
        // mover afuera del mapa
       // jugadorProtoss.construirEdificio(new Coordenada(0, 1), new Acceso());
    }


    }
