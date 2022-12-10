package edu.fiuba.algo3.modelo.edificios.estados;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface EstadoEdificio {

    void actualizar(Inventario inventario);

    Unidad generarUnidad(Unidad unidad, Inventario inventario);
    
    void ingresarUnidad(Unidad unidad);

    void recibirDanio(Danio danio);

    void terminarConstruccion();

    void deshacerConstruccion();

    void establecerEdificio(Edificio edificio);


    boolean consumirLarva(int larvas);

    ObjectNode toData();

}
