package edu.fiuba.algo3.modelo.estadisticas;

public class Vida extends Estadisticas{
    private final double porcentajeDeRegeneracion = 0.05;
    private final int vidaMaxima;
    private int vida;

    public Vida(int vidaMaxima){
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
    }

    public void recibirDanio(Danio danio) throws EdificioDestruido{
        vida = danio.aplicarDanio(vida);
        if (vida <= 0){
            throw new EdificioDestruido();
        }
    }

    public void regenerar(){
        if(vida <= vidaMaxima - (vidaMaxima * porcentajeDeRegeneracion)){
            vida += (vidaMaxima * porcentajeDeRegeneracion);
        }
    }

}
