package edu.fiuba.algo3.modelo.recursos;

public class Recursos {

    private int unidades;

    public Recursos(int unidades) {
        this.unidades = unidades;
    }

    public int devolverUnidades() {
        return this.unidades;
    }

    public int restar(int unidadesAExtraer) {
        int unidadesQueSeExtraeran = unidadesAExtraer;
        if (unidadesAExtraer >= this.unidades) {
            unidadesQueSeExtraeran = this.unidades;
        }
        int unidadesExtraidas = unidadesQueSeExtraeran;
        this.unidades -= unidadesExtraidas;
        return unidadesExtraidas;
    }

    public int restarTodo() {
        int unidadesExtraidas = this.unidades;
        this.unidades = 0;
        return unidadesExtraidas;
    }

    public boolean agotado() {
        return unidades == 0;
    }

    public void agregarUnidades(int nuevasUnidades) {
        unidades += nuevasUnidades;
    }

}
