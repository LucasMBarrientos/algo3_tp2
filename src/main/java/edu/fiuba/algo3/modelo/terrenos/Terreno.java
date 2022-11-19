package edu.fiuba.algo3.modelo.terrenos;

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
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.unidades.zerg.Guardian;

public abstract class Terreno {

    protected Coordenada coordenada;

    protected Edificio edificio;
    /*
    public void establecerEstado(EstadoTerreno estado) {
        this.estado = estado;
        this.estado.setTerreno(this);
    }*/

    public boolean compararCoordenadas(Coordenada coordenada) {
        return this.coordenada.esIgual(coordenada);
    }

    public abstract void ocuparPorEdificio(Pilon pilon);

    public abstract void ocuparPorEdificio(Acceso acceso);

    public abstract void ocuparPorEdificio(Asimilador asimilador);

    public abstract void ocuparPorEdificio(NexoMineral nexoMineral);

    public abstract void ocuparPorEdificio(PuertoEstelar puertoEstelar);

    public abstract void ocuparPorEdificio(Criadero criadero);

    public abstract void ocuparPorEdificio(Espiral espiral);

    public abstract void ocuparPorEdificio(Extractor extractor);

    public abstract void ocuparPorEdificio(Guarida guarida);

    public abstract void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion);


    public abstract void vaciarTerreno();

    public abstract void energizarTerreno();

    public abstract void cubrirTerrenoDeMoho();

    public void recibirGolpe(Danio danioTerrestre, Danio danioAereo){
        edificio.recibirGolpe(danioTerrestre,danioAereo);
    }

    /*
    public EstadoTerreno DEBUGDEVOLVERESTADO() {
        return estado;
    }
*/






































}
