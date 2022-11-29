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

    public BarraDelMenu(Stage stage){
        Menu menuArchivo = new Menu("Archivo");
        Menu menuTutoriales = new Menu("Tutoriales");
        Menu menuCreditos = new Menu("Créditos");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem zergTuto = new MenuItem("Los Zerg");
        MenuItem protossTuto = new MenuItem("Los Protoss");
        MenuItem sobreNosotros = new MenuItem("Sobre nosotros...");

        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirEventHandler);

        OpcionZergTutoEventHandler opcionZergTutoEventHandler = new OpcionZergTutoEventHandler();
        zergTuto.setOnAction(opcionZergTutoEventHandler);

        OpcionProtossTutoEventHandler opcionProtossTutoEventHandler = new OpcionProtossTutoEventHandler();
        protossTuto.setOnAction(opcionProtossTutoEventHandler);

        OpcionSobreNosotros opcionSobreNosotros = new OpcionSobreNosotros();
        protossTuto.setOnAction(opcionSobreNosotros);

        menuArchivo.getItems().addAll(opcionSalir);
        menuTutoriales.getItems().addAll(zergTuto,protossTuto);
        menuCreditos.getItems().addAll(sobreNosotros);

        this.getMenus().addAll(menuArchivo,menuTutoriales,menuCreditos);

    }

}
