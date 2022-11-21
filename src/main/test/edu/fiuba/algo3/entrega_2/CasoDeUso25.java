
package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.jugadores.Jugador;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class CasoDeUso25 {



        @Test
        public void noSePuedeAgregarUnJugadorConUnNombreQueTieneMenosSeisOMenosCaracteres() {
            //JugadorProtoss jugadorProtoss = JugadorProtoss(new JugadorProtoss("amurseli", "#da615e"));
            Assertions.assertThrows(NombreDeJugadorInvalido.class, () -> {
                JugadorZerg jugadorZerg =new JugadorZerg("agus","rosira");

            });

        }
        @Test
        public void noSePuedeAgregarUnSegundoJugadorConLaMismaRazaQueElPrimerJugador() {
            AlgoStar algoStar = new AlgoStar();
            JugadorZerg jugadorZerg = (new JugadorZerg("diegosanchez", "#B99318"));

            Assertions.assertThrows(NombreDeJugadorInvalido.class, () -> {
                jugadorZerg.compararRaza(new JugadorZerg("pablomassuh", "#647b99"));
            });


        }

        @Test
        public void noSePuedeAgregarUnSegundoJugadorConElMismoColorQueElPrimerJugador() {
            AlgoStar algoStar = new AlgoStar();
            algoStar.agregarJugador(new JugadorZerg("diegosanchez", "verde"));

            Assertions.assertThrows(NombreDeJugadorInvalido.class, () -> {
                algoStar.agregarJugador(new JugadorProtoss("pablomassuh", "verde"));
            });


        }


        @Test
        public void noSePuedeAgregarUnSegundoJugadorConElMismoNombreQueElPrimerJugador() {
            AlgoStar algoStar = new AlgoStar();
            algoStar.agregarJugador(new JugadorZerg("LetiAab", "#d3b779"));

            Assertions.assertThrows(NombreDeJugadorInvalido.class, () -> {
                algoStar.agregarJugador(new JugadorProtoss("LetiAab", "#e1d3b4"));
            });
        }
        @Test
        public void noSePuedeAgregarUnSegundoJugadorConLaMismaRazaQueElPrimerJugador2() {
            AlgoStar algoStar = new AlgoStar();
            algoStar.agregarJugador(new JugadorZerg("diegosanchez", "verde"));

            Assertions.assertThrows(NombreDeJugadorInvalido.class, () -> {
                algoStar.agregarJugador(new JugadorZerg("pablomassuh", "Azul"));
            });


        }
    }



