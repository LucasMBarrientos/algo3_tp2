package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CasoDeUso12 {
  @Test
    public void alDañarEdicioProtossConUnDanioMayorAlEscudoSeRegeneraSoloSuEscudo() {
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
      }

      try{
          pilon.recibirGolpe(new Danio(500));
      }catch (EdificioDestruido edificioDestruido){
          comportamientoEsperado = true;
      }
      Assertions.assertFalse(comportamientoEsperado);

      for(int i=0; i<15; i++){
          pilon.actualizar();
      } //Se cura al completo su vida es 100 y su escudo es 300, asi q 400 de daño deberia matarlo

      Assertions.assertThrows(EdificioDestruido.class,() ->{
          pilon.recibirGolpe(new Danio(400));
      });


  }
}