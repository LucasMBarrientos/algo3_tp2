
package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso25 {

    @Test
    public void probarQueLaRazaYElColorNoSeRepitan() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo");
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");

        Assertions.assertTrue(jugadorZerg.validarDiferenteColor(jugadorProtoss));
        Assertions.assertTrue(jugadorZerg.validarDiferenteRaza(jugadorProtoss));
        Assertions.assertTrue(jugadorZerg.validarDiferenteNombre(jugadorProtoss));

    }

    @Test
    public void probarQueElNombreSeaMayorACincoCaracteres() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");

        Assertions.assertTrue(jugadorProtoss.validarNombre());
    }
}

