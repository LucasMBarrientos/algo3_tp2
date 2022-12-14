package edu.fiuba.algo3.modelo.edificios.estados;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class EdificioEnConstruccion implements EstadoEdificio {

    private Edificio edificio;

    @Override
    public void actualizar(Inventario inventario) {
        if (edificio.reducirTiempoConstruccion(1)) {
            edificio.agregarSuministro(inventario);
            edificio.establecerEstado(new EdificioOperativo());
        }
    }

    @Override
    public void recibirDanio(Danio danio) throws EdificioNoTerminoDeConstruirse {
        throw new EdificioNoTerminoDeConstruirse();
    }

    public Unidad generarUnidad(Unidad unidad,Inventario inventario) throws EdificioNoTerminoDeConstruirse {
        throw new EdificioNoTerminoDeConstruirse();
    }

    @Override
    public void establecerEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public void ingresarUnidad(Unidad unidad) {
        return;
    }

    @Override
    public boolean consumirLarva(int larvas) {
        return false;
    }

    public void volverOperativo() { }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("estado", "edificioEnConstruccion");
        return nodo;
    }
  
}
