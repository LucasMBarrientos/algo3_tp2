package edu.fiuba.algo3.modelo.jugadores;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoEncontrado;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoAlcanzado;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.excepciones.UnidadNoEncontrada;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Edificio> edificios = new ArrayList<Edificio>();
    private List<Unidad> unidades = new ArrayList<Unidad>();
    public GasVespeno gasVespeno;
    public Mineral mineral;
    public Suministro suministro;
    
    public Inventario(GasVespeno gasVespeno, Mineral mineral,Suministro suministro) {
        this.gasVespeno = gasVespeno;
        this.mineral = mineral;
        this.suministro = suministro;
    }

    public void fueDerrotado() {
        if (contarEdificiosDestruidos() == this.edificios.size() && this.edificios.size() > 0) {
            throw new FinDelJuegoAlcanzado();
        }
    }

    private int contarEdificiosDestruidos() {
        int cuenta = 0;
        for (Edificio edificio : edificios) {
            try {
                edificio.ejecutarDanio(new Danio(0)); // TODO: cambiar esto?
            } catch (EdificioEstaDestruido e) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public Edificio buscarEdificio(Coordenada coordenada) {
        for(Edificio edificio : edificios){
            if (edificio.compararCoordenadas(coordenada)) {
                return edificio;
            }
        }
        throw new EdificioNoEncontrado();
    }

    public Unidad buscarUnidad(Coordenada coordenada) {
        return unidades.get(buscarIdDeUnidad(coordenada));
    }

    private int buscarIdDeUnidad(Coordenada coordenada) throws UnidadNoEncontrada {
        int indiceHallado = -1;
        for (int i = 0; i < this.unidades.size(); i++) {
            if (this.unidades.get(i).compararCoordenadas(coordenada)) {
                indiceHallado = i;
            }
        }
        if (indiceHallado == -1) {
            throw new UnidadNoEncontrada();
        }
        return indiceHallado;
    }

    public boolean tieneEdificio(Nombre nombreDelEdifico) {
        boolean edificioHallado = false;
        for (Edificio edificio : edificios) {
            if(nombreDelEdifico.esIgual(edificio.devolverNombre())){
                edificioHallado = true;
            }
        }
        return edificioHallado;
    }

    public void consumirLarva(){
        for(Edificio edificio : edificios){
            if(edificio.consumirLarva()){
                return;
            }
        }
        throw new NoHayLarvasSuficientes();
    }


    public void evolucionarUnidad(Mapa mapa, Coordenada coordenada, Unidad unidadAEvolucionar) {
        Unidad unidadGenerada = buscarUnidad(coordenada).evolucionar(mapa,unidadAEvolucionar);
        this.unidades.set(buscarIdDeUnidad(coordenada), unidadGenerada);
    }


    public void agregarEdificio(Edificio edificioNuevo) {
        edificios.add(edificioNuevo);
    }

    public void agregarUnidad(Unidad unidadNueva) {
        unidades.add(unidadNueva);
    }

    public void eliminarUnidad(Coordenada coordenada) {
        int indiceHallado = -1;
        for (int i=0; i < unidades.size(); i++) {
            if (unidades.get(i).compararCoordenadas(coordenada)) {
                indiceHallado = i;
            }
        }
        if (indiceHallado == -1) {
            throw new UnidadNoEncontrada();
        }
        unidades.get(indiceHallado).devolverSuministro(this);
        unidades.remove(unidades.get(indiceHallado));
    }

    public void agregarSuministro(Recurso suministro) {
        this.suministro.agregarUnidades(suministro);
    }

    public void agregarGasVespeno(Recurso gasVespeno) {
        this.gasVespeno.agregarUnidades(gasVespeno);
    }

    public void agregarMinerales(Recurso minerales) {
        this.mineral.agregarUnidades(minerales);
    }

    public void consumirSuministro(Recurso recursoRequerido) {
        suministro.gastar(recursoRequerido);
    }

    public void consumirGasVespeno(Recurso recursoRequerido) {
        gasVespeno.gastar(recursoRequerido);
    }

    public void consumirMinerales(Recurso recursoRequerido) {
        mineral.gastar(recursoRequerido);
    }

    public void devolverGasVespeno(Recurso recursoUtilizado) {
        gasVespeno.agregarUnidades(recursoUtilizado);
    }

    public void devolverMinerales(Recurso recursoUtilizado) {
        mineral.agregarUnidades(recursoUtilizado);
    }


    /*public int contarLarvas() {
        int larvasTotales = 0;
        for (Edificio edificio : edificios) {
            larvasTotales += edificio.contarLarvas();
        }
        return larvasTotales;
    }*/

    /*public void consumirLarva() {
        for (Edificio edificio : edificios) {
            if (edificio.contarLarvas() > 0) {
                edificio.consumirLarva();
            }
        }
    }*/

    /*public Edificio devolverEdificioConLarvas() {
        Edificio edificioConLarvas = null;
        for (Edificio edificio : edificios) {
            if (edificio.contarLarvas() > 0) {
                edificioConLarvas = edificio;
            }
        }
        return edificioConLarvas;
    }*/

  /*  public boolean faltanEdificios(List<Edificio> edificiosAComprobar){
        boolean faltanEdificios = false;
        for (int i = 0; i < edificiosAComprobar.size(); i++) {
            if(edificios.isEmpty()) {
                return true;
            } else {
                faltanEdificios = true;
                for (int j = 0; j < edificios.size(); j++) {
                    if (edificiosAComprobar.get(i).compararCon(edificios.get(j))) {
                        faltanEdificios = false;
                    }
                }
                if (faltanEdificios) {
                    return true;
                }
            }
        }
        return faltanEdificios;
    }*/

    public void actualizar() {
        for(int i = 0;i<this.edificios.size();i++) {
            edificios.get(i).actualizar(this);
        }
        for(int i = 0;i<this.unidades.size();i++){
            unidades.get(i).actualizar(this);
        }
    }

}
