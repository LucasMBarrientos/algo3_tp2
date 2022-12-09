package edu.fiuba.algo3.modelo.unidades.estados;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.Direccion;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.List;

public interface EstadoUnidad {

    void actualizar(Inventario inventario);

    public void moverse(Direccion direccion, Coordenada coordenada);

    public void atacar(Coordenada objetivo);

    public void recibirDanio(Danio danioTerrestre, Danio danioAereo);

    void setUnidad(Unidad unidad);

    void terminarConstruccion();

    void deshacerConstruccion();

    void actualizarListaDeCoordenadasVisibles(List<Coordenada> coordenadasAVisibilizar);

    ObjectNode toData();
}
