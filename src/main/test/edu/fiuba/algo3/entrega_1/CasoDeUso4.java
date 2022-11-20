package edu.fiuba.algo3.entrega_1;

public class CasoDeUso4 {

    /*

    @Test
    public void extractorSinZanganosNoGeneraGas() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo",50); // El jugador zerg empieza con 250 unidades de minerales y 50 unidades de gas
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, new Derecha());
        jugadorZerg.moverUnidad(casillaConCriadero, new Derecha());

        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        for(int i = 0; i < 10; i++) { // Se da un par de turnos para intentar conseguir recursos suficientes para construir una espiral
            algoStar.pasarTurno();
        }

        Coordenada coordenadaConMoho = casillaConCriadero.hallarCoordenadasAdyacentes().get(0);
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, coordenadaConMoho);
        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            jugadorZerg.construirEdificio(coordenadaConMoho, new Espiral());
        });
    }

    @Test
    public void extractorCon1ZanganoGenera10UnidadesDeGas() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo",50); // El jugador zerg empieza con 250 unidades de minerales y 50 unidades de gas
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConVolcan);
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        jugadorZerg.generarUnidad(casillaConCriadero.devolverCoordendas());
        jugadorZerg.moverUnidad(casillaConCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
        jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        for(int i = 0; i < 10; i++) { // Despues de 5 turnos del jugador zerg (10 turnos totales), el jugador deberia tener 100 unidades de gas
            algoStar.pasarTurno();
        }

        Coordenada coordenadaConMoho = casillaConCriadero.hallarCoordenadasAdyacentes().get(0);
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, coordenadaConMoho);
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(coordenadaConMoho, new Espiral());
        } catch (RecursosInsuficientes e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }

    @Test
    public void extractorCon2ZanganoGenera20UnidadesDeGas() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo",50); // El jugador zerg empieza con 250 unidades de minerales y 50 unidades de gas
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConVolcan);
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        for (int i=0; i < 2; i++) {
            jugadorZerg.generarUnidad(casillaConCriadero.devolverCoordendas());
            jugadorZerg.moverUnidad(casillaConCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
            jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        }
        for(int i = 0; i < 6; i++) { // Despues de 3 turnos del jugador zerg (6 turnos totales), el jugador deberia tener 120 unidades de gas
            algoStar.pasarTurno();
        }

        Coordenada coordenadaConMoho = casillaConCriadero.hallarCoordenadasAdyacentes().get(0);
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, coordenadaConMoho);
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(coordenadaConMoho, new Espiral());
        } catch (RecursosInsuficientes e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }

    @Test
    public void extractorCon3ZanganoGenera30UnidadesDeGas() {
        AlgoStar algoStar = new AlgoStar();
        JugadorZerg jugadorZerg = new JugadorZerg("La mente suprema", "rojo",50); // El jugador zerg empieza con 250 unidades de minerales y 50 unidades de gas
        algoStar.agregarJugador(jugadorZerg);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "azul");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.empezarJuego();

        Casilla casillaConCriadero = jugadorZerg.hallarCasillaConEdificioInicial();
        Casilla casillaConVolcan = jugadorZerg.hallarCasillaConVolcanInicial();
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, casillaConVolcan);
        jugadorZerg.construirEdificio(casillaConVolcan.devolverCoordendas(), new Extractor());
        for(int i = 0; i < 6; i++) { // Se finaliza la construccion del extractor
            algoStar.pasarTurno();
        }
        for (int i=0; i < 2; i++) {
            jugadorZerg.generarUnidad(casillaConCriadero.devolverCoordendas());
            jugadorZerg.moverUnidad(casillaConCriadero.devolverCoordendas(), casillaConVolcan.devolverCoordenada()); // Mover la unidad desde el criadero hasta la casilla con el extractor
            jugadorZerg.ingresarUnidadAlEdificio(casillaConVolcan.devolverCoordenada()); // Meter al zangano adentro extractor
        }
        for(int i = 0; i < 4; i++) { // Despues de 2 turnos del jugador zerg (4 turnos totales), el jugador deberia tener 110 unidades de gas
            algoStar.pasarTurno();
        }

        Coordenada coordenadaConMoho = casillaConCriadero.hallarCoordenadasAdyacentes().get(0);
        jugadorZerg.generarUnidad(casillaConCriadero);
        jugadorZerg.moverUnidad(casillaConCriadero, coordenadaConMoho);
        boolean intentoExitoso = true;
        try {
            jugadorZerg.construirEdificio(coordenadaConMoho, new Espiral());
        } catch (RecursosInsuficientes e){
            intentoExitoso = false;
        }
        Assertions.assertTrue(intentoExitoso);
    }

    */

}
