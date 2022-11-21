package edu.fiuba.algo3.entrega_1;

import com.tngtech.archunit.lang.ArchRule;

import edu.fiuba.algo3.modelo.edificios.protoss.acceso.Acceso;
import edu.fiuba.algo3.modelo.edificios.protoss.asimilador.Asimilador;
import edu.fiuba.algo3.modelo.edificios.protoss.nexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.edificios.protoss.puertoEstelar.PuertoEstelar;
import edu.fiuba.algo3.modelo.edificios.zerg.criadero.Criadero;
import edu.fiuba.algo3.modelo.edificios.zerg.espiral.Espiral;
import edu.fiuba.algo3.modelo.edificios.zerg.extractor.Extractor;
import edu.fiuba.algo3.modelo.edificios.zerg.guarida.Guarida;
import edu.fiuba.algo3.modelo.edificios.zerg.reservadeReproduccion.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.excepciones.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.excepciones.NoHayLarvasSuficientes;
import edu.fiuba.algo3.modelo.excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.geometria.Coordenada;
import edu.fiuba.algo3.modelo.jugadores.Inventario;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.TerrenoMineral;
import edu.fiuba.algo3.modelo.terrenos.TerrenoVolcan;
import edu.fiuba.algo3.modelo.unidades.protoss.Dragon;
import edu.fiuba.algo3.modelo.unidades.protoss.Scout;
import edu.fiuba.algo3.modelo.unidades.protoss.Zealot;
import edu.fiuba.algo3.modelo.unidades.zerg.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;
import edu.fiuba.algo3.modelo.unidades.zerg.Zerling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoDeUso2 {


    // Edificios zerg
    
	@Test
    public void unCriaderoNoEstaOperativoEnMenosDe4TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        int tiempoDeConstruccion = 4;
        
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            criadero.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }

	@Test
    public void unCriaderoEstaOperativoTras4TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        int tiempoDeConstruccion = 4;

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            criadero.actualizar();
        }

        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        criadero.generarUnidad(new Zangano());
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano());
        });
    }

	@Test
    public void unaReservaDeReproduccionNoEstaOperativaEnMenosDe12TurnosConstruyendose() {
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        int tiempoDeConstruccion = 12;

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            reservaDeReproduccion.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            reservaDeReproduccion.generarUnidad(new Zerling());
        });
    }

	@Test
    public void unaReservaDeReproduccionEstaOperativaTras12TurnosConstruyendose() {
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        int tiempoDeConstruccion = 12;


        for (int i = 0; i < tiempoDeConstruccion; i++) {
            reservaDeReproduccion.actualizar();
        }

        Assertions.assertNotNull(reservaDeReproduccion.generarUnidad(new Zerling()));

    }

    @Test
    public void unaExtractorNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
        Extractor extractor = new Extractor();
        int tiempoDeConstruccion = 6;
        extractor.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            extractor.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            extractor.recolectarRecursos(new Inventario(new GasVespeno(0), new Mineral(0)));
        });
    }

	@Test
    public void unExtractorEstaOperativoTras6TurnosConstruyendose() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
        Extractor extractor = new Extractor();
        int tiempoDeConstruccion = 6;
        extractor.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            extractor.actualizar();
        }
        extractor.ingresarUnidad(new Zangano());
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));

        extractor.recolectarRecursos(inv);

        inv.consumirGasVespeno(new GasVespeno(1));

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            inv.consumirGasVespeno(new GasVespeno(100));
        });
    }

	@Test
    public void unaGuaridaNoEstaOperativaEnMenosDe12TurnosConstruyendose() {
        Guarida guarida = new Guarida();
        int tiempoDeConstruccion = 12;

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            guarida.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            guarida.generarUnidad( new Hidralisco());
        });
    }

	@Test
    public void unaGuaridaEstaOperativaTras12TurnosConstruyendose() {
        Guarida guarida = new Guarida();
        int tiempoDeConstruccion = 12;


        for (int i = 0; i < tiempoDeConstruccion; i++) {
            guarida.actualizar();
        }

        Assertions.assertNotNull(guarida.generarUnidad(new Hidralisco()));
    }

	@Test
    public void unaEspiralNoEstaOperativaEnMenosDe10TurnosConstruyendose() {
        Espiral espiral = new Espiral();
        int tiempoDeConstruccion = 10;

        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            espiral.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            espiral.generarUnidad( new Mutalisco());
        });
    }

	@Test
    public void unaEspiralEstaOperativaTras10TurnosConstruyendose() {
        Espiral espiral = new Espiral();
        int tiempoDeConstruccion = 10;

        for(int i = 0; i < tiempoDeConstruccion; i++) {
            espiral.actualizar();
        }

        Assertions.assertNotNull(espiral.generarUnidad(new Mutalisco()));
    }

    // Edificios protoss

    @Test
    public void unNexoMineralNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        TerrenoMineral terrenoMineral = new TerrenoMineral(new Coordenada( 1,1));
        NexoMineral nexoMineral = new NexoMineral();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));
        int tiempoDeConstruccion = 4;
        nexoMineral.ocupar(terrenoMineral);
        
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            nexoMineral.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
          nexoMineral.recolectarRecursos(inv);
        });
    }
   

           
	@Test
    public void unNexoMineralEstaOperativoTras5TurnosConstruyendose() {
        TerrenoMineral terrenoMineral = new TerrenoMineral(new Coordenada( 1,1));
        NexoMineral nexoMineral = new NexoMineral();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));
        int tiempoDeConstruccion = 4;
        nexoMineral.ocupar(terrenoMineral);

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            nexoMineral.actualizar();
        }

        nexoMineral.recolectarRecursos(inv);

        inv.consumirMinerales(new Mineral(1));

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            inv.consumirMinerales(new Mineral(100));
        });
    }
/*  
	@Test
    public void unPilonNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        AlgoStar algoStar = new AlgoStar();
        JugadorProtoss jugadorProtoss = new JugadorProtoss("El primogenito", "#0000ff");
        algoStar.agregarJugador(jugadorProtoss);
        algoStar.agregarJugador(new JugadorZerg("La mente suprema", "#ff0000"););
        algoStar.empezarJuego();
        int tiempoDeConstruccion = 5;

        jugadorProtoss.construirEdificio(new Coordenada(2,2), new Pilon());
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            algoStar.pasarTurno();
            algoStar.pasarTurno();
        }

        Assertions.assertThrows(TerrenoNoAptoParaConstruirEsteEdificio.class, ()->{
            jugadorProtoss.construirEdificio(new Coordenada(3,2), new Acceso());
        }        
    }

	@Test
    public void unPilonEstaOperativoTras5TurnosConstruyendose() {
    	// TODO: Pensar como probar la operatividad del pilon
    }
*/
    @Test
    public void unAsimiladorNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        TerrenoVolcan terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
        Asimilador asimilador = new Asimilador();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));
        int tiempoDeConstruccion = 6;
        asimilador.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            asimilador.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
          asimilador.recolectarRecursos(inv);
        });
    }
  
	@Test
    public void unAsimiladorEstaOperativoTras6TurnosConstruyendose() {
        TerrenoVolcan terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,1));
        Asimilador asimilador = new Asimilador();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));
        int tiempoDeConstruccion = 6;
        asimilador.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            asimilador.actualizar();
        }

        asimilador.recolectarRecursos(inv);

        inv.consumirGasVespeno(new GasVespeno(1));

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            inv.consumirGasVespeno(new GasVespeno(100));
        });
    }

	@Test
    public void unAccesoNoEstaOperativoEnMenosDe8TurnosConstruyendose() {
        Acceso acceso = new Acceso();
        int tiempoDeConstruccion = 8;

        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            acceso.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            acceso.generarUnidad(new Zealot());
        });
    }

	@Test
    public void unAccesoEstaOperativoTras8TurnosConstruyendose() {
        Acceso acceso = new Acceso();
        int tiempoDeConstruccion = 8;

        for(int i = 0; i < tiempoDeConstruccion; i++) {
            acceso.actualizar();
        }

        Assertions.assertNotNull(acceso.generarUnidad(new Dragon()));
    }

	@Test
    public void unPuertoEstelarNoEstaOperativoEnMenosDe10TurnosConstruyendose() {
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        int tiempoDeConstruccion = 10;

        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            puertoEstelar.actualizar();
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            puertoEstelar.generarUnidad(new Scout());
        });
    }

	@Test
    public void unPuertoEstelarEstaOperativoTras8TurnosConstruyendose() {
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        int tiempoDeConstruccion = 10;

        for(int i = 0; i < tiempoDeConstruccion; i++) {
            puertoEstelar.actualizar();
        }

        Assertions.assertNotNull(puertoEstelar.generarUnidad(new Scout()));
    }


}
