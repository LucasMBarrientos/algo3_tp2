package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.excepciones.NoHayTerrenoDisponibleParaGenerarUnidad;
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.CoordenadaFueraDelMapa;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.SuperficieRectangular;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {

    private List<Terreno> terrenos = new ArrayList<Terreno>();

    List<Coordenada> ubicacionesInicialesDeLosJugadores = new ArrayList<Coordenada>();
    SuperficieRectangular superficie;

    public Mapa(Coordenada dimension) {
        this.superficie = new SuperficieRectangular(new Coordenada(0, 0), dimension);
        for (int x = 0; x < superficie.calcularLongitudX(); x++) {

            for (int y = 0; y < superficie.calcularLongitudY(); y++) {
                this.terrenos.add(new TerrenoBase(new Coordenada(x,y)));
            }
        }
        ubicacionesInicialesDeLosJugadores.add(new Coordenada(4, 4));
        ubicacionesInicialesDeLosJugadores.add(new Coordenada(superficie.calcularLongitudX() - 5, superficie.calcularLongitudY() - 5));
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

    public void establecerUnidad(Coordenada coordenada, Unidad unidad){
        unidad.ocupar(buscarTerreno(coordenada));
    }

    public void eliminarUnidadDelMapa(Coordenada coordenada){
        buscarTerreno(coordenada).establecerUnidad(null);
    }

    public void establecerUnidadDelMapa(Coordenada coordenada, Unidad unidad){ //esto es para meter un zangano
        buscarTerreno(coordenada).establecerUnidad(unidad);
    }

    public Terreno hallarTerrenoADistanciaRelativa(Coordenada coordenada, int distanciaX, int distanciaY) {
        Coordenada coordenadaBuscada = coordenada.devolverCoordenadaRelativa(distanciaX, distanciaY);
        return this.buscarTerreno(coordenadaBuscada);
    }

    public void actualizar(int turnoActual) {
        List<Coordenada> coordenadasQueTendranMoho = new ArrayList<Coordenada>();
        List<Coordenada> coordenadasConCriaderos = new ArrayList<Coordenada>();
        List<Coordenada> coordenadasConPilones = new ArrayList<Coordenada>();
        for (Terreno terreno : terrenos) {
            terreno.actualizarListaDeCoordenadas(coordenadasQueTendranMoho, coordenadasConCriaderos, coordenadasConPilones);
        }
        if (turnoActual % 2 == 0) {
            cubrirCoordenadasDeMoho(coordenadasQueTendranMoho);
        }
        actualizarTerrenosEnergizados(coordenadasConPilones);
        generarMohoAlrededorDeCriaderos(coordenadasConCriaderos);
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
        Zangano zanganoGenerado = new Zangano();
        buscarTerreno(ubicacionDelZangano).ocuparPorUnidad(zanganoGenerado);
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

    private void generarMohoAlrededorDeCriadero(Coordenada coordenadaDelCriadero) {
        List<Coordenada> coordenadasConMoho = this.superficie.devolverCoordenadasAdyacentes(coordenadaDelCriadero,5);
        for (Coordenada coordenadaConMoho : coordenadasConMoho) {
            buscarTerreno(coordenadaConMoho).cubrirTerrenoDeMoho();
        }
    }

    private void generarMohoAlrededorDeCriaderos(List<Coordenada> coordenadasConCriaderos) {
        for (Coordenada coordenadaConCriadero : coordenadasConCriaderos) {
            generarMohoAlrededorDeCriadero(coordenadaConCriadero);
        }
    }

    private void generarTerrenoEnergizadoAlrededorDePilon(Coordenada coordenadaDelPilon) {
        List<Coordenada> coordenadasConTerrenoEnergizado = this.superficie.devolverCoordenadasAdyacentes(coordenadaDelPilon,3);
        for (Coordenada coordenadaConTerrenoEnergizado : coordenadasConTerrenoEnergizado) {
            buscarTerreno(coordenadaConTerrenoEnergizado).energizarTerreno();
        }
    }

    private void generarTerrenoEnergizadoAlrededorDePilones(List<Coordenada> coordenadasConPilones) {
        for (Coordenada coordenadaConPilon : coordenadasConPilones) {
            generarTerrenoEnergizadoAlrededorDePilon(coordenadaConPilon);
        }
    }

    public void cubrirCoordenadasDeMoho(List<Coordenada> coordenadasQueTendranMoho) {
        for (Coordenada coordenadaConMoho : coordenadasQueTendranMoho) {
            buscarTerreno(coordenadaConMoho).cubrirTerrenoDeMoho();
        }
    }

    public void actualizarTerrenosEnergizados(List<Coordenada> coordenadasConPilones) {
        for (Terreno terreno : terrenos) {
            terreno.desenergizarTerreno();
        }
        generarTerrenoEnergizadoAlrededorDePilones(coordenadasConPilones);
    }
    
    // Metodos DEBUG_ unicamente para probar el funcionamiento el programa

    public void DEBUG_MOSTRARMAPATERRENO() {
        String lineaDelMapa = "";
        int dimensionX = this.superficie.calcularLongitudX();
        int dimensionY = this.superficie.calcularLongitudY();
        for (int x=0; x < dimensionX ; x++) {
            lineaDelMapa += "█";
        }
        System.out.println("█" + lineaDelMapa + "█");
        EstadoTerreno estadoTerreno;
        for (int y=0; y < dimensionY; y++) {
            lineaDelMapa = "";
            for (int x=0; x < dimensionX ; x++) {
                Terreno terreno = this.buscarTerreno(new Coordenada(x, y));
                if (terreno instanceof TerrenoVolcan) {
                    lineaDelMapa += "V";
                } else if (terreno instanceof TerrenoMineral) {
                    lineaDelMapa += "M";
                } else if (terreno instanceof TerrenoAereo) {
                    lineaDelMapa += "A";
                } else {
                    estadoTerreno = ((TerrenoBase)terreno).DEBUG_DEVOLVERESTADO();
                    if (estadoTerreno instanceof TerrenoMoho) {
                        lineaDelMapa += "#";
                    } else if (estadoTerreno instanceof TerrenoVacio) {
                        lineaDelMapa += " ";
                    } else if (estadoTerreno instanceof TerrenoEnergizado) {
                        lineaDelMapa += "+";
                    }
                }
            }
            System.out.println("█" + lineaDelMapa + "█");
        }
        lineaDelMapa = "";
        for (int x=0; x < dimensionX ; x++) {
            lineaDelMapa += "█";
        }
        System.out.println("█" + lineaDelMapa + "█");
    }

    public void DEBUG_MOSTRARMAPAEDIFICIOS() {
        String lineaDelMapa = "";
        int dimensionX = this.superficie.calcularLongitudX();
        int dimensionY = this.superficie.calcularLongitudY();
        for (int x=0; x < dimensionX ; x++) {
            lineaDelMapa += "█";
        }
        System.out.println("█" + lineaDelMapa + "█");
        for (int y=0; y < dimensionY; y++) {
            lineaDelMapa = "";
            for (int x=0; x < dimensionX ; x++) {
                Edificio edificio = this.buscarTerreno(new Coordenada(x, y)).DEBUG_DEVOLVEREDIFICIO();
                if (edificio instanceof Criadero) { 
                    lineaDelMapa += "#";
                } else if (edificio instanceof ReservaDeReproduccion) {
                    lineaDelMapa += "2";
                } else if (edificio instanceof Extractor) {
                    lineaDelMapa += "3";
                } else if (edificio instanceof Guarida) {
                    lineaDelMapa += "4";
                } else if (edificio instanceof Espiral) {
                    lineaDelMapa += "5";
                } else if (edificio instanceof NexoMineral) {
                    lineaDelMapa += "6";
                } else if (edificio instanceof Pilon) {
                    lineaDelMapa += "I";
                } else if (edificio instanceof Asimilador) {
                    lineaDelMapa += "8";
                } else if (edificio instanceof Acceso) {
                    lineaDelMapa += "9";
                } else if (edificio instanceof PuertoEstelar) {
                    lineaDelMapa += "0";
                }
            }
            System.out.println("█" + lineaDelMapa + "█");
        }
        lineaDelMapa = "";
        for (int x=0; x < dimensionX ; x++) {
            lineaDelMapa += "█";
        }
        System.out.println("█" + lineaDelMapa + "█");
    }

    public Coordenada iniciarEsquinaSuperior() {
        return new Coordenada(superficie.calcularLongitudX() - 2, superficie.calcularLongitudY() - 2);
    }


    public void DEBUG_MOSTRARMAPAUNIDADES() {
        String lineaDelMapa = "";
        int dimensionX = this.superficie.calcularLongitudX();
        int dimensionY = this.superficie.calcularLongitudY();
        for (int x=0; x < dimensionX ; x++) {
            lineaDelMapa += "█";
        }
        System.out.println("█" + lineaDelMapa + "█");
        for (int y=0; y < dimensionY; y++) {
            lineaDelMapa = "";
            for (int x=0; x < dimensionX ; x++) {
                Unidad unidad = this.buscarTerreno(new Coordenada(x, y)).DEBUG_DEVOLERUNIDAD();
                if (unidad instanceof Zangano) {
                    lineaDelMapa += "Z";
                } else if (unidad == null) {
                    lineaDelMapa += " ";
                } else {
                    lineaDelMapa += "X";
                }
            }
            System.out.println("█" + lineaDelMapa + "█");
        }
        lineaDelMapa = "";
        for (int x=0; x < dimensionX ; x++) {
            lineaDelMapa += "█";
        }
        System.out.println("█" + lineaDelMapa + "█");
    }
    
}
