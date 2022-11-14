package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class Mapa {

    private List<Casilla> casillas = new ArrayList<Casilla>();

    List<Coordenada> ubicacionesInicialesDeLosJugadores = new ArrayList<Coordenada>();

    SuperficieRectangular superficie;
    
    public Mapa(Coordenada dimension) {
        this.superficie = new SuperficieRectangular(new Coordenada(0, 0), dimension);
        for (int x = 0; x < dimension.devolverX(); x++) {
            for (int y = 0; y < dimension.devolverY(); y++) {
                this.casillas.add(new Casilla(new Coordenada(x,y)));
            }
        }
        ubicacionesInicialesDeLosJugadores.add(new Coordenada(1, 1));
        ubicacionesInicialesDeLosJugadores.add(new Coordenada(dimension.devolverX() - 2, dimension.devolverY() - 2));
        
        generarTerrenoInicial();
        actualizarTerrenoEnergizado();
    }

    private boolean validarCoordenada(Coordenada coordenada) {
        return superficie.contieneCoordenada(coordenada);
    }

    public Casilla buscarCasilla(Coordenada coordenada) {
        int indiceDeLaCasilla = -1;
        if (validarCoordenada(coordenada)) {
            for (int i = 0; i < this.casillas.size(); i++) {
                if (this.casillas.get(i).compararCoordenadas(coordenada)) {
                    indiceDeLaCasilla = i;
                }
            }
        }
        if (indiceDeLaCasilla == -1) {
            // TODO : Lanzar Excepcion: Casilla fuera de las dimensiones del mapa
            indiceDeLaCasilla = 0;
        }
        return this.casillas.get(indiceDeLaCasilla);
    }

    private List<Casilla> buscarCasillasAdyacentes(Casilla casilla) {
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



    public List<Casilla> buscarCasillasAdyacentes(Coordenada coordenada) {
        Casilla casilla = this.buscarCasilla(coordenada);
        return buscarCasillasAdyacentes(casilla);
    }

    private Casilla buscarCasillaAlAzar() {
        Coordenada coordeandaAlAzar = superficie.devolverCoordenadaAlAzar();
        return this.buscarCasilla(coordeandaAlAzar);
    }

    /*
    private void sobreescribirCasillas(List<Casilla> casillas) {
        for (Casilla casillaNueva : casillas) {
            for (Casilla casillaDelMapa : this.casillas) {
                if (casillaNueva.compararCoordenadas(casillaDelMapa)) {
                    // Coordenada esta dentro del mapa
                    casillaDelMapa = casillaNueva;
                }            
            }
        }
    }
    */

    public void actualizar(int turno) {
        actualizarTerrenoEnergizado();
        if(turno % 4 == 0) {
            // Se expande el moho una vez cada 2 rondas (4 turnos)
           expandirMoho();
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
        List<Coordenada> coordenadasDeMinerales;
        for (Coordenada coordenadaDeVolcan : coordenadasDeVolcanes) {
            buscarCasilla(coordenadaDeVolcan).establecerTerreno(new TerrenoVolcan());
            coordenadasDeMinerales = coordenadaDeVolcan.hallarCoordenadasAdyacentes();
            for (Coordenada coordenadaDeMinerales : coordenadasDeMinerales) {
                buscarCasilla(coordenadaDeMinerales).establecerTerreno(new TerrenoMineral());
            }
        }
        // Generar el terreno inicial del criadero de los zerg (En la esquina superior izquierda del mapa)
        Coordenada ubicacionInicialDeJugador = ubicacionesInicialesDeLosJugadores.get(0);
        this.buscarCasilla(ubicacionInicialDeJugador).establecerEdificio(new Criadero(ubicacionInicialDeJugador));
        this.buscarCasilla(ubicacionInicialDeJugador).establecerTerreno(new TerrenoMoho());
        this.generarMohoAlrededorDeCriadero(ubicacionInicialDeJugador);
        // Generar el terreno inicial del pilon de los protoss (En la esquina inferior derecha del mapa)
        ubicacionInicialDeJugador = ubicacionesInicialesDeLosJugadores.get(1);
        this.buscarCasilla(ubicacionInicialDeJugador).establecerTerreno(new TerrenoEnergizado());
        this.buscarCasilla(ubicacionInicialDeJugador).establecerEdificio(new Pilon(ubicacionInicialDeJugador));
    }

    /*
    
    private List<SuperficieRectangular> calcularBases() {
        int cantidadDeJugadores = ubicacionesInicialesDeLosJugadores.size();
        int cantidadDeBases = ThreadLocalRandom.current().nextInt(cantidadDeJugadores + 10, cantidadDeJugadores + 15);
        List<Coordenada> coordenadasCentralesDeBases = new ArrayList<Coordenada>();
        for (int i=0; i < cantidadDeJugadores; i++) {
            // El volcan inicial de cada jugador empieza a la derecha de su ubicacion inicial
            coordenadasCentralesDeBases.add(ubicacionesInicialesDeLosJugadores.get(i).devolverCoordenadaRelativa(1,0));
        }
        for (int i=0; i < cantidadDeBases - cantidadDeJugadores; i++) {
            coordenadasCentralesDeBases.add(this.superficie.devolverCoordenadaAlAzarEvitando(coordenadasCentralesDeBases));
        }

        int tamanioDeLasBases = this.superficie.devolverLongitudPromedio() / 10;
        List<SuperficieRectangular> bases = new ArrayList<SuperficieRectangular>();
        Coordenada coordenadaInicial, coordenadaFinal;
        int x,y;
        for (Coordenada coordenadaCentral : coordenadasCentralesDeBases) {
            x = coordenadaCentral.devolverX() - tamanioDeLasBases / 2;
            y = coordenadaCentral.devolverY() - tamanioDeLasBases / 2;
            coordenadaInicial = new Coordenada(x,y);
            while (!this.superficie.contieneCoordenada(coordenadaInicial)) {
                x++;
                y++;
                coordenadaInicial = new Coordenada(x,y);
            }
            x = coordenadaCentral.devolverX() + tamanioDeLasBases / 2;
            y = coordenadaCentral.devolverY() + tamanioDeLasBases / 2;
            coordenadaFinal = new Coordenada(x,y);
            while (!this.superficie.contieneCoordenada(coordenadaFinal)) {
                x--;
                y--;
                coordenadaFinal = new Coordenada(x,y);
            }
            bases.add(new SuperficieRectangular(coordenadaInicial, coordenadaFinal));
        }
        return bases;
    }

    private void generarTerrenoInicial() {
        List<SuperficieRectangular> bases = calcularBases();
        int cantidadDeMineralesGenerados, cantidadMaximaDeMineralesGenerados;
        Coordenada coordenadaDeTerreno;
        for (SuperficieRectangular superficieDeBase : bases) {
            // Generacion del volcan de esta base
            coordenadaDeTerreno = superficieDeBase.devolverCoordenadaCentral();
            this.buscarCasilla(coordenadaDeTerreno).establecerTerreno(new TerrenoVolcan());
            // Generacion de los minerales alrededor de dicho volcan
            cantidadMaximaDeMineralesGenerados = superficieDeBase.calcularSuperficie() / 4; // Una base tiene hasta un 25% de cristales
            if (cantidadMaximaDeMineralesGenerados < 2) {
                cantidadMaximaDeMineralesGenerados = 2;
            }
            cantidadDeMineralesGenerados = ThreadLocalRandom.current().nextInt(1, cantidadMaximaDeMineralesGenerados);  
            for (int i=0; i < cantidadDeMineralesGenerados; i++) {
                coordenadaDeTerreno = superficieDeBase.devolverCoordenadaAlAzarEvitando(ubicacionesInicialesDeLosJugadores);
                this.buscarCasilla(coordenadaDeTerreno).establecerTerreno(new TerrenoMineral());                
            }
        }
        // Generar el terreno inicial del criadero de los zerg (En la esquina superior izquierda del mapa)
        Coordenada ubicacionInicialDeJugador = ubicacionesInicialesDeLosJugadores.get(0);
        this.buscarCasilla(ubicacionInicialDeJugador).establecerEdificio(new Criadero(ubicacionInicialDeJugador));
        this.buscarCasilla(ubicacionInicialDeJugador).establecerTerreno(new TerrenoMoho());
        this.generarMohoAlrededorDeCriadero(ubicacionInicialDeJugador);
        // Generar el terreno inicial del pilon de los protoss (En la esquina inferior derecha del mapa)
        ubicacionInicialDeJugador = ubicacionesInicialesDeLosJugadores.get(1);
        this.buscarCasilla(ubicacionInicialDeJugador).establecerTerreno(new TerrenoEnergizado());
        this.buscarCasilla(ubicacionInicialDeJugador).establecerEdificio(new Pilon(ubicacionInicialDeJugador));
    }

    */





    public void DEBUGMOSTRARMAPA() {
        String lineaDelMapa = "";
        int dimensionX = this.superficie.devolverXMax();
        int dimensionY = this.superficie.devolverYMax();
        for (int x=0; x < dimensionX ; x++) {
            lineaDelMapa += "█";
        }
        System.out.println("█" + lineaDelMapa + "█");
        for (int y=0; y < dimensionY; y++) {
            lineaDelMapa = "";
            for (int x=0; x < dimensionX ; x++) {
                Terreno terreno = this.buscarCasilla(new Coordenada(x, y)).devolverTerreno();
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

    private List<Casilla> buscarCasillasConMoho() {
        // Buscar casilllas que en este turno van a tener moho
        List<Coordenada> coordenadasConMoho = new ArrayList<Coordenada>();
        for (Casilla casilla : casillas) {
            casilla.actualizarListaDeCoordenadasConMoho(coordenadasConMoho);
        }
        // Recorre las casillas que en este turno van a tener moho
        List<Casilla> casillasConMoho = new ArrayList<Casilla>();
        for (Coordenada coordenadaConMoho : coordenadasConMoho) {
            if (validarCoordenadaOcupableConMoho(coordenadaConMoho)) {
                casillasConMoho.add(this.buscarCasilla(coordenadaConMoho));
            }
        }
        return casillasConMoho;
    }

    private boolean validarCoordenadaOcupableConMoho(Coordenada coordenadaConMoho) {
        Boolean casillaPertenceAlMapa = this.validarCoordenada(coordenadaConMoho);
        if (casillaPertenceAlMapa) {
            Casilla casilla = this.buscarCasilla(coordenadaConMoho);
            return (casilla.terrenoEsReemplazable() && !casilla.terrenoRepeleMoho());
        } else {
            return false;
        }
    }

    private void expandirMoho() {
        List<Casilla> casillasConMoho = buscarCasillasConMoho();
        for (Casilla casillaConMoho : casillasConMoho) {
            casillaConMoho.establecerTerreno(new TerrenoMoho());
        }
    }

    private void generarMohoAlrededorDeCriadero(Coordenada coordenadaDeCriadero) {
        List<Casilla> casillasConMoho = this.buscarCasillasAdyacentes(coordenadaDeCriadero);
        for (Casilla casillaConMoho : casillasConMoho) {
            casillaConMoho.establecerTerreno(new TerrenoMoho());
        }
    }

    private void actualizarTerrenoEnergizado() {
        List<Casilla> casillasConPilones = generarTerrenoEnergizadoEnLosPilones();
        List<Casilla> casillasConEnergia = new ArrayList<Casilla>();
        for (Casilla casillaConUnPilon : casillasConPilones) {
            casillasConEnergia = buscarCasillasAdyacentes(casillaConUnPilon,2);
            for (Casilla casillaConEnergia : casillasConEnergia) {
                casillaConEnergia.establecerTerreno(new TerrenoEnergizado());
            }
        }
    }

    public List<Casilla> generarTerrenoEnergizadoEnLosPilones() {
        List<Casilla> casillasConPilones = new ArrayList<Casilla>();
        for (Casilla casilla : casillas) {
            if (casilla.generaTerrenoEnergizado()) {
                casilla.establecerTerreno(new TerrenoEnergizado());
                casillasConPilones.add(casilla);
            } else {
                casilla.establecerTerreno(new TerrenoVacio());
            }
        }
        return casillasConPilones;
    }








    /*

    public void generarTerrenoEnergizadoEnLosPilones() {
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverTerreno() instanceof TerrenoEnergizado) {
                casillaCentral.establecerTerreno(new TerrenoVacio());
            }
            if (casillaCentral.devolverEdificio() instanceof Pilon) {
                casillaCentral.establecerTerreno(new TerrenoEnergizado());
            }
        }
        generarTerrenoEnergizado();
        generarTerrenoEnergizado();
        generarTerrenoEnergizado();
    }

    private void generarTerrenoEnergizado() {
        List<Casilla> casillasConEnergia = new ArrayList<Casilla>();
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverTerreno() instanceof TerrenoEnergizado) {
                casillasConEnergia.add(casillaCentral);
            }
        }
        for (Casilla casillaConEnergia : casillasConEnergia){
            expandirEnergia(casillaConEnergia);
        }

    }

    public void generarMoho() {
        List<Casilla> casillasConMoho = new ArrayList<Casilla>();
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverTerreno() instanceof TerrenoMoho) {
                casillasConMoho.add(casillaCentral);

            }
        }
        for(Casilla casillaConMoho : casillasConMoho){
            expandirMoho(casillaConMoho);
        }
    }

    public void generarMoho(int radio) {
        for (int i = 0; i < radio; i++) {
            List<Casilla> casillasConMoho = new ArrayList<Casilla>();
            for (Casilla casillaCentral : this.casillas) {
                if (casillaCentral.devolverTerreno() instanceof TerrenoMoho) {
                    casillasConMoho.add(casillaCentral);
                }
            }
            for (Casilla casillaConMoho : casillasConMoho) {
                expandirMoho(casillaConMoho);
            }
        }
    }

    public void expandirMoho(Casilla casillaInicial){
        int x = casillaInicial.devolverX();
        int y = casillaInicial.devolverY();

        if(validarCasillaDentroDeLimites(x-1,y)){
            if (buscarCasilla(x-1,y).devolverTerreno() instanceof TerrenoVacio){
                buscarCasilla(x-1,y).establecerTerreno(new TerrenoMoho());
            }
        }
        if(validarCasillaDentroDeLimites(x+1,y)){
            if (buscarCasilla(x+1,y).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x + 1, y).establecerTerreno(new TerrenoMoho());
            }
        }
        if(validarCasillaDentroDeLimites(x,y+1)){
            if (buscarCasilla(x,y+1).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x, y + 1).establecerTerreno(new TerrenoMoho());
            }
        }
        if(validarCasillaDentroDeLimites(x,y-1)){
            if (buscarCasilla(x,y-1).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x, y - 1).establecerTerreno(new TerrenoMoho());
            }
        }
    }

    public void generarEnergizadosIniciales() {
        List<Casilla> casillasEnergizadas = new ArrayList<Casilla>();
        for (Casilla casillaCentral : this.casillas) {
            if (casillaCentral.devolverTerreno() instanceof TerrenoEnergizado) {
                casillasEnergizadas.add(casillaCentral);

            }
        }
        for(Casilla casillaEnergia : casillasEnergizadas){
            expandirEnergia(casillaEnergia);
        }
    }

    public void expandirEnergia(Casilla casillaInicial){
        int x = casillaInicial.devolverX();
        int y = casillaInicial.devolverY();

        if(validarCasillaDentroDeLimites(x-1,y)){
            if (buscarCasilla(x-1,y).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x - 1, y).establecerTerreno(new TerrenoEnergizado());
            }
        }
        if(validarCasillaDentroDeLimites(x+1,y)){
            if (buscarCasilla(x+1,y).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x + 1, y).establecerTerreno(new TerrenoEnergizado());
            }
        }
        if(validarCasillaDentroDeLimites(x,y+1)){
            if (buscarCasilla(x,y+1).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x, y + 1).establecerTerreno(new TerrenoEnergizado());
            }
        }
        if(validarCasillaDentroDeLimites(x,y-1)){
            if (buscarCasilla(x,y-1).devolverTerreno() instanceof TerrenoVacio) {
                buscarCasilla(x, y - 1).establecerTerreno(new TerrenoEnergizado());
            }
        }
    }

    public Casilla hallarCasillaAdyacenteDesocupada(Casilla casillaCentral) {
        int x = casillaCentral.devolverX() - 1;
        int y = casillaCentral.devolverY() - 1;
        Casilla casillaPosible;
        for (int i = 0; i < 9; i++) {
            casillaPosible = new Casilla(x,y);
            for (Casilla casilla : casillas) {
                if (casillaPosible.compararUbicaciones(casilla)) {
                    // Encontre la casilla del mapa en la misma posicion que casillaPosible
                    if (!casilla.ocupada()) {
                        return casilla;
                    }
                }
            }
            x++;
            if (x == casillaCentral.devolverX() + 1) {
                x -= 2;
                y++;
            }
        }
        return null;
    }

    private Casilla hallarCasillaAdyacenteConTerrenoVacio(Casilla casillaCentral) {
        int x = casillaCentral.devolverX() - 1;
        int y = casillaCentral.devolverY() - 1;
        Casilla casillaPosible;
        for (int i = 0; i < 9; i++) {
            casillaPosible = new Casilla(x,y);
            for (Casilla casilla : casillas) {
                if (casillaPosible.compararUbicaciones(casilla)) {
                    // Encontre la casilla del mapa en la misma posicion que casillaPosible
                    if (casilla.devolverTerreno() instanceof TerrenoVacio) {
                        return casilla;
                    }
                }
            }
            x++;
            if (x == casillaCentral.devolverX() + 1) {
                x -= 2;
                y++;
            }
        }
        return null;
    }

    public boolean validarMovimiento(Unidad unidad, Casilla nuevaCasilla) {
        if (nuevaCasilla == null) {
            return false;
        }
        return (nuevaCasilla.devolverUnidad() == null && nuevaCasilla.devolverTerreno().validarTransitable(unidad));
    }

    public void actualizar(int ronda) {
        if(ronda % 2 == 0){
            generarMoho();
        }
        for (Casilla casilla : casillas) {
            casilla.actualizar();
            generarTerrenoEnergizadoEnLosPilones();
            if (casilla.devolverEdificio() instanceof EdificioProtoss) {
                if (casilla.devolverTerreno() instanceof TerrenoEnergizado || casilla.devolverEdificio() instanceof NexoMineral || casilla.devolverEdificio() instanceof Asimilador) {
                    // TODO: Implementar interface "NecesitaEnergia" para simplificar esto
                    ((EdificioProtoss) casilla.devolverEdificio()).establecerOperatividad(true);
                } else {
                    ((EdificioProtoss) casilla.devolverEdificio()).establecerOperatividad(false);
                }
            }
        }
    }

    public TieneRecursos buscarEdificiosZergConRecursos(){
        for(Casilla casilla : casillas) {
            // Recorre todas las casillas del mapa
            if(casilla.devolverEdificio() instanceof TieneRecursos && casilla.devolverEdificio() instanceof EdificioZerg) {
                // Se halla un edificio que extrae recursos
                if (((TieneRecursos) casilla.devolverEdificio()).tieneRecursos()) {
                    // El edificio ademas tiene recursos extraidos
                    return (TieneRecursos) casilla.devolverEdificio();
                }
            }
        }
        return null;
    }

    public TieneRecursos buscarEdificiosProtossConRecursos(){
        for(Casilla casilla : casillas) {
            // Recorre todas las casillas del mapa
            if(casilla.devolverEdificio() instanceof TieneRecursos && casilla.devolverEdificio() instanceof EdificioProtoss) {
                // Se halla un edificio que extrae recursos
                if (((TieneRecursos) casilla.devolverEdificio()).tieneRecursos()) {
                    // El edificio ademas tiene recursos extraidos
                    return (TieneRecursos) casilla.devolverEdificio();
                }
            }
        }
        return null;
    }

    public TieneRecursos buscarMineralesConZanganos(){
        for(Casilla casilla : casillas) {
            // Recorre todas las casillas del mapa
            if(casilla.devolverTerreno() instanceof TerrenoMineral && casilla.devolverUnidad() instanceof Zangano) {
                // Se halla un mineral con un zangano arriba
                if (((TieneRecursos) casilla.devolverUnidad()).tieneRecursos()) {
                    // El edificio ademas tiene recursos extraidos
                    return (TieneRecursos) casilla.devolverUnidad();
                }
            }
        }
        return null;
    }

    public boolean buscarEdificioGuarida() {
        for(Casilla casilla : casillas) {
            // Recorre todas las casillas del mapa
            if(casilla.devolverEdificio() instanceof Guarida) {
                return true;
            } 
        }
        return false;
    }

    public boolean buscarEdificioAcceso() {
        for(Casilla casilla : casillas) {
            // Recorre todas las casillas del mapa
            if(casilla.devolverEdificio() instanceof Acceso) {
                return true;
            } 
        }
        return false;
    }*/

}
