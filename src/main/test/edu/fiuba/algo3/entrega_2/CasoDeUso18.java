package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;
import org.junit.jupiter.api.Test;

public class CasoDeUso18 {
    @Test
    public void verificarQueLasUnidadesCausenDañoCorrecto(){
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);
        for(int i=0; i<5; i++) { // paso los turnos para que se termine de construir
            criadero.actualizar();
        }
        criadero.generarZangano();

    }
}
