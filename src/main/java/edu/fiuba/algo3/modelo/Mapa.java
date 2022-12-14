package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.excepciones.CoordenadaFueraDelMapa;
import edu.fiuba.algo3.modelo.excepciones.NoHayTerrenoDisponibleParaGenerarUnidad;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaTalUnidad;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.SuperficieRectangular;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Suministro;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {

    private static Mapa instancia = null;
    private List<Terreno> terrenos = new ArrayList<Terreno>();
    private List<Coordenada> ubicacionesInicialesDeLosJugadores = new ArrayList<Coordenada>();
    private SuperficieRectangular superficie;

    public static Mapa devolverInstancia() {
        if(instancia == null){
            instancia = new Mapa();
        }
        return instancia;
    }

    private void establecerUbicacionesInicialesDeLosJugadores() {
        ubicacionesInicialesDeLosJugadores = new ArrayList<Coordenada>();
        ubicacionesInicialesDeLosJugadores.add(new Coordenada(4, 4));
        ubicacionesInicialesDeLosJugadores.add(new Coordenada(superficie.calcularLongitudX() - 5, superficie.calcularLongitudY() - 5));
    }

    public void establecerDimension(Coordenada dimension) {
        this.superficie = new SuperficieRectangular(new Coordenada(0, 0), dimension);
        for (int y = 0; y < superficie.calcularLongitudY(); y++) {
            for (int x = 0; x < superficie.calcularLongitudX(); x++) {
                this.terrenos.add(new TerrenoBase(new Coordenada(x,y)));
            }
        }
        establecerUbicacionesInicialesDeLosJugadores();
        generarTerrenoInicial();
    }

    private boolean validarCoordenada(Coordenada coordenada) {
        return superficie.contieneCoordenada(coordenada);
    }

    public Terreno buscarTerreno(Coordenada coordenada) {
        return terrenos.get(buscarIdDelTerreno(coordenada));
    }

    private int buscarIdDelTerreno(Coordenada coordenada) throws CoordenadaFueraDelMapa {
        int indiceHallado = -1;
        for (int i = 0; i < this.terrenos.size(); i++) {
            if (this.terrenos.get(i).compararCoordenadas(coordenada)) {
                indiceHallado = i;
            }
        }
        if (indiceHallado == -1) {
            throw new CoordenadaFueraDelMapa();
        }
        return indiceHallado;
    }

    public List<Terreno> buscarTerrenosAdyacentes(Coordenada coordenada) {
        List<Coordenada> coordenadasAdyacentes = this.superficie.devolverCoordenadasAdyacentes(coordenada);
        List<Terreno> terrenosAdyacentes = new ArrayList<Terreno>();
        for (Coordenada coordenadaAdyacente : coordenadasAdyacentes) {
            terrenosAdyacentes.add(buscarTerreno(coordenadaAdyacente));
        }
        return terrenosAdyacentes;
    }

    public List<Terreno> buscarTerrenosAdyacentes(Coordenada coordenada, int rango) {
        List<Coordenada> coordenadasAdyacentes = this.superficie.devolverCoordenadasAdyacentes(coordenada, rango);
        List<Terreno> terrenosAdyacentes = new ArrayList<Terreno>();
        for (Coordenada coordenadaAdyacente : coordenadasAdyacentes) {
            terrenosAdyacentes.add(buscarTerreno(coordenadaAdyacente));
        }
        return terrenosAdyacentes;
    }

    public void establecerEdificio(Coordenada coordenada, Edificio edificio) throws TerrenoNoAptoParaConstruirTalEdificio {
        Terreno terreno = this.buscarTerreno(coordenada);
        edificio.ocupar(terreno);
    }

    public void establecerUnidadEnCoordenadaAdyacente(Coordenada coordenadaDelEdificio, Unidad unidad) throws NoHayTerrenoDisponibleParaGenerarUnidad {
        List<Terreno> terrenosPosibles = buscarTerrenosAdyacentes(coordenadaDelEdificio, 2);
        for (Terreno terreno : terrenosPosibles) {
            if (unidad.ocupar(terreno)) {
                return;
            }
        }
        throw new NoHayTerrenoDisponibleParaGenerarUnidad();
    }

    public void establecerUnidad(Coordenada coordenada, Unidad unidad) {
        if (!unidad.ocupar(buscarTerreno(coordenada))) {
            throw new TerrenoNoAptoParaTalUnidad();
        }
    }

    public void eliminarEdificio(Coordenada coordenada) {
        buscarTerreno(coordenada).eliminarEdificio();
    }

    public void eliminarUnidad(Coordenada coordenada) {
        buscarTerreno(coordenada).eliminarUnidad();
    }

    public Terreno hallarTerrenoADistanciaRelativa(Coordenada coordenada, int distanciaX, int distanciaY) {
        Coordenada coordenadaBuscada = coordenada.devolverCoordenadaRelativa(distanciaX, distanciaY);
        return this.buscarTerreno(coordenadaBuscada);
    }


    private List<Coordenada> hallarCoordenadasParaBases() {
        int distanciaEntreLasBases = Math.max(1, superficie.calcularLongitudPromedio() / 12);
        int cantidadDeJugadores = ubicacionesInicialesDeLosJugadores.size();
        List<Coordenada> coordenadasCentralesDeBases = new ArrayList<Coordenada>();
        for (int i = 0; i < cantidadDeJugadores; i++) {
            coordenadasCentralesDeBases.add(ubicacionesInicialesDeLosJugadores.get(i));
        }
        SuperficieRectangular superficicieConBasesAlAzar = this.superficie.redimensionar(-4);
        int cantidadDeBases = ThreadLocalRandom.current().nextInt(cantidadDeJugadores + 10, cantidadDeJugadores + 15);
        for (int i = cantidadDeJugadores; i < cantidadDeBases; i++) {
            coordenadasCentralesDeBases.add(superficicieConBasesAlAzar.devolverCoordenadaAlAzarEvitando(coordenadasCentralesDeBases, distanciaEntreLasBases));
        }
        return coordenadasCentralesDeBases;
    }

    public Zangano establecerZanganoInicial(int idJugador) {
        Coordenada ubicacionDelVolcanInicial = ubicacionesInicialesDeLosJugadores.get(idJugador);
        Coordenada ubicacionDelZangano = superficie.transformarCoordenadaRelativamenteAlCentro(ubicacionDelVolcanInicial,3,3);
        Zangano zanganoGenerado = new Zangano(new GasVespeno(0), new Mineral(0),new Suministro(0));
        zanganoGenerado.reducirTiempoConstruccion(1);
        zanganoGenerado.terminarConstruccion();
        zanganoGenerado.establecerCoordenada(ubicacionDelZangano);
        zanganoGenerado.ocupar(buscarTerreno(ubicacionDelZangano));
        return zanganoGenerado;
    }

    private void generarTerrenoInicial() {
        // Generamiento de terreno espacial en los bordes del mapa
        List<Coordenada> coordenadasBorde = superficie.devolverCoordenadasAlBorde();
        for (Coordenada coordenadaBorde : coordenadasBorde) {
            terrenos.set(buscarIdDelTerreno(coordenadaBorde), new TerrenoAereo(coordenadaBorde));
        }
        // Generamiento de volcanes y minerales en el mapa
        List<Coordenada> coordenadasDeVolcanes = hallarCoordenadasParaBases();
        List<Coordenada> coordenadasConMinerales;
        for (Coordenada coordenadaDeVolcan : coordenadasDeVolcanes) {
            terrenos.set(buscarIdDelTerreno(coordenadaDeVolcan), new TerrenoVolcan(coordenadaDeVolcan));
            coordenadasConMinerales = coordenadaDeVolcan.hallarCoordenadasAdyacentes();
            for (Coordenada coordenadaConMinerales : coordenadasConMinerales) {
                terrenos.set(buscarIdDelTerreno(coordenadaConMinerales), new TerrenoMineral(coordenadaConMinerales));
            }
        }
    }

    public List<ObjectNode> parseTerrenos(){
      List<ObjectNode>  mapaEnString = new ArrayList<>();
        int longitudX = this.superficie.calcularLongitudX();
        int contadorDeLinea = 0;
        for(Terreno terreno : terrenos){
            if(contadorDeLinea >= longitudX){
                ObjectNode nodo = Json.createObjectNode();
                nodo.put("nombre", "cambioDeLinea");
                
                mapaEnString.add(nodo);

                contadorDeLinea = 0;
            }
            mapaEnString.add(terreno.toData());
            contadorDeLinea ++;
        }
        return mapaEnString;
    }

    public List<ObjectNode> parseOcupantes(){
        List<ObjectNode> mapaEnString = new ArrayList<>();
        int longitudX = this.superficie.calcularLongitudX();
        int contadorDeLinea = 0;
        for(Terreno terreno : terrenos){
             if(contadorDeLinea >= longitudX){
                ObjectNode nodo2 = Json.createObjectNode();
                ObjectNode nodo = Json.createObjectNode();
                nodo2.put("nombre","cambioDeLinea");
                nodo.put("Ocupante", nodo2);
                mapaEnString.add(nodo);
                contadorDeLinea = 0;
            }

            mapaEnString.add(terreno.toDataOcupantes());

            contadorDeLinea ++;
        }
        return mapaEnString;
    }

    public List<ObjectNode> toJsonTerrenos() throws JsonProcessingException {
        return parseTerrenos();
    }

    public List<ObjectNode> toJsonOcupantes() throws JsonProcessingException {
        return parseOcupantes();
    }

}
