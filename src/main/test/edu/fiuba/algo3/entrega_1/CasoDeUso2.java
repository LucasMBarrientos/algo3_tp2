package edu.fiuba.algo3.entrega_1;

public class CasoDeUso2 {

    /*

    // Edificios zerg
    
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
        Terreno terrenoVolcan = new TerrrenoVolcan();
        Extractor extractor = new Extractor(terrenoVolcan);
        int tiempoDeConstruccion = 6;
        extractor.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            extractor.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            extractor.extraerRecursos();
        });
    }
    
	@Test
    public void unExtractorEstaOperativoTras6TurnosConstruyendose() {
        Terreno terrenoVolcan = new TerrrenoVolcan();
        Extractor extractor = new Extractor(terrenoVolcan);
        int tiempoDeConstruccion = 6;
        extractor.ocupar(terrenoVolcan);

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
        TerrenoMineral terrenoMineral = new TerrenoMineral();
        NexoMineral nexoMineral = new NexoMineral();
        int tiempoDeConstruccion = 4;
        nexoMineral.ocupar(terrenoMineral);
        
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            nexoMineral.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            nexoMineral.extraerRecursos();
        });
    }
    
	@Test
    public void unNexoMineralEstaOperativoTras5TurnosConstruyendose() {
        TerrenoMineral terrenoMineral = new TerrenoMineral();
        NexoMineral nexoMineral = new NexoMineral();
        int tiempoDeConstruccion = 4;
        nexoMineral.ocupar(terrenoMineral);

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
    	// TODO: Pensar como probar la operatividad del pilon
    }

    @Test
    public void unAsimiladorNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        TerrenoVolcan terrenoVolcan = new TerrenoVolcan();
        Asimilador asimilador = new Asimilador();
        int tiempoDeConstruccion = 6;
        asimilador.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            asimilador.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            asimilador.extraerRecursos();
        });
    }
    
	@Test
    public void unAsimiladorEstaOperativoTras6TurnosConstruyendose() {
        TerrenoVolcan terrenoVolcan = new TerrenoVolcan();
        Asimilador asimilador = new Asimilador();
        int tiempoDeConstruccion = 6;
        asimilador.ocupar(terrenoVolcan);

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
