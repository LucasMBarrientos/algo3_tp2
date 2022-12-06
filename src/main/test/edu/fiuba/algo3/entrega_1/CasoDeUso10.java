package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;

public class CasoDeUso10 {

    @Test
    public void unEdificioZergRecibeUnDanioMayorASuVidaSeDestruye() {
        Criadero criadero = new Criadero();
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(49), new Suministro(200));
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
          criadero.actualizar(inventario);
      }

        Assertions.assertThrows(EdificioEstaDestruido.class,() ->{
            criadero.recibirDanio(new Danio(500),new Danio(0));
        });
    }

    @Test
    public void laVidaDeUnEdificioZergSeRegeraCorrectamenteAlPasarLosTurnos() {
        Criadero criadero = new Criadero();
        Inventario inventario = new Inventario(new GasVespeno(0), new Mineral(50), new Suministro(200));
        for(int i=0; i<6; i++){ criadero.actualizar(inventario); } //paso los turnos para que se termine de construir

        criadero.recibirDanio(new Danio(499),new Danio(1));
        inventario.agregarEdificio(criadero);

        Assertions.assertNotNull(criadero.generarUnidad(new Zangano(),inventario));

        for(int i=0; i<10; i++){
            criadero.actualizar(inventario);
        }

        criadero.recibirDanio(new Danio(200),new Danio(1));
        Assertions.assertNotNull(criadero.generarUnidad(new Zangano(),inventario));

    }
}
