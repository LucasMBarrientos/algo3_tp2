package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.EdificioDestruido;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.Minerales;

public class Criadero extends EdificioZerg {

    private EstadoCriadero estado = new CriaderoEnConstruccion();
    private int tiempoDeConstruccion = 4;
    private Coordenada coordenada;

    private final Vida vida = new Vida(300);

    public Criadero() {
        this.costoEnMinerales = new Minerales(50);
    }


    public Criadero(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Zangano generarZangano() throws NoHayLarvasDisponibles{ //Leti: refactor aca.
        return estado.generarZangano();
    }

    public Unidad generarUnidad(Unidad unidad) throws NoHayLarvasDisponibles{
        return estado.generarUnidad(unidad);
    }

    public void actualizar() {
        estado.actualizar();
        tiempoDeConstruccion--;
        if(tiempoDeConstruccion == 0){
            estado = new CriaderoOperativo();
        }
        vida.regenerar();
    }
    @Override
    public void consumirRecursosParaConstruccion(Inventario inventario){
        inventario.consumirMinerales(costoEnMinerales);
    }

    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        vida.recibirDanio(danio);
    }

    public void ocupar(Casilla casilla){
        casilla.establecerEdificio(this);
    }


/*
    private int larvas;

    public Criadero() {
        this.larvas = 3;
        this.tiempoConstruccion = 4;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 50;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return (casilla.devolverTerreno() instanceof TerrenoMoho);
    }

    public void actualizar() {
        if (larvas < 3) {
            this.larvas++;
        }
        regenerarVida();
    }

    public int devolverCantidadDeLarvas() {
        return this.larvas;
    }

    public void generarUnidad(Casilla casilla) {
        Unidad unidadGenerada = null;
        if (larvas > 0) {
            unidadGenerada = new Zangano();
            this.larvas--;
             casilla.establecerUnidad(unidadGenerada);
        }
    }
    */
}
