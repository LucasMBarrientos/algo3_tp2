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
import edu.fiuba.algo3.modelo.estadisticas.Danio;
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
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));
        int tiempoDeConstruccion = 4;
        
        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            criadero.actualizar(inv);
        }

        inv.agregarEdificio(criadero);

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            criadero.generarUnidad(new Zangano(),inv);
        });
    }

	@Test
    public void unCriaderoEstaOperativoTras4TurnosConstruyendose() {
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100));
        int tiempoDeConstruccion = 4;

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            criadero.actualizar(inv);
        }
        inv.agregarEdificio(criadero);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        criadero.generarUnidad(new Zangano(),inv);
        Assertions.assertThrows(NoHayLarvasSuficientes.class, ()->{
            criadero.generarUnidad(new Zangano(),inv);
        });
    }
 
	@Test
    public void unaReservaDeReproduccionNoEstaOperativaEnMenosDe12TurnosConstruyendose() {
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100));
        int tiempoDeConstruccion = 12;

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            reservaDeReproduccion.actualizar(inv);
        }
        inv.agregarEdificio(criadero);
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            reservaDeReproduccion.generarUnidad(new Zerling(),inv);
        });
    }

	@Test
    public void unaReservaDeReproduccionEstaOperativaTras12TurnosConstruyendose() {
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100));
        int tiempoDeConstruccion = 12;

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            reservaDeReproduccion.actualizar(inv);
        }

        for (int i = 0; i < 4; i++) {
          criadero.actualizar(inv);
        }

        inv.agregarEdificio(criadero);
        Assertions.assertNotNull(reservaDeReproduccion.generarUnidad(new Zerling(),inv));

    }

    @Test
    public void unaExtractorNoEstaOperativoEnMenosDe6TurnosConstruyendose() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(100));
        Extractor extractor = new Extractor();
        int tiempoDeConstruccion = 6;
        extractor.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            extractor.actualizar(inv);
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
          extractor.recibirDanio(new Danio(1),new Danio(1)); 
        });
    }

	@Test
    public void unExtractorEstaOperativoTras6TurnosConstruyendose() {
        Terreno terrenoVolcan = new TerrenoVolcan(new Coordenada( 1,2));
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));
        Extractor extractor = new Extractor();
        int tiempoDeConstruccion = 6;
        extractor.ocupar(terrenoVolcan);

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            extractor.actualizar(inv);
        }
        extractor.ingresarUnidad(new Zangano());

        extractor.extraerRecursos(inv);

        inv.consumirGasVespeno(new GasVespeno(1));

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            inv.consumirGasVespeno(new GasVespeno(100));
        });
    }

	@Test
    public void unaGuaridaNoEstaOperativaEnMenosDe12TurnosConstruyendose() {
        Guarida guarida = new Guarida();
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));
        int tiempoDeConstruccion = 12;

        for (int i = 0; i < tiempoDeConstruccion - 1; i++) {
            guarida.actualizar(inv);
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            guarida.generarUnidad( new Hidralisco(),inv);
        });
    }

	@Test
    public void unaGuaridaEstaOperativaTras12TurnosConstruyendose() {
        Guarida guarida = new Guarida();
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(25), new Mineral(75));
        int tiempoDeConstruccion = 12;

        for (int i = 0; i < tiempoDeConstruccion; i++) {
            guarida.actualizar(inv);
        }

        for (int i = 0; i < 4; i++) {
          criadero.actualizar(inv);
        }

        inv.agregarEdificio(criadero);

        Assertions.assertNotNull(guarida.generarUnidad(new Hidralisco(),inv));
    }

	@Test
    public void unaEspiralNoEstaOperativaEnMenosDe10TurnosConstruyendose() {
        Espiral espiral = new Espiral();
        Inventario inv = new Inventario(new GasVespeno(25), new Mineral(75));
        int tiempoDeConstruccion = 10;

        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            espiral.actualizar(inv);
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            espiral.generarUnidad( new Mutalisco(),inv);
        });
    }

	@Test
    public void unaEspiralEstaOperativaTras10TurnosConstruyendose() {
        Espiral espiral = new Espiral();
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(100), new Mineral(100));
        int tiempoDeConstruccion = 10;

        for(int i = 0; i < tiempoDeConstruccion; i++) {
            espiral.actualizar(inv);
        }

        for (int i = 0; i < 4; i++) {
          criadero.actualizar(inv);
        }

        inv.agregarEdificio(criadero);

        Assertions.assertNotNull(espiral.generarUnidad(new Mutalisco(),inv));
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
            nexoMineral.actualizar(inv);
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
          nexoMineral.recibirDanio(new Danio(1),new Danio(1)); 
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
            nexoMineral.actualizar(inv);
        }

        nexoMineral.extraerRecursos(inv);

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
            asimilador.actualizar(inv);
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
          asimilador.recibirDanio(new Danio(1),new Danio(1)); 
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
            asimilador.actualizar(inv);
        }

        asimilador.extraerRecursos(inv);

        inv.consumirGasVespeno(new GasVespeno(1));

        Assertions.assertThrows(RecursosInsuficientes.class, ()->{
            inv.consumirGasVespeno(new GasVespeno(100));
        });
    }

	@Test
    public void unAccesoNoEstaOperativoEnMenosDe8TurnosConstruyendose() {
        Acceso acceso = new Acceso();
        Inventario inv = new Inventario(new GasVespeno(0), new Mineral(0));
        int tiempoDeConstruccion = 8;

        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            acceso.actualizar(inv);
        }

        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            acceso.generarUnidad(new Zealot(),inv);
        });
    }

	@Test
    public void unAccesoEstaOperativoTras8TurnosConstruyendose() {
        Acceso acceso = new Acceso();
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(50), new Mineral(125));
        int tiempoDeConstruccion = 8;

        for(int i = 0; i < tiempoDeConstruccion; i++) {
            acceso.actualizar(inv);
        }

        for (int i = 0; i < 4; i++) {
          criadero.actualizar(inv);
        }

        inv.agregarEdificio(criadero);

        Assertions.assertNotNull(acceso.generarUnidad(new Dragon(),inv));
    }

	@Test
    public void unPuertoEstelarNoEstaOperativoEnMenosDe10TurnosConstruyendose() {
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(50), new Mineral(125));
        int tiempoDeConstruccion = 10;

        for(int i = 0; i < tiempoDeConstruccion - 1; i++) {
            puertoEstelar.actualizar(inv);
        }

        for (int i = 0; i < 4; i++) {
          criadero.actualizar(inv);
        }

        inv.agregarEdificio(criadero);
        Assertions.assertThrows(EdificioNoTerminoDeConstruirse.class, ()->{
            puertoEstelar.generarUnidad(new Scout(),inv);
        });
    }

	@Test
    public void unPuertoEstelarEstaOperativoTras8TurnosConstruyendose() {
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        Criadero criadero = new Criadero();
        Inventario inv = new Inventario(new GasVespeno(150), new Mineral(300));
        int tiempoDeConstruccion = 10;

        for(int i = 0; i < tiempoDeConstruccion; i++) {
            puertoEstelar.actualizar(inv);
        }
        for (int i = 0; i < 4; i++) {
          criadero.actualizar(inv);
        }

        inv.agregarEdificio(criadero);
        Assertions.assertNotNull(puertoEstelar.generarUnidad(new Scout(),inv));
    }
}
