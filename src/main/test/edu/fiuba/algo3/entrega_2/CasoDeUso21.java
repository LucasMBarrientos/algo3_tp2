package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso21 {

    @Test
    public void EVOULCION(){
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(0));
        Mapa mapa = new Mapa(new Coordenada(20,20));
        Mutalisco mutalisco = new Mutalisco();
        mapa.establecerUnidad(new Coordenada(2,2), mutalisco);

        Pilon pilon = new Pilon();

        pilon.ocupar(mapa.buscarTerreno(new Coordenada(2,3)));

        for (int i = 0; i < 10; i++) {
            pilon.actualizar(inventario);
        }

        mutalisco.actualizar();
        mutalisco.actualizar();
        mutalisco.actualizar();
        mutalisco.actualizar();
        mutalisco.actualizar();
        mutalisco.actualizar();

        Unidad unidad  = mutalisco.evolucionar(mapa, new Guardian());

        unidad.actualizar();
        unidad.actualizar();
        unidad.actualizar();
        unidad.actualizar();

        for(int i = 0; i < 25; i++) {
            unidad.atacar(new Coordenada(2,3), mapa);
        }

        Assertions.assertThrows(EdificioEstaDestruido.class, ()->{
            unidad.atacar(new Coordenada(2,3), mapa);
        });

    }
}
