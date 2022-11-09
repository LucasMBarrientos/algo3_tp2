package edu.fiuba.algo3.modelo;

public class Casilla {

    private int x,y;
    public Ocupante ocupante;
    public Terreno terreno;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Casilla(int x, int y, Ocupante ocupante) {
        this.x = x;
        this.y = y;
        this.ocupante = ocupante;
    }

    public Casilla(int x, int y, Terreno terreno) {
        this.x = x;
        this.y = y;
        this.terreno = terreno;
    }

    public int devolverX() {
        return this.x;
    }

    public int devolverY() {
        return this.y;
    }
    
    public Ocupante devolverOcupante() {
        return this.ocupante;
    }

    public void establecerTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public void establecerOcupante(Ocupante ocupante) {
        if (this.terreno.validarOcupante(ocupante)) {
            this.ocupante = ocupante;
        }
    }

    /*
    public Casilla obtenerCasillaRelativa(int distanciaX, int distanciaY){
        return new Casilla(this.x + distanciaX, this.y + distanciaY);
    }
    */

    /*
    public void construirEdificio(){
        if(devolverOcupante() instanceof Zangano){
            ((Zangano) devolverOcupante()).construir(this);
        }else{
            //hacemos otra cosa
        }
    }
    */

    
    public boolean validarCasillaAdyacente(Casilla casillaComparada) {
        int x = casillaComparada.devolverX();
        int y = casillaComparada.devolverY();
        return (x > this.x - 1 && x < this.x + 1 && y > this.y - 1 && y < this.y + 1);
    }
    
    public boolean ocupada() {
        return (this.ocupante != null);
    }

    public boolean compararUbicaciones(Casilla casillaComparada) {
        return (this.x == casillaComparada.devolverX() && this.y == casillaComparada.devolverY());
    }
}
