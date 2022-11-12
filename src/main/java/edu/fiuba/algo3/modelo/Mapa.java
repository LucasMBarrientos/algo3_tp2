package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.edificios.protoss.Pilon;
import edu.fiuba.algo3.modelo.edificios.zerg.Criadero;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Mapa {

    private List<Casilla> casillas = new ArrayList<Casilla>();

    private Coordenada dimensiones;

    public Mapa(Coordenada dimensionesDelMapa) {
        this.dimensiones = dimensionesDelMapa;
        for (int x = 0; x < this.dimensiones.devolverX(); x++) {
            for (int y = 0; y < this.dimensiones.devolverY(); y++) {
                this.casillas.add(new Casilla(new Coordenada(x,y)));
            }
        }
        generarTerreno();
    }

    private boolean validarCoordenada(Coordenada coordenada) {
        return coordenada.dentroDeCoordenadas(dimensiones);
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
        if (validarCoordenada(coordenada)) {
            for (int i = 0; i < this.casillas.size(); i++) {
                if (this.casillas.get(i).compararCoordenadas(coordenada)) {
                    indiceDeLaCasilla = i;
                }
            }
        }
        // TODO : Lanzar Excepcion: Casilla fuera de las dimensiones del mapa si indiceDeLaCasilla == -1
        return this.casillas.get(indiceDeLaCasilla);
    }

    private List<Casilla> buscarCasillasAdyacentes(Casilla casilla) {
        List<Coordenada> coordenadasAdyacentes = casilla.devolverCoordenadasAdyacentes();
        List<Casilla> casillasAdyacentes = new ArrayList<>();
        for (int i = 0; i < coordenadasAdyacentes.size(); i++) {
            if (validarCoordenada(coordenadasAdyacentes.get(i))) {
                // Coordenada esta dentro del mapa
                casillasAdyacentes.add(buscarCasilla(coordenadasAdyacentes.get(i)));
            }
        }
        return casillasAdyacentes;
    }

    public List<Casilla> buscarCasillasAdyacentes(Coordenada coordenada) {
        Casilla casilla = this.buscarCasilla(coordenada);
        return buscarCasillasAdyacentes(casilla);
    }

    private Casilla buscarCasillaAlAzar() {
        int x = ThreadLocalRandom.current().nextInt(0, dimensiones.devolverX());
        int y = ThreadLocalRandom.current().nextInt(0, dimensiones.devolverY());
        Coordenada coordeandaAlAzar = new Coordenada(x, y);
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
        if(turno % 4 == 0) {
            // Se expande el moho una vez cada 2 rondas (4 turnos)
            expandirMoho();
        }
        //actualizarTerrenoEnergizado();
    }

    private void generarTerreno() {
        int maximoGenerado = (dimensiones.devolverX() * dimensiones.devolverY()) / 10;
        // Generar volcanes en el mapa
        for (int i=0; i < maximoGenerado; i++) {
            buscarCasillaAlAzar().establecerTerreno(new TerrenoVolcan());
        }
        // Generar minerales en el mapa
        for (int i=0; i < maximoGenerado; i++) {
            buscarCasillaAlAzar().establecerTerreno(new TerrenoMineral());
        }
        // Generar el terreno inicial del criadero de los zerg (En la esquina superior izquierda del mapa)
        Coordenada ubicacionInicialDeUnJugador = new Coordenada(1, 1);
        this.buscarCasilla(ubicacionInicialDeUnJugador).establecerTerreno(new TerrenoMoho(ubicacionInicialDeUnJugador));
        this.buscarCasilla(ubicacionInicialDeUnJugador).establecerEdificio(new Criadero(ubicacionInicialDeUnJugador));
        for (int i = 0; i < 3; i++) {
            expandirMoho();
        }
        // Generar el terreno inicial del pilon de los protoss (En la esquina inferior derecha del mapa)
        ubicacionInicialDeUnJugador = new Coordenada(dimensiones.devolverX() - 1, dimensiones.devolverY() - 1);
        this.buscarCasilla(ubicacionInicialDeUnJugador).establecerTerreno(new TerrenoEnergizado());
        this.buscarCasilla(ubicacionInicialDeUnJugador).establecerEdificio(new Pilon(ubicacionInicialDeUnJugador));
    }

    private void expandirMoho() {
        BuscadorDeTerreno buscadorDeTerreno = new BuscadorDeTerreno();
        List<Casilla> casillasConMoho = buscadorDeTerreno.buscarCasillasConMoho(casillas);
        for (Casilla casillaConMoho : casillasConMoho) {
            casillaConMoho.expandirTerreno(this);                
        }
    }

    private void actualizarTerrenoEnergizado() {
        /*
        BuscadorDeTerreno generadorDeTerreno = new BuscadorDeTerreno();
        Boolean pilonDetectado;
        List<Casilla> casillasConPilones = new ArrayList<>();
        for (Casilla casilla : casillas) {


            pilonDetectado = generadorDeTerreno.generarTerrenoEnergizadoEnPilon(casilla, casilla.devolverEdificio().generaEnergia());

        }
        */
    }











/*

    public void expandirMoho(Casilla casillaConMoho) {
        List<Casilla> casillasAdyacentes = this.buscarCasillasContiguas(casillaConMoho);
        for (Casilla casillaAdyacente : casillasAdyacentes) {
            casillaAdyacente.establecerTerreno(new TerrenoMoho());
        }
    }

    private List<Casilla> buscarCasillasConMoho() {
        List<Casilla> casillasConMoho = new ArrayList<Casilla>(); 
        for (Casilla casilla : casillas) {
            if (casilla.devolverTerreno() instanceof TerrenoMoho) {
                casillasConMoho.add(casilla);
            }
        }
        return casillasConMoho;
    }

*/






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
