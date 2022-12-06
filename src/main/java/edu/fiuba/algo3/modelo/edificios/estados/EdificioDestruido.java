package edu.fiuba.algo3.modelo.edificios.estados;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class EdificioDestruido implements EstadoEdificio {

    private Edificio edificio;

    @Override
    public void recibirDanio(Danio danio) throws EdificioEstaDestruido {
        throw new EdificioEstaDestruido();
    }

    @Override
    public void actualizar(Inventario inventario) {
        return;
    }

    public Unidad generarUnidad(Unidad unidad,Inventario inventario) throws EdificioEstaDestruido {
        throw new EdificioEstaDestruido();
    }

    @Override
    public void terminarConstruccion() {
        return;
    }

    @Override
    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public void deshacerConstruccion() {
        return;
    }

    public void actualizarListasDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        return;
    }

    @Override
    public void ingresarUnidad(Unidad unidad) {
    }

    @Override
    public boolean consumirLarva(int larvas) {
        return false;
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("estado", "edificioDestruido");
        return nodo;
    }
  
}
