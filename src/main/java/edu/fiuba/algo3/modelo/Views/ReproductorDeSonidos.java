package edu.fiuba.algo3.modelo.Views;

import java.net.URISyntaxException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReproductorDeSonidos {

    MediaPlayer control;

    private Media extraerSonido(String directorioDelArchivo) {
        try {
            return new Media(getClass().getResource(directorioDelArchivo).toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return new Media("");
        }
    }

    public void reproducirSonido(String directorioDelArchivo, boolean loop) {
        Media media = this.extraerSonido(directorioDelArchivo);
        control = new MediaPlayer(media);
        if (loop) {
            Runnable onEnd = new Runnable() {
                @Override
                public void run() {
                    control.dispose();
                    control = new MediaPlayer(media);
                    control.play();
                    control.setOnEndOfMedia(this);
                }
            };
            control.setOnEndOfMedia(onEnd);
        }
        control.setAutoPlay(true);
        control.setOnReady(() -> {
            control.play();
        });
    }

}