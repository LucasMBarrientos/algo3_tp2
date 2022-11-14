package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.*;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso2 {

    @Test
    public void criaderoSeConstruyeEnTiempoAdecuado() {
        boolean expected = true;
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);

        criadero.actualizar();
        criadero.actualizar();
        criadero.actualizar();
        criadero.actualizar();

        try{
            criadero.generarZangano();
        } catch (EdificioNoTerminoDeConstruirse e){
            expected = false;
        }
        Assertions.assertTrue(expected);
    }
    @Test
    public void criaderoNoEstaOperativoAntesDe4Turnos() {

        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacion);

        criadero.actualizar();
        criadero.actualizar();
        criadero.actualizar();

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            criadero.generarZangano();
        });
    }

    @Test
    public void reservaDeProduccionSeConstruyeEnTiempoAdecuado() {
        boolean expected = true;
        Coordenada ubicacionCriadero = new Coordenada(1 , 2);
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacionCriadero);
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(ubicacion);

        for(int i=0; i<12; i++){
            criadero.actualizar();
            reserva.actualizar();
        }

        try{
            reserva.generarUnidad(criadero);
        } catch (EdificioNoTerminoDeConstruirse e){
            expected = false;
        }
        Assertions.assertTrue(expected);
    }
    @Test
    public void reservaDeProduccionNoEstaOperativaAntesDe12Turnos() {
        Coordenada ubicacionCriadero = new Coordenada(1 , 2);
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacionCriadero);
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(ubicacion);

        for(int i=0; i<11; i++){
            criadero.actualizar();
            reserva.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            reserva.generarUnidad(criadero);
        });
    }

    @Test
    public void GuaridaSeConstruyeEnTiempoAdecuado() {
        boolean expected = true;
        Coordenada ubicacionCriadero = new Coordenada(1 , 2);
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacionCriadero);
        Guarida guarida = new Guarida(ubicacion);

        for(int i=0; i<12; i++){
            criadero.actualizar();
            guarida.actualizar();
        }

        try{
            guarida.generarUnidad(criadero);
        } catch (EdificioNoTerminoDeConstruirse e){
            expected = false;
        }
        Assertions.assertTrue(expected);
    }
    @Test
    public void GuaridaNoEstaOperativaAntesDe12Turnos() {
        Coordenada ubicacionCriadero = new Coordenada(1 , 2);
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacionCriadero);
        Guarida guarida = new Guarida(ubicacion);

        for(int i=0; i<11; i++){
            criadero.actualizar();
            guarida.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            guarida.generarUnidad(criadero);
        });
    }

    @Test
    public void EspiralSeConstruyeEnTiempoAdecuado() {
        boolean expected = true;
        Coordenada ubicacionCriadero = new Coordenada(1 , 2);
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacionCriadero);
        Espiral espiral = new Espiral(ubicacion);

        for(int i=0; i<10; i++){
            criadero.actualizar();
            espiral.actualizar();
        }

        try{
            espiral.generarUnidad(criadero);
        } catch (EdificioNoTerminoDeConstruirse e){
            expected = false;
        }
        Assertions.assertTrue(expected);
    }
    @Test
    public void EspiralNoEstaOperativaAntesDe10Turnos() {
        Coordenada ubicacionCriadero = new Coordenada(1 , 2);
        Coordenada ubicacion = new Coordenada(2 , 2);
        Criadero criadero = new Criadero(ubicacionCriadero);
        Espiral espiral = new Espiral(ubicacion);

        for(int i=0; i<9; i++){
            criadero.actualizar();
            espiral.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            espiral.generarUnidad(criadero);
        });
    }

    @Test
    public void ExtractorSeConstruyeEnTiempoAdecuado() {
        boolean expected = true;
        Coordenada ubicacion = new Coordenada(2 , 2);
        Extractor extractor = new Extractor(ubicacion);

        for(int i=0; i<6; i++){
            extractor.actualizar();
        }

        try{
            extractor.ingresarUnidad(new Zangano());
        } catch (EdificioNoTerminoDeConstruirse e){
            expected = false;
        }
        Assertions.assertTrue(expected);
    }
    @Test
    public void ExtractorNoEstaOperativoAntesDe6Turnos() {
        Coordenada ubicacion = new Coordenada(2 , 2);
        Extractor extractor = new Extractor(ubicacion);

        for(int i=0; i<5; i++){
            extractor.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            extractor.ingresarUnidad(new Zangano());
        });
    }



/*
    @Test
    public void criaderoSeConstruyeEnTiempoAdecuado() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        Edificio edificioEnCasilla = algoStar.seleccionarCasilla(1,1).devolverEdificio();
        algoStar.generarUnidad(1,1); // Se generara una unidad en la casilla(1,1)
        Unidad zanganoDisponible = algoStar.seleccionarCasilla(1,1).devolverUnidad();
        algoStar.moverDerecha(1,1);
        Casilla casillaConZangano = algoStar.seleccionarCasilla(2,1);
        Assertions.assertTrue( casillaConZangano.devolverUnidad() instanceof Zangano);
        algoStar.construirEdificio(2,1, new Criadero());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        Assertions.assertFalse(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Criadero);
        algoStar.pasarTurno();
        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverEdificio() instanceof Criadero);
    }

    @Test
    public void criaderoEstaOperativoLuegoDeConstruirse() {
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();
        algoStar.generarUnidad(1,1); // Se generara una unidad en la casilla(0,0)
        algoStar.moverDerecha(1,1);
        algoStar.construirEdificio(2,1, new Criadero());

        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        algoStar.pasarTurno();

        algoStar.generarUnidad(2,1);
        Assertions.assertTrue(algoStar.seleccionarCasilla(2,1).devolverUnidad() instanceof Zangano);
    }
    */
}