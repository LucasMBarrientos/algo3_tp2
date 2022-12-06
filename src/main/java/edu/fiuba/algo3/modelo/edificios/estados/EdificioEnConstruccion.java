package edu.fiuba.algo3.modelo.edificios.estados;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class EdificioEnConstruccion implements EstadoEdificio {

    private Edificio edificio;

    @Override
    public void actualizar(Inventario inventario) {
        if (this.edificio.reducirTiempoConstruccion(1)) {
            this.edificio.agregarSuministro(inventario);
            this.terminarConstruccion();
        }
    }
    
    @Override
    public void terminarConstruccion() {
        edificio.establecerEstado(new EdificioOperativo());
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
    public void deshacerConstruccion() {
        return;
    }

    public void actualizarListasDeCoordenadas(List<Coordenada> coordenadasConCriaderos, List<Coordenada> coordenadasConPilones) {
        return;
    }

    @Override
    public void ingresarUnidad(Unidad unidad) {
        return;
    }

    @Override
    public boolean consumirLarva(int larvas) {
        return false;
    }

    public ObjectNode toData() {
        ObjectNode nodo = Json.createObjectNode();
        nodo.put("estado", "edificioEnConstruccion");
        return nodo;
    }
  
}
