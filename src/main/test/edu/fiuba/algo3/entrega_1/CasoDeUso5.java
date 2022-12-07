package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.terrenos.TerrenoBase;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVacio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.Acceso;
import edu.fiuba.algo3.modelo.edificios.zerg.ReservaDeReproduccion;

public class CasoDeUso5 {


    @Test
    public void seProduceUnErrorAlIntentarConstruirUnEdificioProtossLejosDeUnPilon() {
        Coordenada coordenadaConTerrenoNoEnergizado = new Coordenada( 9,9);
        TerrenoVacio terreno = new TerrenoVacio(new TerrenoBase(coordenadaConTerrenoNoEnergizado));

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            terreno.ocuparPorEdificio(new Acceso());
        });
    }

    @Test
    public void seProduceUnErrorAlIntentarConstruirUnEdificioZergEnUnTerrenoSinMoho() {
        Coordenada coordenadaConTerrenoSinMoho = new Coordenada( 9,9);
        TerrenoVacio terreno = new TerrenoVacio(new TerrenoBase(coordenadaConTerrenoSinMoho));

        Assertions.assertThrows(TerrenoNoAptoParaConstruirTalEdificio.class, ()->{
            terreno.ocuparPorEdificio(new ReservaDeReproduccion());
        });
    }


    
}
