package edu.fiuba.algo3.modelo.edificios.estados;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaInoperativo;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class EdificioInoperativo implements EstadoEdificio{

    private Edificio edificio;

    public void recibirDanio(Danio danio) {
        this.edificio.ejecutarDanio(danio);
    }

    @Override
    public void actualizar(Inventario inventario) {
    }

    @Override
    public void ingresarUnidad(Unidad unidad) {
        throw new EdificioEstaInoperativo();
    }

    @Override
    public void establecerEdificio(Edificio edificio) {
        this.edificio = edificio;
    }


    public Unidad generarUnidad(Unidad unidad,Inventario inventario)  {
        throw new EdificioEstaInoperativo();
    }

    public boolean consumirLarva(int larvas) {
        return false;
    }

    public void volverOperativo() {
        edificio.establecerEstado(new EdificioOperativo());
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("estado", "edificioInoperativo");
        return nodo;
    }

}
