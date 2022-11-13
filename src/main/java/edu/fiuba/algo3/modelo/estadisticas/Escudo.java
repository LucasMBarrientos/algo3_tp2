package edu.fiuba.algo3.modelo.estadisticas;

public class Escudo extends Estadisticas{
    private final int escudoMaximo;
    private int escudo;

    public Escudo(int escudoMaximo){
        this.escudoMaximo = escudoMaximo;
        this.escudo = escudoMaximo;
    }

    public int recibirDanio(Danio danio) {
        escudo = danio.aplicarDanio(escudo);
        return escudo;
    }

    public void regenerar(){
        escudo += (escudoMaximo * 0.2);
    }

}
