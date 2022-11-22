package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.UnidadDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.zerg.Devorador;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso21 {

    @Test
    public void unMutaliscoPuedeEvolucionarEnUnGuardianYDestruirUnPilonA10DeDistanciaEn25Turnos(){
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
        Mapa mapa = new Mapa(new Coordenada(20,20));
        Mutalisco mutalisco = new Mutalisco();
        mapa.establecerUnidad(new Coordenada(2,2), mutalisco);

        Pilon pilon = new Pilon();

        pilon.ocupar(mapa.buscarTerreno(new Coordenada(2,12)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        for (int i=0; i < 7; i++) {
            mutalisco.actualizar();
        }


        Unidad unidad  = mutalisco.evolucionar(mapa, new Guardian());

        for (int i=0; i < 4; i++) {
            unidad.actualizar();
        }


        for(int i = 0; i < 24; i++) {
            unidad.atacar(new Coordenada(2,12), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            unidad.atacar(new Coordenada(2,12), mapa);
        });
    }

    @Test
    public void unMutaliscoPuedeEvolucionarEnUnDevoradorYDestruirUnScoutA5DeDistanciaEn10Turnos(){
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
        Mapa mapa = new Mapa(new Coordenada(20,20));

        // Construyo un mutalisco
        Mutalisco mutalisco = new Mutalisco();
        mapa.establecerUnidad(new Coordenada(2,2), mutalisco);
        for (int i=0; i < 7; i++) {
            mutalisco.actualizar();
        }

        // Evoluciono el mutalisco en un devorador
        Unidad unidad = mutalisco.evolucionar(mapa, new Devorador());
        for (int i=0; i < 4; i++) {
            unidad.actualizar();
        }

        // Construyo un scout enemigo
        Scout scoutEnemigo = new Scout();
        mapa.establecerUnidad(new Coordenada(2,7), scoutEnemigo);
        for (int i=0; i < 9; i++) {
            scoutEnemigo.actualizar();
        }

        // Ataco el scout enemigo usando el devorador
        for(int i = 0; i < 9; i++) {
            unidad.atacar(new Coordenada(2,7), mapa);
        }

        Assertions.assertThrows(UnidadDestruida.class, ()->{
            unidad.atacar(new Coordenada(2,7), mapa);
        });
    }
}
