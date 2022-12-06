package edu.fiuba.algo3.modelo.Views;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReproductorDeSonidos {

    private Media extraerSonido(String directorioDelArchivo) {
        try {
            return new Media(getClass().getResource(directorioDelArchivo).toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new Media("");
        }
    }

    public void reproducirSonido(String directorioDelArchivo) {
        reproducirSonido(this.extraerSonido(directorioDelArchivo));
    }

    public void reproducirSonido(Media sonido) {
        MediaPlayer control = new MediaPlayer(sonido);
        control.setCycleCount(MediaPlayer.INDEFINITE);
        control.setAutoPlay(true);
        control.setOnReady(() -> {
            control.play();
        });
    }

}