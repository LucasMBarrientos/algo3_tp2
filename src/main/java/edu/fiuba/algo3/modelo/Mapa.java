package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.protoss.pilon.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.excepciones.CoordenadaFueraDelMapa;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.geometria.SuperficieRectangular;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {

    private List<Casilla> casillas = new ArrayList<Casilla>();
    List<Coordenada> ubicacionesInicialesDeLosJugadores = new ArrayList<Coordenada>();
    SuperficieRectangular superficie;

    public Mapa(Coordenada dimension) {
        this.superficie = new SuperficieRectangular(new Coordenada(0, 0), dimension);
        for (int x = 0; x < superficie.calcularLongitudX(); x++) {
            for (int y = 0; y < superficie.calcularLongitudY(); y++) {
                this.casillas.add(new Casilla(new Coordenada(x,y)));
            }
        }
        ubicacionesInicialesDeLosJugadores.add(new Coordenada(1, 1));
        ubicacionesInicialesDeLosJugadores.add(new Coordenada(superficie.calcularLongitudX() - 2, superficie.calcularLongitudY() - 2));
        generarAreasIniciales();
        generarTerrenoInicial();
        actualizarTerrenoEnergizado();
    }

    private boolean validarCoordenada(Coordenada coordenada) {
        return superficie.contieneCoordenada(coordenada);
    }

    public Casilla buscarCasilla(Coordenada coordenada) throws RuntimeException {
        int indiceDeLaCasilla = -1;
        if (validarCoordenada(coordenada)) {
            for (int i = 0; i < this.casillas.size(); i++) {
                if (this.casillas.get(i).compararCoordenadas(coordenada)) {
                    indiceDeLaCasilla = i;
                }
            }            
        }
        if (indiceDeLaCasilla == -1) {
            throw new CoordenadaFueraDelMapa();
        }
        return casillas.get(indiceDeLaCasilla);
    }

    public Casilla hallarVolcanInicialDelJugador(int idJugador) {
        Coordenada coordenadaDelVolcan;
        if (idJugador == 0) {
            coordenadaDelVolcan = ubicacionesInicialesDeLosJugadores.get(idJugador).devolverCoordenadaRelativa(2,2);
        } else {
            coordenadaDelVolcan = ubicacionesInicialesDeLosJugadores.get(idJugador).devolverCoordenadaRelativa(-2, -2);
        }
        return buscarCasilla(coordenadaDelVolcan);
    }

    public List<Casilla> hallarMineralesInicialesDelJugador(int idJugador) {
        return buscarCasillasAdyacentes(hallarVolcanInicialDelJugador(idJugador));
    }

    public Casilla hallarCasillaConEdificioInicialDelJugador(int idDelJguador) {
        return buscarCasilla(ubicacionesInicialesDeLosJugadores.get(idDelJguador));
    }

    public List<Casilla> buscarCasillasAdyacentes(Casilla casilla) {
        List<Coordenada> coordenadasAdyacentes = casilla.hallarCoordenadasAdyacentes();
        List<Casilla> casillasAdyacentes = new ArrayList<>();
        for (int i = 0; i < coordenadasAdyacentes.size(); i++) {
            if (validarCoordenada(coordenadasAdyacentes.get(i))) {
                // Coordenada esta dentro del mapa
                casillasAdyacentes.add(buscarCasilla(coordenadasAdyacentes.get(i)));
            }
        }
        return casillasAdyacentes;
    }

    private void generarAreasIniciales(){
        for(Casilla casilla: casillas){
            casilla.establecerArea(new AreaTerrestre());
        }
        buscarCasilla(new Coordenada(10,10)).establecerArea(new AreaEspacial()); //TODO cambiar esto por una generacion aleatoria (o controlada)
    }

    public List<Casilla> buscarCasillasAdyacentes(Coordenada coordenada) {
        Casilla casilla = this.buscarCasilla(coordenada);
        return buscarCasillasAdyacentes(casilla);
    }

    public Casilla hallarCasillaADistanciaRelativa(Casilla casilla, int distanciaX, int distanciaY) {
        Coordenada coordenadaDeLaCasillaRelativa = casilla.devolverCoordendas().devolverCoordenadaRelativa(distanciaX, distanciaY);
        return this.buscarCasilla(coordenadaDeLaCasillaRelativa);
    }

    private List<Casilla> buscarCasillasAdyacentes(Casilla casilla, int radio) {
        List<Casilla> casillasAdyacentesTotales = this.buscarCasillasAdyacentes(casilla);
        List<Casilla> nuevasCasillasAdyacentes = new ArrayList<Casilla>();
        for (int i = 0; i < radio - 1; i++) {
            for (Casilla casillaAdyacente : casillasAdyacentesTotales) {
                nuevasCasillasAdyacentes.addAll(this.buscarCasillasAdyacentes(casillaAdyacente));
            }
            casillasAdyacentesTotales.addAll(nuevasCasillasAdyacentes);
        }
        return casillasAdyacentesTotales;
    }

    private List<Casilla> buscarCasillasAdyacentes(Coordenada coordenada, int radio) {
        return buscarCasillasAdyacentes(buscarCasilla(coordenada), radio);
    }
    private Casilla buscarCasillaAlAzar() {
        Coordenada coordeandaAlAzar = superficie.devolverCoordenadaAlAzar();
        return this.buscarCasilla(coordeandaAlAzar);
    }

    public void actualizar(int turnoActual) {
       actualizarTerrenoEnergizado();
        if (turnoActual % 2 == 0) {
            // Se expande el moho
        }
        for (Casilla casilla : casillas) {
            casilla.actualizar();
        }
    }

    private List<Coordenada> hallarCoordenadasParaBases() {
        int cantidadDeJugadores = ubicacionesInicialesDeLosJugadores.size();
        int cantidadDeBases = ThreadLocalRandom.current().nextInt(cantidadDeJugadores + 10, cantidadDeJugadores + 15);
        List<Coordenada> coordenadasCentralesDeBases = new ArrayList<Coordenada>();
        // Base inicial para el jugador Zerg
        coordenadasCentralesDeBases.add(ubicacionesInicialesDeLosJugadores.get(0).devolverCoordenadaRelativa(2,2));
        // Base inicial para el jugador Protoss
        coordenadasCentralesDeBases.add(ubicacionesInicialesDeLosJugadores.get(1).devolverCoordenadaRelativa(-2,-2));
        for (int i=0; i < cantidadDeBases - cantidadDeJugadores; i++) {
            coordenadasCentralesDeBases.add(this.superficie.devolverCoordenadaAlAzarEvitando(ubicacionesInicialesDeLosJugadores));
        }
        return coordenadasCentralesDeBases;
    }

    private void generarTerrenoInicial() {
        List<Coordenada> coordenadasDeVolcanes = hallarCoordenadasParaBases();
        List<Casilla> casillasConMinerales;
        for (Coordenada coordenadaDeVolcan : coordenadasDeVolcanes) {
            buscarCasilla(coordenadaDeVolcan).generarVolcan();
            casillasConMinerales = buscarCasillasAdyacentes(coordenadaDeVolcan);
            for (Casilla casillaConMinerales : casillasConMinerales) {
                casillaConMinerales.generarMina();
            }
        }
    }

    public Pilon establecerInicioProtoss(int idDelJguador) {
        // Generar el terreno inicial del pilon de los protoss
        Coordenada ubicacionInicialDeJugador = ubicacionesInicialesDeLosJugadores.get(idDelJguador);
        this.buscarCasilla(ubicacionInicialDeJugador).energizarTerreno();
        Pilon pilonInicial = new Pilon().terminarConstruccion();
        this.buscarCasilla(ubicacionInicialDeJugador).establecerEdificio(pilonInicial);
        return pilonInicial;
    }

    public Criadero establecerInicioZerg(int idDelJguador) {
        // Generar el terreno inicial del criadero de los zerg
        Coordenada ubicacionInicialDeJugador = ubicacionesInicialesDeLosJugadores.get(idDelJguador);
        Criadero criaderoInicial = new Criadero().terminarConstruccion();
        this.buscarCasilla(ubicacionInicialDeJugador).establecerEdificio(criaderoInicial);
        this.buscarCasilla(ubicacionInicialDeJugador).cubrirDeMoho();
        this.generarMohoAlrededorDeCriadero(ubicacionInicialDeJugador);     
        return criaderoInicial; 
    }

    private void generarMohoAlrededorDeCriadero(Coordenada coordenadaDeCriadero) {
        List<Casilla> casillasConMoho = this.buscarCasillasAdyacentes(coordenadaDeCriadero,5);
        for (Casilla casillaConMoho : casillasConMoho) {
            casillaConMoho.cubrirDeMoho();
        }
    }

    private void actualizarTerrenoEnergizado() {
        List<Casilla> casillasConPilones = generarTerrenoEnergizadoEnLosPilones();
        List<Casilla> casillasConEnergia = new ArrayList<Casilla>();
        for (Casilla casillaConUnPilon : casillasConPilones) {
            casillasConEnergia = buscarCasillasAdyacentes(casillaConUnPilon,2);
            for (Casilla casillaConEnergia : casillasConEnergia) {
                casillaConEnergia.energizarTerreno();
            }
        }
    }

    public List<Casilla> generarTerrenoEnergizadoEnLosPilones() {
        List<Casilla> casillasConPilones = new ArrayList<Casilla>();
        for (Casilla casilla : casillas) {
            if (casilla.generaTerrenoEnergizado()) {
                casilla.energizarTerreno();
                casillasConPilones.add(casilla);
            } else {
                casilla.vaciarTerreno();
            }
        }
        return casillasConPilones;
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
        for (int y=0; y < dimensionY; y++) {
            lineaDelMapa = "";
            for (int x=0; x < dimensionX ; x++) {
                EstadoTerreno terreno = this.buscarCasilla(new Coordenada(x, y)).devolverTerreno().DEBUGDEVOLVERESTADO();
                if (terreno instanceof TerrenoMoho) {
                    lineaDelMapa += "#";
                } else if (terreno instanceof TerrenoVacio) {
                    lineaDelMapa += " ";
                } else if (terreno instanceof TerrenoEnergizado) {
                    lineaDelMapa += "+";
                } else if (terreno instanceof TerrenoVolcan) {
                    lineaDelMapa += "V";
                } else if (terreno instanceof TerrenoMineral) {
                    lineaDelMapa += "M";
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
                Unidad unidad = this.buscarCasilla(new Coordenada(x, y)).devolverUnidad();
                if (unidad instanceof Zangano) {
                    lineaDelMapa += "Z";
                } else if (unidad == null) {
                    lineaDelMapa += " ";
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
