package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.EdificioDestruido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;

public class CasoDeUso10 {

    @Test
    public void laVidaFuncionaComoDebe() {
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);
        for(int i=0; i<5; i++){ criadero.actualizar(); } //paso los turnos para que se termine de construir


        boolean comportamientoEsperado = false;
        try{
            criadero.recibirGolpe(new Danio(100));
        }catch (EdificioDestruido edificioDestruido){
            comportamientoEsperado = true;
        }
        Assertions.assertFalse(comportamientoEsperado);

        Assertions.assertThrows(EdificioDestruido.class,() ->{
            criadero.recibirGolpe(new Danio(300));
                });

    }


    @Test
    public void laVidaSeRegeneraComoDebe() {
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);
        for(int i=0; i<6; i++){ criadero.actualizar(); } //paso los turnos para que se termine de construir


        boolean comportamientoEsperado = false;
        try{
            criadero.recibirGolpe(new Danio(100));
        }catch (EdificioDestruido edificioDestruido){
            comportamientoEsperado = true;
        }
        Assertions.assertFalse(comportamientoEsperado);

        for(int i=0; i<6; i++){
            criadero.actualizar();
        } //paso los turnos para que se termine de construir

        try{
            criadero.recibirGolpe(new Danio(200));
        }catch (EdificioDestruido edificioDestruido){
            comportamientoEsperado = true;
        }
        Assertions.assertFalse(comportamientoEsperado);

    }

    /*
  @Test
    public void verificiarQueLasConstruccionesZergSeRegeneranHastaEl100() {
      AlgoStar algoStar = new AlgoStar();
      algoStar.empezarJuego();
      
      algoStar.generarUnidad(1, 1);
      algoStar.moverDerecha(1, 1);

      algoStar.seleccionarCasilla(2, 1).establecerTerreno(new TerrenoVolcan());
      algoStar.construirEdificio(2, 1, new Extractor());

      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();
      algoStar.pasarTurno();

      // algoStar.seleccionarCasilla(2, 1).devolverEdificio().vida()

      // ATACAR EL 10% DE LA VIDA DEL EXTRACTOR
      algoStar.seleccionarCasilla(2, 1).devolverEdificio().recibirDanio(0);

      algoStar.pasarTurno();

      // algoStar.seleccionarCasilla(2, 1).devolverEdificio().vida()

      // algoStar.seleccionarCasilla(2, 1).devolverEdificio().vida() DEBERIA SER LA VIDA MAXIMA DEL EXTRACTOR
    }*/
}
