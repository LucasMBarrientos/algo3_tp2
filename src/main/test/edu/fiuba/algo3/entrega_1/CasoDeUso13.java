package edu.fiuba.algo3.entrega_1;

public class CasoDeUso13 {

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

        // Se intenta construir una reserva de reproduccion fuera del rango del moho generado por ese criadero
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
