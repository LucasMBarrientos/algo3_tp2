package edu.fiuba.algo3.modelo;

public class CriaderoEnConstruccion implements EstadoDeConstruccion {

    public Zangano generarZangano() throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    public Unidad generarUnidad(Unidad unidad) throws EdificioNoTerminoDeConstruirse{
        throw new EdificioNoTerminoDeConstruirse();
    }

    public void actualizar() { }//estaria bueno que esto reste el tiempo de construccion
}
