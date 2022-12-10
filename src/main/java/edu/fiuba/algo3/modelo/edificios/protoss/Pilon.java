package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioDestruido;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.CoordenadaFueraDelMapa;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

import java.util.ArrayList;
import java.util.List;

public class Pilon extends EdificioProtoss {

    private int radioAEnergizar = 3;

    private int turno = 0;
    List<Coordenada> coordenadasEnergizadas = new ArrayList<Coordenada>();

    private Recurso suministroAAgregar = new Suministro(5);

    public Pilon() {
        this.costoEnMinerales = new Mineral(100);
        this.costoEnGas = new GasVespeno(0);
        this.tiempoDeConstruccion = 5;
        this.vida = new Vida(300);
        this.escudo = new Escudo(300);
        this.nombre = new Nombre("Pilon");
        establecerEstado(new EdificioEnConstruccion());
    }

    @Override
    public void actualizarEdificio(Inventario inventario) {
        regenerar();
        if(turno == 0){ //para optimizar solo energizo en el primer turno que esta construido el pilon
            energizarTerrenos();
        }
        turno++;
    }

    private void energizarTerrenos(){
        buscarCoordenadasConTerrenoEnergizado(radioAEnergizar);
        for(Coordenada coordenadaAEnergizar : coordenadasEnergizadas) {
            try{
                Mapa.devolverInstancia().buscarTerreno(coordenadaAEnergizar).energizarTerreno();
            } catch (CoordenadaFueraDelMapa exception){}
        }
    }

    private void buscarCoordenadasConTerrenoEnergizado(int radio){
        List<Coordenada> coordenadas = coordenada.hallarCoordenadasAdyacentes(radio);
        for(Coordenada coordenadaHallada : coordenadas) {
            coordenadasEnergizadas.add(coordenadaHallada);
        }
    }
    @Override
    public void ejecutarDanio(Danio danio) {
        if(this.vida.recibirDanio(new Danio(escudo.recibirDanio(danio) * (-1)))){
            this.establecerEstado(new EdificioDestruido());
            throw new EdificioEstaDestruido();
        }
    }
    @Override
    public void desenergizarTerrenos(){
        buscarCoordenadasConTerrenoEnergizado(radioAEnergizar);
        for(Coordenada coord : coordenadasEnergizadas) {
            try{
                Mapa.devolverInstancia().buscarTerreno(coord).desenergizarTerreno();
            } catch (CoordenadaFueraDelMapa exception){}
        }
    }

    @Override
    public void agregarSuministro(Inventario inventario) {
        inventario.agregarSuministro(suministroAAgregar);
    }

    @Override
    public void restarSuministros(Inventario inventario) {
        inventario.restarSuministro(suministroAAgregar);
    }

    public void ocupar(Terreno terreno){
        terreno.ocuparPorEdificio(this);
        this.terreno = terreno;
    }
    

}
