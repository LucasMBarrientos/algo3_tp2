package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.UnidadEstaDestruida;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
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
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));
        Mutalisco mutalisco = new Mutalisco();

        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,2), mutalisco);

        Pilon pilon = new Pilon();

        Mapa.devolverInstancia().establecerEdificio(new Coordenada(2,12), pilon);

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        for (int i=0; i < 7; i++) {
            mutalisco.actualizar(inventario);
        }


        Unidad unidad  = mutalisco.evolucionar(new Guardian(), inventario);

        for (int i=0; i < 4; i++) {
            unidad.actualizar(inventario);
        }


        for(int i = 0; i < 23; i++) {
            unidad.atacar(new Coordenada(2,12));
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            unidad.atacar(new Coordenada(2,12));
        });
    }

    @Test
    public void unMutaliscoPuedeEvolucionarEnUnDevoradorYDestruirUnScoutA5DeDistanciaEn10Turnos(){
        Mapa.devolverInstancia().establecerDimension(new Coordenada(20, 20));
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0), new Suministro(200));


        // Construyo un mutalisco
        Mutalisco mutalisco = new Mutalisco();
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,2), mutalisco);
        for (int i=0; i < 7; i++) {
            mutalisco.actualizar(inventario);
        }

        // Evoluciono el mutalisco en un devorador
        Unidad unidad = mutalisco.evolucionar(new Devorador(), inventario);
        for (int i=0; i < 4; i++) {
            unidad.actualizar(inventario);
        }

        // Construyo un scout enemigo
        Scout scoutEnemigo = new Scout();
        Mapa.devolverInstancia().establecerUnidad(new Coordenada(2,7), scoutEnemigo);
        for (int i=0; i < 9; i++) {
            scoutEnemigo.actualizar(inventario);
        }

        // Ataco el scout enemigo usando el devorador
        for(int i = 0; i < 16; i++) {
            unidad.atacar(new Coordenada(2,7));
        }

        Assertions.assertThrows(UnidadEstaDestruida.class, ()->{
            unidad.atacar(new Coordenada(2,7));
        });
    }
}
