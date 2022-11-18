package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.unidades.edificios.zerg.criadero.Criadero;

import org.junit.jupiter.api.Test;

public class CasoDeUso18 {
    @Test
    public void verificarQueLasUnidadesCausenDañoCorrecto(){
        Criadero criadero = new Criadero();
        for(int i=0; i<5; i++) { // paso los turnos para que se termine de construir
            criadero.actualizar();
        }


    }
}
