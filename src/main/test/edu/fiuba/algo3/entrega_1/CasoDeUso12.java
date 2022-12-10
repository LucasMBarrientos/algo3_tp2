package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CasoDeUso12 {

    @Test
    public void elEscudoDeUnEdificioProtossSeRegeneraApropiadamente() {
        Inventario inventario = new Inventario(new GasVespeno(500), new Mineral(500), new Suministro(200));
        Pilon pilon = new Pilon();
        pilon.establecerPosicion(new Coordenada(5,5));
        for (int i = 0; i < 6; i++) {
            pilon.actualizar(inventario);
        } //paso los turnos para que se termine de construir

        pilon.recibirDanio(new Danio(500), new Danio(0));

        for (int i = 0; i < 40; i++) {
            pilon.actualizar(inventario);
        }

        pilon.recibirDanio(new Danio(300), new Danio(0));
        pilon.actualizar(inventario);

        pilon.recibirDanio(new Danio(114), new Danio(0));

        Assertions.assertThrows(EdificioEstaDestruido.class, () ->{
            pilon.recibirDanio(new Danio(1), new Danio(0));
        });
    }

}