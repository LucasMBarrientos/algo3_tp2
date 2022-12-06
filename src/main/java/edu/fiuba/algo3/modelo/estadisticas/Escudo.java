package edu.fiuba.algo3.modelo.estadisticas;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;

public class Escudo{

    private final double tasaDeRegeneracion = 0.05;
    private final int poderMaximo;
    private int poderActual;

    public Escudo(int poderMaximo){
        this.poderMaximo = poderMaximo;
        this.poderActual = poderMaximo;
    }

    public int recibirDanio(Danio danio) {
        poderActual = Math.max(poderActual,0);
        poderActual = danio.aplicarDanio(poderActual);

        return Math.min(poderActual, 0);
    }

    public void regenerar() {
        poderActual = Math.max(poderActual, 0);
        poderActual += Math.min(poderMaximo - poderActual, poderMaximo * tasaDeRegeneracion);
    }

    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("escudo", poderActual);
        return node;
    }

}
