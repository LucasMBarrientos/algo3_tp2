package edu.fiuba.algo3.modelo.estadisticas;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.fiuba.algo3.modelo.Json;
import edu.fiuba.algo3.modelo.excepciones.AtaqueImposibleDeRealizarse;
import edu.fiuba.algo3.modelo.excepciones.EdificioEstaDestruido;

public class Vida {

    private final double tasaDeRegeneracion = 0.05;
    private final int valorMaximo;
    private int valorActual;

    public Vida(int valorMaximo) {
        this.valorMaximo = valorMaximo;
        this.valorActual = valorMaximo;
    }

    public boolean recibirDanio(Danio danio) {
        valorActual = danio.aplicarDanio(valorActual);
        if (valorActual <= 0) {
            return true;
        }else{
          return false;
        }
    }

    public void regenerar() {
        valorActual += Math.min(valorMaximo - valorActual, valorMaximo * tasaDeRegeneracion);
    }

    public ObjectNode toData() {
        ObjectNode node = Json.createObjectNode();
        node.put("vida", valorActual);
        return node;
    }

}
