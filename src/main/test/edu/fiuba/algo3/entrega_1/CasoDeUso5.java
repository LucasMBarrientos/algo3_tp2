package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.terrenos.TerrenoNoAptoParaConstruirEsteEdificio;

public class CasoDeUso5 {

    @Test
    public void seProduceUnErrorAlIntentarConstruirUnEdificioProtossLejosDeUnPilon() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss("-","-");
        Coordenada coordenadaConTerrenoNoEnergizado = new Coordenada( 9,9);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(coordenadaConTerrenoNoEnergizado, new Acceso());
        });
    }

    @Test
    public void seProduceUnErrorAlIntentarConstruirUnEdificioZergEnUnTerrenoSinMoho() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        Coordenada coordenadaConTerrenoSinMoho = new Coordenada( 9,9);

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(coordenadaConTerrenoSinMoho, new Acceso());
        });
    }
    
}
