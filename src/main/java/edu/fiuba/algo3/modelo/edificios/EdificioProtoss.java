package edu.fiuba.algo3.modelo.edificios;

public abstract class EdificioProtoss extends Edificio {
    
    protected int escudo;
    protected int escudoMax;

    protected boolean operativo;

    protected void regenerarEscudo() {
        if (escudo < escudoMax) {
            escudo += (0.2 * escudoMax);
        }
        if (escudo > escudoMax) {
            escudo = escudoMax;
        }
    }

    protected void reducirEscudo(int unidades) {
        escudo -= unidades;
    }

    public boolean recibirDanio(int unidades) {
        if (unidades < escudo) {
            reducirEscudo(unidades);
        } else {
            reducirVida(unidades - escudo);
            escudo = 0;
        }
        return (vida <= 0);
    }

    public void establecerOperatividad(boolean operativo) {
        this.operativo = operativo;
    }

    public boolean devolverOperatividad() {
        return operativo;
    }

    public int devolverEscudo(){
        return escudo;
    }
    

}
