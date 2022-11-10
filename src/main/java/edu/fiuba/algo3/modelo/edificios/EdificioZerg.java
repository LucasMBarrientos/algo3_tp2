package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.edificios.*;

public abstract class EdificioZerg extends Edificio {

    protected void regenerarVida() {
        if (vida < vidaMax) {
            vida += (0.1 * vidaMax);
        }
        if (vida > vidaMax) {
            vida = vidaMax;
        }
    }

    public boolean recibirDanio(int unidades) {
        reducirVida(unidades);
        return (vida <= 0);
    }

}