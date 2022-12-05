package edu.fiuba.algo3.modelo.unidades.zerg;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.jugadores.Nombre;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.unidades.UnidadZerg;

public class Mutalisco extends UnidadZerg {

    public Mutalisco() {
        this.costoEnGas = new GasVespeno(25);
        this.costoEnMinerales = new Mineral(75);
        this.costoSuministro = new Suministro(4);
        this.tiempoConstruccion = 7;
        this.danioAereo = new Danio(9);
        this.danioTerrestre = new Danio(9);
        this.rango = 3;
        this.vida = new Vida(120);
        this.nombre = new Nombre("Mutalisco");
        this.aerea = true; // -> sidenote: la palabra aerea es capicúa :)
        establecerEstado(new UnidadEnConstruccion());
    }
    public Unidad generarse(Edificio edificio, Inventario inventario){
        return edificio.generarUnidad(this, inventario);
    }

    public boolean ocupar(Terreno terreno){
        boolean sePudoOcupar = true;

        try {
            terreno.ocuparPorUnidad(this);
        } catch (RuntimeException e){
            sePudoOcupar = false;
        }

        return sePudoOcupar;
    }
    @Override
    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("nombre","Mutalisco");
        return node;
    }
    @Override
    public Unidad evolucionar(Mapa mapa, Unidad unidad){
        mapa.eliminarUnidad(coordenada);
        mapa.establecerUnidad(coordenada,unidad);
        return unidad;
    }

    @Override
    public void actualizarUnidad(Inventario inventario) {
      regenerar();
    }

}
