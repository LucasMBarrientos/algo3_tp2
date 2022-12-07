
package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.excepciones.ColorDeJugadorInvalido;
import edu.fiuba.algo3.modelo.excepciones.NombreDeJugadorInvalido;
import edu.fiuba.algo3.modelo.excepciones.RazaInvalida;
import edu.fiuba.algo3.modelo.jugadores.JugadorProtoss;
import edu.fiuba.algo3.modelo.jugadores.JugadorZerg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso25 {

    @Test
    public void noSePuedeAgregarUnJugadorConUnNombreQueTieneMenosSeisOMenosCaracteres() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.agregarJugador(new JugadorProtoss("amurseli", "#da615e"));
        Assertions.assertThrows(NombreDeJugadorInvalido.class, () -> {
            algoStar.agregarJugador(new JugadorZerg("IA104", "#bfd8b8")); 
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
    public void noSePuedeAgregarUnSegundoJugadorConElMismColorQueElPrimerJugador() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.agregarJugador(new JugadorZerg("LucasMBarrientos", "#f0f0f0"));
        Assertions.assertThrows(ColorDeJugadorInvalido.class, () -> {
            algoStar.agregarJugador(new JugadorProtoss("Ezequiel2024", "#f0f0f0"));
        });
    }
    
    @Test
    public void noSePuedeAgregarUnSegundoJugadorConLaMismaRazaQueElPrimerJugador() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.agregarJugador(new JugadorProtoss("diegosanchez", "#B99318"));
        Assertions.assertThrows(RazaInvalida.class, () -> {
            algoStar.agregarJugador(new JugadorProtoss("pablomassuh", "#647b99"));
        });
    }
    
}



