
package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.JugadorProtoss;
import edu.fiuba.algo3.modelo.unidades.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMoho;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso14 {
    @Test
    public void EnergizadoNoPisaMoho() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 325, 0);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());
        jugadorProtoss.construirEdificio(new Coordenada(4,4), new Pilon());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }


        //Assertions.assertThrows(EdificioDestruido.class, pilon::actualizar); //TODO agregar state edificio destruido @Leti
        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
        jugadorProtoss.construirEdificio(new Coordenada(15,2), new pilon());
        });
    }
    */


}

    @Test
    public void EnergizadoNoPisaMoho(){
        Pilon pilon = new Pilon();
        for (int i = 0; i < 6; i++) {
            pilon.actualizar();
        } //paso los turnos para que se termine de construir

        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();


        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertTrue(algoStar.seleccionarCasilla(7,6).devolverTerreno() instanceof TerrenoMoho);
        algoStar.construirEdificio(7,8,new Pilon());
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertTrue(algoStar.seleccionarCasilla(7,6).devolverTerreno() instanceof TerrenoMoho);

        algoStar.construirEdificio(7,6,new Pilon());

        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertFalse(algoStar.seleccionarCasilla(7,6).devolverEdificio() instanceof Pilon);

    }
    /*

    @Test
    public void MohoNoPisaEnergizado(){
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();

        Assertions.assertTrue(algoStar.seleccionarCasilla(8,9).devolverTerreno() instanceof TerrenoEnergizado);
        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertTrue(algoStar.seleccionarCasilla(8,9).devolverTerreno() instanceof TerrenoEnergizado);

    }

    @Test
    public void EnergizadoNoPisaMoho(){
        AlgoStar algoStar = new AlgoStar();
        algoStar.empezarJuego();


        for (int i = 0; i < 20; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertTrue(algoStar.seleccionarCasilla(7,6).devolverTerreno() instanceof TerrenoMoho);
        algoStar.construirEdificio(7,8,new Pilon());
        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertTrue(algoStar.seleccionarCasilla(7,6).devolverTerreno() instanceof TerrenoMoho);

        algoStar.construirEdificio(7,6,new Pilon());

        for (int i = 0; i < 10; i++) {
            algoStar.pasarTurno();
        }
        Assertions.assertFalse(algoStar.seleccionarCasilla(7,6).devolverEdificio() instanceof Pilon);

    }*/
}
    @Test
    public void unCriaderoNoEstaOperativoEnMenosDe4TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        int tiempoDeConstruccion = 4;

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            criadero.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }
    @Test
    public void unCriaderoEstaOperativoTras4TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        int tiempoDeConstruccion = 4;
        for (int i = 0; i < tiempoDeConstruccion; i++) {
            criadero.actualizar();
        }
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }
    @Test
    public void unaReservaDeReproduccionNoEstaOperativaEnMenosDe12TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        int tiempoDeConstruccion = 12;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            reservaDeReproduccion.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            reservaDeReproduccion.generarUnidad(criadero, new Zerling());
        });
    }
    @Test
    public void unaReservaDeReproduccionEstaOperativaTras12TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        int tiempoDeConstruccion = 12;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for (int i = 0; i < tiempoDeConstruccion; i++) {
            reservaDeReproduccion.actualizar();
        }
        reservaDeReproduccion.generarUnidad(criadero, new Zerling());
        reservaDeReproduccion.generarUnidad(criadero, new Zerling());
        reservaDeReproduccion.generarUnidad(criadero, new Zerling());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            reservaDeReproduccion.generarUnidad(criadero, new Zerling());
        });
    }
    @Test
    public void unaExtractorNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        Extractor extractor = new Extractor();
        int tiempoDeConstruccion = 6;
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            extractor.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            extractor.extraerRecursos();
        });
    }

    @Test
    public void unExtractorEstaOperativoTras6TurnosConstruyendose() {
        Extractor extractor = new Extractor();
        int tiempoDeConstruccion = 6;
        for (int i = 0; i < tiempoDeConstruccion; i++) {
            extractor.actualizar();
        }
        Recursos recursosExtraidos = extractor.extraerRecursos();
        Assertions.assertNotNull(recursosExtraidos);
    }
    @Test
    public void unaGuaridaNoEstaOperativaEnMenosDe12TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        Guarida guarida = new Guarida();
        int tiempoDeConstruccion = 12;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            guarida.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            guarida.generarUnidad(criadero, new Hidralisco());
        });
    }
    @Test
    public void unaGuaridaEstaOperativaTras12TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        Guarida guarida = new Guarida();
        int tiempoDeConstruccion = 12;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for (int i = 0; i < tiempoDeConstruccion; i++) {
            guarida.actualizar();
        }
        guarida.generarUnidad(criadero, new Hidralisco());
        guarida.generarUnidad(criadero, new Hidralisco());
        guarida.generarUnidad(criadero, new Hidralisco());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            guarida.generarUnidad(criadero, new Hidralisco());
        });
    }
    @Test
    public void unaEspiralNoEstaOperativaEnMenosDe10TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        Espiral espiral = new Espiral();
        int tiempoDeConstruccion = 10;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            espiral.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            espiral.generarUnidad(criadero, new Mutalisco());
        });
    }
    @Test
    public void unaEspiralEstaOperativaTras10TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        Espiral espiral = new Espiral();
        int tiempoDeConstruccion = 10;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for(int i = 0; i < tiempoDeConstruccion; i++) {
            espiral.actualizar();
        }
        guarida.generarUnidad(criadero, new Mutalisco());
        guarida.generarUnidad(criadero, new Mutalisco());
        guarida.generarUnidad(criadero, new Mutalisco());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            guarida.generarUnidad(criadero, new Mutalisco());
        });
    }
    // Edificios protoss
    @Test
    public void unNexoMineralNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        NexoMineral nexoMineral = new NexoMineral();
        int tiempoDeConstruccion = 4;
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            nexoMineral.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            nexoMineral.extraerRecursos();
        });
    }

    @Test
    public void unNexoMineralEstaOperativoTras5TurnosConstruyendose() {
        NexoMineral nexoMineral = new NexoMineral();
        int tiempoDeConstruccion = 4;
        for (int i = 0; i < tiempoDeConstruccion; i++) {
            nexoMineral.actualizar();
        }
        Recursos recursosExtraidos = nexoMineral.extraerRecursos();
        Assertions.assertNotNull(recursosExtraidos);
    }
    @Test
    public void unPilonNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.agregarJugador(new JugadorZerg("La mente suprema", "#ff0000"););
        algoStar.empezarJuego();
        int tiempoDeConstruccion = 5;
        jugadorProtoss.construirEdificio(new Coordenada(2,2), new Pilon());
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(3,2), new Acceso());
        }
    }
    @Test
    public void unPilonEstaOperativoTras5TurnosConstruyendose() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.agregarJugador(new JugadorZerg("La mente suprema", "#ff0000"););
        algoStar.empezarJuego();
        int tiempoDeConstruccion = 5;
        jugadorProtoss.construirEdificio(new Coordenada(2,2), new Pilon());
        for (int i = 0; i < tiempoDeConstruccion; i++) {
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        jugadorProtoss.construirEdificio(new Coordenada(3,2), new Acceso());
        for (int i = 0; i < 12; i++) {
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorProtoss.generarUnidad(new Coordenada(3,2), new Zealot());
        }
    }
    @Test
    public void unAsimiladorNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        Asimilador asimilador = new Asimilador();
        int tiempoDeConstruccion = 6;
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            asimilador.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            asimilador.extraerRecursos();
        });
    }

    @Test
    public void unAsimiladorEstaOperativoTras6TurnosConstruyendose() {
        Asimilador asimilador = new Asimilador();
        int tiempoDeConstruccion = 6;
        for (int i = 0; i < tiempoDeConstruccion; i++) {
            asimilador.actualizar();
        }
        Recursos recursosExtraidos = asimilador.extraerRecursos();
        Assertions.assertNotNull(recursosExtraidos);
    }
    @Test
    public void unAccesoNoEstaOperativoEnMenosDe8TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        Acceso acceso = new Acceso();
        int tiempoDeConstruccion = 8;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            acceso.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            acceso.generarUnidad(criadero, new Zealot());
        });
    }
    @Test
    public void unAccesoEstaOperativoTras8TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        Acceso acceso = new Acceso();
        int tiempoDeConstruccion = 8;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            acceso.actualizar();
        }
        acceso.generarUnidad(criadero, new Zealot());
        acceso.generarUnidad(criadero, new Zealot());
        acceso.generarUnidad(criadero, new Zealot());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            acceso.generarUnidad(criadero, new Zealot());
        });
    }
    @Test
    public void unPuertoEstelarNoEstaOperativoEnMenosDe10TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        int tiempoDeConstruccion = 10;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            puertoEstelar.actualizar();
        }
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            puertoEstelar.generarUnidad(criadero, new Scout());
        });
    }
    @Test
    public void unPuertoEstelarEstaOperativoTras8TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        int tiempoDeConstruccion = 10;
        for (int i = 0; i < 4; i++) { // Se finaliza la construccion del criadero
            criadero.actualizar();
        }
        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            puertoEstelar.actualizar();
        }
        puertoEstelar.generarUnidad(criadero, new Scout());
        puertoEstelar.generarUnidad(criadero, new Scout());
        puertoEstelar.generarUnidad(criadero, new Scout());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            puertoEstelar.generarUnidad(criadero, new Scout());
        });
    }
    */

            }

             /*
	@Test
    public void sePuedeConstruirSobreElMohoDeUnCriaderoDestruido() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "#ff0000", 325, 0);
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();
        // Se construye un criadero
        jugadorZerg.construirEdificio(new Coordenada(2,2), new Criadero());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }
        // Se generan 2 zanganos
        jugadorZerg.generarUnidad(new Coordenada(2,2), new Derecha(), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        jugadorZerg.moverUnidad(new Coordenada(3,2), new Derecha());
        jugadorZerg.generarUnidad(new Coordenada(2,2), new Derecha(), new Zangano());
        algoStar.pasarTurno();
        algoStar.pasarTurno();
        // Se destruye el criadero
        jugadorZerg.destruirEdificio(new Coordenada(2,2)); // TODO: Todo jugador deberia tener acceso a destruir sus propias unidades/edificios
        // Se construye una reserva de reproduccion sobre el moho generado previamente
        jugadorZerg.construirEdificio(new Coordenada(3,2), new ReservaDeReproduccion());
        for (int i = 0; i < 8; i++) {
            algoStar.pasarTurno();
        }
        // Se construye una reserva de reproduccion fuera del rango del moho generado por ese criadero
        for (int x = 4; x < 15; x++) {
            jugadorZerg.moverUnidad(new Coordenada(x,2), new Derecha());
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }
        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorZerg.construirEdificio(new Coordenada(15,2), new ReservaDeReproduccion());
        });
    }
    */

            }
