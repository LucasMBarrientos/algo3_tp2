package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.recursos.GasVespeno;
import edu.fiuba.algo3.modelo.recursos.Minerales;
import edu.fiuba.algo3.modelo.recursos.Recursos;
import edu.fiuba.algo3.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Edificio> edificios = new ArrayList<Edificio>();
    private List<Unidad> unidades = new ArrayList<Unidad>();
    public GasVespeno gasVespeno;
    public Minerales minerales;

    public Inventario(GasVespeno gasVespeno, Minerales minerales){
        this.gasVespeno = gasVespeno;
        this.minerales = minerales;
    }

    public void agregarEdificio(Edificio edificioNuevo){
        edificios.add(edificioNuevo);
    }

    public void actualizarGasVespeno(Recursos gasVespeno){
        this.gasVespeno.agregarUnidades(gasVespeno);
    }

    public int contarLarvas() {
        int larvasTotales = 0;
        for (Edificio edificio : edificios) {
            larvasTotales += edificio.contarLarvas();
        }
        return larvasTotales;
    }


    public void consumirLarva() {
        for (Edificio edificio : edificios) {
            if (edificio.contarLarvas() > 0) {
                edificio.consumirLarva();
            }
        }
    }


    public Edificio devolverEdificioConLarvas() {
        Edificio edificioConLarvas = null;
        for (Edificio edificio : edificios) {
            if (edificio.contarLarvas() > 0) {
                edificioConLarvas = edificio;
            }
        }
        return edificioConLarvas;
    }

    public void generarUnidad(Casilla casillaConEdifico) {
        Edificio edificioConLarvas = this.devolverEdificioConLarvas();
        casillaConEdifico.generarUnidad(edificioConLarvas, gasVespeno, minerales);
        //casillaConEdifico.generarUnidad(edificioConLarvas);
    }

    public void actualizarMinerales(Recursos minerales){
        this.minerales.agregarUnidades(minerales);
    }

    public void agregarUnidad(Unidad unidadNueva){
        unidades.add(unidadNueva);
    }

    public void consumirMinerales(Recursos RecursoRequerido){
        minerales.gastar(RecursoRequerido);
    }

    public void consumirGasVespeno(Recursos RecursoRequerido){
        gasVespeno.gastar(RecursoRequerido);
    }

    public boolean faltanEdificios(List<Edificio> edificiosAComprobar){
      boolean faltanEdificios = false;
      for (int i = 0; i < edificiosAComprobar.size(); i++) {
        if(edificios.isEmpty()){
          return true;
        }else{
          faltanEdificios = true;
          for (int j = 0; j < edificios.size(); j++) {
            if (edificiosAComprobar.get(i).compararCon(edificios.get(j))){
              faltanEdificios = false;
            }
          }
          if (faltanEdificios){
            return true;
          }
        }
      }
      return faltanEdificios;
    }

    //TODO: VER LOS ACTUALIZAR DE LOS EDIFICIOS
    /*public void actualizar(){
        for(Edificio edificio: edificios){
            edificio.actualizar(this);
        }
    }*/





/*
    public Recursos unidadesGas = new Recursos(200), unidadesMineral = new Recursos(200);

    public int devolverCantidadGas(){
        return unidadesGas.devolverUnidades();
    }

    public int devolverCantidadMinerales(){
        return unidadesMineral.devolverUnidades();
    }

    public void agregarGas(int cantidad) {
        unidadesGas.agregarUnidades(cantidad);
    }

    public void agregarMinerales(int cantidad){
        unidadesMineral.agregarUnidades(cantidad);
    }

    public void agregarRecursos(Recursos recursos) {
        int nuevasUnidades = recursos.restarTodo();
        if (recursos instanceof GasVespeno) {
            unidadesGas.agregarUnidades(nuevasUnidades);
        } else if (recursos instanceof Minerales) {
            unidadesMineral.agregarUnidades(nuevasUnidades);
        }
    }

    public void restarGas(int cantidad) {
        unidadesGas.restar(cantidad);
    }
    
    public void restarMinerales(int cantidad) {
        unidadesMineral.restar(cantidad);
    }
*/
}
