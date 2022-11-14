package edu.fiuba.algo3.modelo.edificios.zerg;

import edu.fiuba.algo3.modelo.EdificioNoTerminoDeConstruirse;
import edu.fiuba.algo3.modelo.Inventario;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.zerg.Zangano;

public class ExtractorEnConstruccion  implements EstadoExtractor{

    public void ingresarUnidad(Zangano zangano) {
        throw new EdificioNoTerminoDeConstruirse();
    }

    public void recolectarRecursos(Terreno terreno, Inventario inventario) { }

}
