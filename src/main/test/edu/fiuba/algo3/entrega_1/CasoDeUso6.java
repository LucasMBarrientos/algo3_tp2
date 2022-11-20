package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso6 {

    /*

    @Test
    public void elRadioDelMohoDelCriaderoEsIgualA5EnElPrimerTurno() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();

        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());

        jugadorZerg.construirEdificio(new Coordenada(7,2), reservaDeReproduccion);

        for(int i=0; i<40; i++){
            reservaDeReproduccion.actualizar();

        }

        Assertions.assertNotNull(reservaDeReproduccion.generarUnidad(new Zerling()));
    }


    @Test
    public void elRadioDelMohoDelCriaderoInicialNoEsMayorA5EnElPrimerTurno() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();

        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());

        jugadorZerg.construirEdificio(new Coordenada(8,2), reservaDeReproduccion);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(8,2), reservaDeReproduccion);
        });
    }

    @Test
    public void mohoSeExpande1CasillaCada2Turnos() {
        AlgoStar a = new AlgoStar();  //Me di cuenta que en esta prueba en especíufico es necesario testear desde arriba,
        a.empezarJuego();               // pq la prueba es "probar q crece bien" osea, probar q pase cada dos turnos
        JugadorZerg jugadorZerg = new JugadorZerg();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();

        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());
        a.pasarTurno();
        a.pasarTurno();

        jugadorZerg.construirEdificio(new Coordenada(9,2), reservaDeReproduccion);

        for(int i=0; i<40; i++){
            reservaDeReproduccion.actualizar();
        }

        Assertions.assertNotNull(reservaDeReproduccion.generarUnidad(new Zerling()));
    }

*/
}
