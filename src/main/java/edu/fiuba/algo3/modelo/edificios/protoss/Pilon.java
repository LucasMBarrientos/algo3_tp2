package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Nombre;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioDestruido;
import edu.fiuba.algo3.modelo.edificios.estados.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

import java.util.List;

public class Pilon extends EdificioProtoss {

    private int radioAEnergizar = 3;

    private int turno = 0;

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
        energizarTerrenos();
    }

    private void energizarTerrenos(){
        List<Terreno> terrenosAEnergizar = Mapa.devolverInstancia().buscarTerrenosAdyacentes(coordenada, radioAEnergizar);
        for (Terreno terreno : terrenosAEnergizar) {
            terreno.energizarTerreno();
        }
    }

    public void desenergizarTerrenos(){
        List<Terreno> terrenosAEnergizar = Mapa.devolverInstancia().buscarTerrenosAdyacentes(coordenada, radioAEnergizar);
        for (Terreno terreno : terrenosAEnergizar) {
            terreno.desenergizarTerreno();
        }
    }

    @Override
    public void ejecutarDanio(Danio danio) {
        if(this.vida.recibirDanio(new Danio(escudo.recibirDanio(danio) * (-1)))){
            desenergizarTerrenos();
            this.establecerEstado(new EdificioDestruido());
            throw new EdificioEstaDestruido();
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
