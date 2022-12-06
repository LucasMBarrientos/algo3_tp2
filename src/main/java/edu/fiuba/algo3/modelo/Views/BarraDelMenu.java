package edu.fiuba.algo3.modelo.Views;

import edu.fiuba.algo3.modelo.Views.eventos.topMenu.OpcionProtossTutoEventHandler;
import edu.fiuba.algo3.modelo.Views.eventos.topMenu.OpcionSalirEventHandler;
import edu.fiuba.algo3.modelo.Views.eventos.topMenu.OpcionSobreNosotros;
import edu.fiuba.algo3.modelo.Views.eventos.topMenu.OpcionZergTutoEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDelMenu extends MenuBar {

    public BarraDelMenu(Stage stage) {
        this.getMenus().addAll(
            crearMenuDeArchivos(),
            crearMenuDeTutoriales(),
            crearMenuDeCreditos()
        );
    }

    private Menu crearMenuDeCreditos() {
        Menu menuDeCreditos = new Menu("Créditos");
        menuDeCreditos.getItems().add(crearOpcionSobreNosotros());
        return menuDeCreditos;
    }

    private MenuItem crearOpcionSobreNosotros() {
        MenuItem opcionSobreNosotros = new MenuItem("Sobre nosotros...");
        OpcionSobreNosotros opcionSobreNosotrosHandler = new OpcionSobreNosotros();
        opcionSobreNosotros.setOnAction(opcionSobreNosotrosHandler);
        return opcionSobreNosotros;
    }

    private Menu crearMenuDeTutoriales() {
        Menu menuDeTutoriales = new Menu("Tutoriales");
        menuDeTutoriales.getItems().addAll(
            crearOpcionTutorialZerg(),
            crearOpcionDeTutorialProtoss()
        );
        return menuDeTutoriales;
    }

    private MenuItem crearOpcionTutorialZerg() {
        MenuItem zergTuto = new MenuItem("Los Zerg");
        OpcionZergTutoEventHandler opcionZergTutoEventHandler = new OpcionZergTutoEventHandler();
        zergTuto.setOnAction(opcionZergTutoEventHandler);
        return zergTuto;
    }

    private MenuItem crearOpcionDeTutorialProtoss() {
        MenuItem protossTuto = new MenuItem("Los Protoss");
        OpcionProtossTutoEventHandler opcionProtossTutoEventHandler = new OpcionProtossTutoEventHandler();
        protossTuto.setOnAction(opcionProtossTutoEventHandler);
        return protossTuto;
    }

    private Menu crearMenuDeArchivos() {
        Menu menuDeArchivos = new Menu("Archivo");
        menuDeArchivos.getItems().add(crearOpcionParaSalir());
        return menuDeArchivos;
    }

    private MenuItem crearOpcionParaSalir() {
        MenuItem opcionParaSalir = new MenuItem("Salir");
        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        opcionParaSalir.setOnAction(opcionSalirEventHandler);
        return opcionParaSalir;
    }

}
