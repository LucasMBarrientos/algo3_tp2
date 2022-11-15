package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.EdificioDestruido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso11 {


    @Test
    public void elEscudoFuncionaComoDebe() {
        Pilon pilon = new Pilon();
        for(int i=0; i<6; i++){ pilon.actualizar(); } //paso los turnos para que se termine de construir


        boolean comportamientoEsperado = false;
        try{
            pilon.recibirGolpe(new Danio(100));
        }catch (EdificioDestruido edificioDestruido){
            comportamientoEsperado = true;
        }
        Assertions.assertFalse(comportamientoEsperado);

        Assertions.assertThrows(EdificioDestruido.class,() ->{
            pilon.recibirGolpe(new Danio(500));
        });

    }
    @Test
    public void elEscudoSeRegeneraComoDebe() {
        Pilon pilon = new Pilon();
        for(int i=0; i<6; i++){ pilon.actualizar(); } //paso los turnos para que se termine de construir


        boolean comportamientoEsperado = false;
        try{
            pilon.recibirGolpe(new Danio(100));
        }catch (EdificioDestruido edificioDestruido){
            comportamientoEsperado = true;
        }
        Assertions.assertFalse(comportamientoEsperado);

        for(int i=0; i<6; i++){
            pilon.actualizar();
        } //paso los turnos para que se termine de construir

        try{
            pilon.recibirGolpe(new Danio(500));
        }catch (EdificioDestruido edificioDestruido){
            comportamientoEsperado = true;
        }
        Assertions.assertFalse(comportamientoEsperado);


    }
    /*
  @Test
    public void alDañarEdicioProtossConUnDanioMenorAlEscudoEsteSeRegenera() {
    AlgoStar algoStar = new AlgoStar();
    algoStar.empezarJuego();
    algoStar.pasarTurno();

    algoStar.construirEdificio(8,8,new Pilon());

    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    // ATACAR EL CON DANIO MENOR AL ESCUDO
    algoStar.seleccionarCasilla(8, 8).devolverEdificio().recibirDanio(100);


      // PROBAR QUE SE REGENERA
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();
    algoStar.pasarTurno();

    Assertions.assertEquals(((EdificioProtoss)algoStar.seleccionarCasilla(8,8).devolverEdificio()).devolverEscudo(), 300);
    }*/
}
