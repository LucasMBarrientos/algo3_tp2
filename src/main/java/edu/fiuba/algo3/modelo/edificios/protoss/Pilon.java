package edu.fiuba.algo3.modelo.edificios.protoss;

import edu.fiuba.algo3.modelo.Casilla;
import edu.fiuba.algo3.modelo.Coordenada;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.zerg.CriaderoOperativo;
import edu.fiuba.algo3.modelo.estadisticas.Danio;
import edu.fiuba.algo3.modelo.estadisticas.EdificioDestruido;
import edu.fiuba.algo3.modelo.estadisticas.Escudo;
import edu.fiuba.algo3.modelo.estadisticas.Vida;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Pilon extends EdificioProtoss {

    private int tiempoDeConstruccion = 5;
    private Coordenada coordenada;
    private EstadoPilon estado = new PilonEnConstruccion();
    private final Vida vida = new Vida(300);
    private final Escudo escudo = new Escudo(300);
    public Pilon(Coordenada coordenada) { }
    public Pilon() {
        this.costoEnMinerales = new Minerales(100);
    }

    public void actualizar(Inventario inventario) {
        tiempoDeConstruccion--;
        if (tiempoDeConstruccion == 0) {
            estado = new PilonOperativo();
        }
        escudo.regenerar();
    }
    @Override
    public boolean generaTerrenoEnergizado() {
        return estado.generaTerrenoEnergizado();
    }

    public void recibirGolpe(Danio danio) throws EdificioDestruido {
        int escudoRestante;
        escudoRestante = escudo.recibirDanio(danio);
        if(escudoRestante < 0){
            vida.recibirDanio(new Danio(escudoRestante * (-1)));
        }
    }
    @Override
    public void actualizar() {
        escudo.regenerar();
    }

    public void ocupar(Casilla casilla, Terreno terreno){
        terreno.ocuparPorEdificio(this, casilla);
    }




    /*
    public Pilon() {
        this.tiempoConstruccion = 5;
        this.requerimientosGas = 0;
        this.requerimientosMinerales = 100;
        this.vida = 300;
        this.escudo = 300;
        this.vidaMax = 300;
        this.escudoMax = 300;
    }

    @Override
    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return casilla.devolverTerreno() instanceof TerrenoEnergizado;
    }

    @Override
    public void actualizar() {
        regenerarEscudo();
    }*/
}
