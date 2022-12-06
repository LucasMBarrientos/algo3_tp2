package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso11 {


    @Test
    public void elEscudoFuncionaComoDebe() {
        Pilon pilon = new Pilon();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100), new Suministro(200));
        for(int i=0; i<6; i++){ pilon.actualizar(inv); } //paso los turnos para que se termine de construir

        
        Assertions.assertThrows(EdificioEstaDestruido.class,() ->{
            pilon.recibirDanio(new Danio(600),new Danio(0));
        });
    }

    @Test
    public void elEscudoSeRegeneraComoDebe() {
        Pilon pilon = new Pilon();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100), new Suministro(200));
        for(int i=0; i<6; i++){ pilon.actualizar(inv); } //paso los turnos para que se termine de construir

        pilon.recibirDanio(new Danio(500),new Danio(0));

        for(int i=0; i<40; i++){
            pilon.actualizar(inv);
        }

        pilon.recibirDanio(new Danio(300),new Danio(0));
        pilon.actualizar(inv);

        pilon.recibirDanio(new Danio(114),new Danio(0));

        Assertions.assertThrows(EdificioEstaDestruido.class, () ->{
          pilon.recibirDanio(new Danio(1),new Danio(0));
        });
    }
}
