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
import edu.fiuba.algo3.modelo.excepciones.TerrenoNoAptoParaConstruirTalEdificio;
import edu.fiuba.algo3.modelo.geometria.Coordenada;

public class TerrenoBase extends Terreno {


    private EstadoTerreno estado = new TerrenoVacio(this);

    public TerrenoBase(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
    public void establecerEdificio(Edificio edificio){
        this.edificio = edificio;
    }

    public void establecerEstado(EstadoTerreno estado){
        this.estado = estado;
    }

    public void ocuparPorEdificio(Pilon pilon){
        estado.ocuparPorEdificio(pilon);
    }

    public void ocuparPorEdificio(Acceso acceso){
        estado.ocuparPorEdificio(acceso);
    }

    public void ocuparPorEdificio(Asimilador asimilador){
        estado.ocuparPorEdificio(asimilador);
    }

    public void ocuparPorEdificio(NexoMineral nexoMineral){
        estado.ocuparPorEdificio(nexoMineral);
    }

    public void ocuparPorEdificio(PuertoEstelar puertoEstelar){
        estado.ocuparPorEdificio(puertoEstelar);
    }

    public void ocuparPorEdificio(Criadero criadero){
        estado.ocuparPorEdificio(criadero);
    }

    public void ocuparPorEdificio(Espiral espiral){
        estado.ocuparPorEdificio(espiral);
    }

    public void ocuparPorEdificio(Extractor extractor){
        estado.ocuparPorEdificio(extractor);
    }

    public void ocuparPorEdificio(Guarida guarida){
        estado.ocuparPorEdificio(guarida);
    }

    public void ocuparPorEdificio(ReservaDeReproduccion reservaDeReproduccion){
        estado.ocuparPorEdificio(reservaDeReproduccion);
    }

    public void energizarTerreno() { estado.energizarTerreno(); }

    public void cubrirTerrenoDeMoho() { estado.cubrirTerrenoDeMoho();}

    public void vaciarTerreno() { estado.vaciarTerreno(); }



}
