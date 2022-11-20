package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioDestruido;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso11 {

/*
    @Test
    public void elEscudoFuncionaComoDebe() {
        Pilon pilon = new Pilon();
        for(int i=0; i<6; i++){ pilon.actualizar(); } //paso los turnos para que se termine de construir


        Assertions.assertThrows(EdificioDestruido.class,() ->{
            pilon.recibirGolpe(new Danio(600));
        });

    }
    @Test
    public void elEscudoSeRegeneraComoDebe() {
        Pilon pilon = new Pilon();
        for(int i=0; i<6; i++){ pilon.actualizar(); } //paso los turnos para que se termine de construir

        pilon.recibirGolpe(new Danio(500));

        for(int i=0; i<40; i++){
            pilon.actualizar();
        }

        pilon.recibirGolpe(new Danio(300));
        pilon.actualizar();

        pilon.recibirGolpe(new Danio(600));

        Assertions.assertThrows(EdificioDestruido.class, pilon::actualizar); //TODO agregar state edificio destruido @Leti
    }*/
}
