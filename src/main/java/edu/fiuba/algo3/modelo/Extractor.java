package edu.fiuba.algo3.modelo;

public class Extractor extends Edificio {

    public int zanganosTrabajando = 0;
    
    public Extractor() {
        this.tiempoConstruccion = 6;
    }

    public boolean validarRequerimientosDelCasillero(Casilla casilla) {
        return (casilla.devolverTerreno() instanceof Volcan);
    }

    public void actualizar() {
        
    }

}
