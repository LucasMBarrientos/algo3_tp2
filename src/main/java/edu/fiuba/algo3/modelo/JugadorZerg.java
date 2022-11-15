package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class JugadorZerg extends Jugador {

    public JugadorZerg(Mapa mapa) {
        this.id = 0;
        this.mapa = mapa;
        this.inventario = new Inventario(new GasVespeno(0), new Minerales(200));
    }

    @Override
    public void construirEdificio(Coordenada coord, Edificio edificio) {
      mapa.buscarCasilla(coord).ponerEdificio(edificio.construir(inventario));
    }

    public void actualizar() {
        inventario.actualizar();
    }

    public Inventario devolInventario() {
        return this.inventario;
    }

    public void atacar(Coordenada coordenadaUnidad, Direccion direccion){
        Unidad unidad = mapa.buscarCasilla(coordenadaUnidad).devolverUnidad();
        if(unidad == null){
            throw new UnidadInexistente();
        }
        unidad.atacar(direccion, mapa);
    }

    public void moverse(Coordenada coordenadaUnidad, Direccion direccion){
        Unidad unidad = mapa.buscarCasilla(coordenadaUnidad).devolverUnidad();
        if(unidad == null){
            throw new UnidadInexistente();
        }
        unidad.moverse(direccion, mapa);

    }





    /*
    public JugadorZerg(Mapa mapa) {
        Criadero criaderoInicial = new Criadero();
        mapa.buscarCasilla(1,1).establecerEdificio(criaderoInicial);
        mapa.generarMoho(5);
        this.establecerMapa(mapa);
    }


    public Casilla generarUnidad(Casilla casillaDelGenerador) {
        GeneradorDeUnidades edificioGenerador = (GeneradorDeUnidades) casillaDelGenerador.devolverEdificio();
        edificioGenerador.generarUnidad(casillaDelGenerador);
       // unidadGenerada.establecerCasilla(casillaDisponible);
       // this.unidadesDisponibles.add(unidadGenerada);
        return casillaDelGenerador;
    }

    public void construirEdificio(int x, int y, Edificio edificio) {        
        boolean requerimientosAlcanzados = edificio.validarRequirimientos(inventario) && mapa.buscarCasilla(x,y).devolverEdificio() == null;
        if (this.mapa.buscarCasilla(x,y).devolverUnidad() instanceof Constructor && requerimientosAlcanzados) {
            if (edificio instanceof Espiral) {
                if (mapa.buscarEdificioGuarida()) {
                    mapa.buscarCasilla(x,y).establecerUnidad(new ConstruccionProtoss(edificio, mapa.buscarCasilla(x,y)));
                    edificio.consumirRecursosDelJugador(inventario);
                }
            } else {
                Constructor unidadConstructora = (Constructor) this.mapa.buscarCasilla(x,y).devolverUnidad();
                unidadConstructora.construir(edificio,mapa.buscarCasilla(x,y));
                edificio.consumirRecursosDelJugador(inventario);
            }
        }
    }

    public void recogerRecursos() {
        TieneRecursos edificioConRecursos = this.mapa.buscarEdificiosZergConRecursos();
        while (edificioConRecursos != null) {
            inventario.agregarRecursos(edificioConRecursos.recolectarRecursos());
            edificioConRecursos = this.mapa.buscarEdificiosZergConRecursos();
        }
        recogerRecursosDeZanganosMineros();
    }

    public void recogerRecursosDeZanganosMineros() {
        TieneRecursos zanganoExtrayendoMinerales = this.mapa.buscarMineralesConZanganos();
        while (zanganoExtrayendoMinerales != null) {
            Recursos nuevosRecursos = zanganoExtrayendoMinerales.recolectarRecursos();
            if (nuevosRecursos != null) {
                inventario.agregarRecursos(zanganoExtrayendoMinerales.recolectarRecursos());
            }
            zanganoExtrayendoMinerales = this.mapa.buscarMineralesConZanganos();
        }
    }*/
}
