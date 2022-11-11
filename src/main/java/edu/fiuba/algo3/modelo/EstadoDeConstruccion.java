package edu.fiuba.algo3.modelo;

public interface EstadoDeConstruccion {

    public abstract Zangano generarZangano();

    public abstract Unidad generarUnidad(Unidad unidad);

    public abstract void actualizar();

}
