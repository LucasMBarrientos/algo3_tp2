package edu.fiuba.algo3.modelo.edificios.estados;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
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
        edificio.destruirse(inventario);

    }

    public Unidad generarUnidad(Unidad unidad,Inventario inventario) throws EdificioEstaDestruido {
        throw new EdificioEstaDestruido();
    }

    @Override
    public void establecerEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public void ingresarUnidad(Unidad unidad) {
    }

    public void volverOperativo() { }

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
