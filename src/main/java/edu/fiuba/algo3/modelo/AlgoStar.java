package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.zerg.Extractor;

import java.util.ArrayList;
import java.util.List;

public class AlgoStar {

    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private int idJugadorActual;

    private int turnoActual;
    private int rondaActual;

    private Mapa mapa;

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() < 2) {
            jugador.establecerId(jugadores.size());
            jugadores.add(jugador);
        } else {
            // TODO: Lanzar excepcion "SeEstaTratandoDePonerMasDe2Jugadores"
        }
    }

    public void empezarJuego() {
        this.mapa = new Mapa(new Coordenada(100,20));
        for (Jugador jugador : jugadores) {
            jugador.establecerMapa(mapa);
        }
        this.idJugadorActual = 0;
        this.turnoActual = 0;
        this.rondaActual = 0;
    }

    public Jugador hallarJugadorActual() {
        return jugadores.get(idJugadorActual);
    }

    public void pasarTurno(){
        idJugadorActual++;
        turnoActual++;
        if (turnoActual % jugadores.size() == 0) {
            idJugadorActual = 0;
            rondaActual++;
        }
        mapa.actualizar(turnoActual);
    }

    public Mapa devolverMapa() {
        return mapa;
    }

    public Jugador devolverJugadorActual() {
        return jugadores.get(idJugadorActual);
    }
    
    /*
    public List<Jugador> jugadores = new ArrayList<Jugador>();
    private int idJugadorActual;

    private int turnoActual;
    private int rondaActual;

    private Mapa mapa;

    public void empezarJuego() {
        this.mapa = new Mapa(10,10);
        this.jugadores.add(new JugadorZerg(mapa));
        this.jugadores.add(new JugadorProtoss(mapa));
        this.idJugadorActual = 0;
        this.turnoActual = 0;
        this.rondaActual = 0;
    }

    public Jugador hallarJugadorActual() {
        return jugadores.get(idJugadorActual);
    }

    public void pasarTurno() {
        idJugadorActual++;
        turnoActual++;
        if (turnoActual % jugadores.size() == 0) {
            idJugadorActual = 0;
            rondaActual++;
        }
        mapa.actualizar(rondaActual);
        hallarJugadorActual().recogerRecursos();
    }

    public Casilla seleccionarCasilla(int x, int y) {
        return mapa.buscarCasilla(x,y);
    }

    public Unidad seleccionarUnidadDisponible(int id) {
        return hallarJugadorActual().buscarUnidadDisponible(id);
    }

    public void generarUnidad(int x, int y) {
        if (this.mapa.buscarCasilla(x, y).devolverEdificio() instanceof GeneradorDeUnidades) {
            Casilla casilla = this.mapa.buscarCasilla(x, y);
            hallarJugadorActual().generarUnidad(casilla);
        }
    }

    public void generarUnidad(Casilla casilla) {
        if (casilla.devolverEdificio() instanceof GeneradorDeUnidades) {
            hallarJugadorActual().generarUnidad(casilla);
        }
    }

    public void moverUnidad(Unidad unidad, Casilla nuevaCasilla) {
        hallarJugadorActual().moverUnidad(unidad, nuevaCasilla);
    }

    public void moverDerecha(int x, int y) {
        Casilla casilla = mapa.buscarCasilla(x, y);
        Unidad unidad = casilla.devolverUnidad();
        Casilla casillaObjetivo = mapa.buscarCasilla(x+1,y);
        if(unidad != null){
            if (mapa.validarMovimiento(unidad,casillaObjetivo)){
                boolean movimientoExitoso = unidad.intentarMoverse(casillaObjetivo);
                if (movimientoExitoso) {
                    mapa.buscarCasilla(x,y).establecerUnidad(null);
                }
            }
        }
    }
    public void moverArriba(int x, int y) {
        Casilla casilla = mapa.buscarCasilla(x, y);
        Unidad unidad = casilla.devolverUnidad();
        Casilla casillaObjetivo = mapa.buscarCasilla(x,y+1);
        if(unidad != null){
            if (mapa.validarMovimiento(unidad,casillaObjetivo)){
                boolean movimientoExitoso = unidad.intentarMoverse(casillaObjetivo);
                if (movimientoExitoso) {
                    mapa.buscarCasilla(x,y).establecerUnidad(null);
                }
            }
        }
    }
    public void moverAbajo(int x, int y) {
        Casilla casilla = mapa.buscarCasilla(x, y);
        Unidad unidad = casilla.devolverUnidad();
        Casilla casillaObjetivo = mapa.buscarCasilla(x,y-1);
        if(unidad != null){
            if (mapa.validarMovimiento(unidad,casillaObjetivo)){               
                boolean movimientoExitoso = unidad.intentarMoverse(casillaObjetivo);
                if (movimientoExitoso) {
                    mapa.buscarCasilla(x,y).establecerUnidad(null);
                }
            }
        }
    }
    public void moverIzquierda(int x, int y) {
        Casilla casilla = mapa.buscarCasilla(x, y);
        Unidad unidad = casilla.devolverUnidad();
        Casilla casillaObjetivo = mapa.buscarCasilla(x-1,y);
        if(unidad != null){
            if (mapa.validarMovimiento(unidad,casillaObjetivo)){               
                boolean movimientoExitoso = unidad.intentarMoverse(casillaObjetivo);
                if (movimientoExitoso) {
                    mapa.buscarCasilla(x,y).establecerUnidad(null);
                }
            }
        }
    }

    public void ingresarUnidad(int x, int y){
        Unidad unidad = mapa.buscarCasilla(x,y).devolverUnidad();
        boolean ingresoExitoso = ((Extractor) mapa.buscarCasilla(x,y).devolverEdificio()).ingresarUnidad(unidad); //falta chequear instanceOf
        if(ingresoExitoso){
            mapa.buscarCasilla(x,y).establecerUnidad(null);
        }
    }

    public int devolverCantidadGas(){
        return hallarJugadorActual().devolverCantidadGas();
    }

    public int devolverCantidadMinerales(){
        return hallarJugadorActual().devolverCantidadMinerales();
    }
    
    public void construirEdificio(int x, int y, Edificio edificio) {//Usar solo por ahora, dsps hay que eliminarlo
        hallarJugadorActual().construirEdificio(x, y, edificio);
    }

    public void atacarEdificioALaDerecha(int x, int y) {
        Casilla casilla = mapa.buscarCasilla(x, y);
        Unidad unidad = casilla.devolverUnidad();
        Casilla casillaObjetivo = mapa.buscarCasilla(x+1,y);
        if(unidad != null){
            if (casillaObjetivo.devolverUnidad() instanceof Unidad) {
                //casillaObjetivo.devolverUnidad().recibirDanio(casilla.devolverUnidad().emitirDanio());
            } else if (casillaObjetivo.devolverEdificio() instanceof Edificio) {
                boolean edificioFueDestruido = mapa.buscarCasilla(x+1, y).devolverEdificio().recibirDanio(casilla.devolverUnidad().emitirDanio());
                if (edificioFueDestruido) {
                    mapa.buscarCasilla(x+1, y).establecerEdificio(null);
                }
            }
        }
    }
*/
}
