package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;

public class CasoDeUso10 {
/*
    @Test
    public void unEdificioZergRecibeUnDanioMayorASuVidaSeDestruye() {
        Criadero criadero = new Criadero();
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
          criadero.actualizar();
      }
        criadero.recibirGolpe(new Danio(501)); //esto cambia su estado a Destruido

        Assertions.assertThrows(EdificioEstaDestruido.class,() ->{
            criadero.generarUnidad(new Zangano());
        });
    }

    @Test
    public void laVidaDeUnEdificioZergSeRegeraCorrectamenteAlPasarLosTurnos() {
        Criadero criadero = new Criadero();
        for(int i=0; i<6; i++){ criadero.actualizar(); } //paso los turnos para que se termine de construir

        criadero.recibirGolpe(new Danio(499));
        Assertions.assertNotNull(criadero.generarUnidad(new Zangano()));

        for(int i=0; i<10; i++){
            criadero.actualizar();
        }

        criadero.recibirGolpe(new Danio(200));
        Assertions.assertNotNull(criadero.generarUnidad(new Zangano()));

    }
*/
}
