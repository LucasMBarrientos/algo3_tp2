package edu.fiuba.algo3.modelo.edificios;

import java.util.List;

import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class EdificioDestruido implements EstadoEdificio {

    private Edificio edificio;

    @Override
    public void recibirGolpe(Danio danio) throws EdificioEstaDestruido {
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
        edificio.actualizarListasDeCoordenadas(coordenadasConCriaderos, coordenadasConPilones);
        //coordenadasConPilones.add(coordenada);
    }

    @Override
    public void ingresarUnidad(Zangano zangano) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean consumirLarva(int larvas) {
        return false;
    }
  
}
